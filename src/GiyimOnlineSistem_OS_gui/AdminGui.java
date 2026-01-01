package GiyimOnlineSistem_OS_gui;

import javax.swing.*;
import java.sql.*;

public class AdminGui extends JFrame {

    JTextArea alan;

    public AdminGui() {
        setTitle("Admin Kontrol Paneli");
        setSize(500,400);
        setLayout(null);

        JButton butunUrunler = new JButton("Ürünleri listele");
        JButton butunMusteriler = new JButton("Müşterileri listele");
        JButton butunStok = new JButton("Stokları artır");
        JButton butunUrunEkle = new JButton("Yeni ürün ekle");
        JButton Cikis = new JButton("Çıkış");
        alan = new JTextArea();

        butunUrunler.setBounds(30,20,180,30);
        butunMusteriler.setBounds(250,20,200,30);
        butunStok.setBounds(30,60,180,30);
        butunUrunEkle.setBounds(30,100,180,30);
        Cikis.setBounds(250,60,200,30);
        alan.setBounds(30,110,420,220);

        add(butunUrunler);
        add(butunMusteriler);
        add(butunStok);
        add(butunUrunEkle);
        add(Cikis);
        add(alan);

        butunUrunler.addActionListener(e -> urunleriGetir());
        butunMusteriler.addActionListener(e -> musterileriGetir());
        butunUrunEkle.addActionListener(e -> new UrunEkleGui().setVisible(true));
        butunStok.addActionListener(e -> stokArtir());
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
                	r.getString("marka") + " Marka | " +
                	r.getString("malzeme") + " | " +
                	r.getString("beden") + " | " +
                	r.getDouble("fiyat") + " TL | " +
                	"Stokta kalan: " + r.getInt("stok") + "\n"
                );
            }
        } catch(Exception ex) {}
    }

    void musterileriGetir() {
        try {
            Connection c = DBConnection.baglan();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM musteri");

            alan.setText("");
            while(r.next()) {
                alan.append(
                	r.getInt("id") + " | isim:" + 
                	r.getString("ad") + " " +
                	r.getString("soyad") + " | " +
                	r.getString("email") + " | " +
                	r.getString("telefon") + " | " +
                	r.getDouble("para") + " TL\n"
                );
            }
        } catch(Exception ex) {}
    }

    void stokArtir() {
        String id = JOptionPane.showInputDialog("Ürün id:");
        String adet = JOptionPane.showInputDialog("Ne kadar ürün eklenecek: ");

        try {
            Connection c = DBConnection.baglan();
            Statement s = c.createStatement();
            s.executeUpdate(
                "UPDATE urun SET stok = stok + " + adet +
                " WHERE id = " + id
            );
            JOptionPane.showMessageDialog(null,"Stok artırıldı.");
        } catch(Exception ex) {}
    }
}
