package GiyimOnlineSistem_OS_gui;

import javax.swing.*;
import java.sql.*;

public class MusteriGui extends JFrame {

    int musteriId;
    JTextArea alan;

    public MusteriGui(int musteriId) {
        this.musteriId = musteriId;

        setTitle("Zevkiş Giyim Sanal Dükkanı");
        setSize(500,400);
        setLayout(null);

        JButton butunUrunler = new JButton("Ürünleri göster");
        JButton butunSepet = new JButton("Sepete git");
        JButton Cikis = new JButton("Çıkış");

        alan = new JTextArea();

        butunUrunler.setBounds(40,30,150,30);
        butunSepet.setBounds(220,30,150,30);
        Cikis.setBounds(400,30,80,30);

        alan.setBounds(40,80,420,260);

        add(butunUrunler);
        add(butunSepet);
        add(Cikis);
        add(alan);

        butunUrunler.addActionListener(e -> urunleriGetir());
        butunSepet.addActionListener(e -> new SepetGui(musteriId).setVisible(true));
        Cikis.addActionListener(e -> dispose());
    }

    void urunleriGetir() {
        try {
            Connection c = DBConnection.baglan();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM urun");

            alan.setText("");
            while(r.next()) {
                alan.append(
                    r.getInt("id") + " | " +
                    r.getString("urun_tipi") + " | " +
                    r.getDouble("fiyat") + " TL\n"
                );
            }
        } catch(Exception ex) {}
    }
}
