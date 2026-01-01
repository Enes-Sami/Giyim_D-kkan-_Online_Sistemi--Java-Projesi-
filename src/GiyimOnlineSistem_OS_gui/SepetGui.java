package GiyimOnlineSistem_OS_gui;

import javax.swing.*;
import java.sql.*;

public class SepetGui extends JFrame {

    int musteriId;
    JTextArea alan;
    
    public SepetGui(int musteriId) {
        this.musteriId = musteriId;

        setTitle("Sepetim");
        setSize(350,250);
        setLayout(null);

        JButton butunEkle = new JButton("Sepete ürün ekle");
        JButton butunSatinAl = new JButton("Satın al");
        alan = new JTextArea();
        JScrollPane sp = new JScrollPane(alan);
        
        butunEkle.setBounds(90,50,160,30);
        butunSatinAl.setBounds(90,100,160,30);
        sp.setBounds(20,20,350,150);
        
        add(butunEkle);
        add(butunSatinAl);
        add(sp);
        
        butunEkle.addActionListener(e -> sepeteEkle());
        butunSatinAl.addActionListener(e -> satinAl());
    }

    
    void sepeteEkle() {
        String urunId = JOptionPane.showInputDialog("Ürün ID:");
        try {
            Connection c = DBConnection.baglan();
            Statement s = c.createStatement();
            s.executeUpdate(
                "INSERT INTO sepet_urun VALUES(" +
                musteriId + "," + urunId + ")"
            );
            sepetiGoster();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null,"Ürün eklenemedi");
        }
    }
    
    

    void sepetiGoster() {
        try {
            Connection c = DBConnection.baglan();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(
                "SELECT u.urun_tipi, u.marka " +
                "FROM sepet_urun su " +
                "JOIN urun u ON su.urun_id = u.id " +
                "WHERE su.sepet_id = " + musteriId
            );

            alan.setText("");
            while(r.next()) {
                alan.append(
                    r.getString("urun_tipi") + " | " +
                    r.getString("marka") + "\n"
                );
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null,"Sepet gösterilemedi");
        }
    }


    
    void satinAl() {
        try {
            Connection c = DBConnection.baglan();
            Statement s = c.createStatement();

            ResultSet r = s.executeQuery(
                "SELECT SUM(u.fiyat) toplam " +
                "FROM sepet_urun su " +
                "JOIN urun u ON su.urun_id = u.id " +
                "WHERE su.sepet_id = " + musteriId
            );

            if(r.next()) {
                double toplam = r.getDouble("toplam");

                s.executeUpdate(
                    "UPDATE musteri SET para = para - " + toplam +
                    " WHERE id = " + musteriId
                );

                s.executeUpdate(
                    "UPDATE urun u JOIN sepet_urun su ON u.id = su.urun_id " +
                    "SET u.stok = u.stok - 1 WHERE su.sepet_id = " + musteriId
                );

                s.executeUpdate(
                    "DELETE FROM sepet_urun WHERE sepet_id = " + musteriId
                );
            }

            JOptionPane.showMessageDialog(null,"Satın alma tamamlandı");
            dispose();

        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null,"Satın alma hatası");
        }
    }
}
