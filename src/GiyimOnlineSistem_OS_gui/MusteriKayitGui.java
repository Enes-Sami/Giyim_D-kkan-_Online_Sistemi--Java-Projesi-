package GiyimOnlineSistem_OS_gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class MusteriKayitGui extends JFrame {

    public MusteriKayitGui() {

        setTitle("Müşteri Kayıt Olma");
        setSize(400,350);
        setLayout(null);

        JLabel labelId = new JLabel("ID:");
        JTextField yaziId = new JTextField();
        JLabel labelAd = new JLabel("Ad:");
        JTextField yaziAd = new JTextField();
        JLabel labelSoyad = new JLabel("Soyad:");
        JTextField yaziSoyad = new JTextField();
        JLabel labelSifre = new JLabel("Şifre: ");
        JPasswordField yaziSifre = new JPasswordField();
        JLabel labelEmail = new JLabel("E-Posta: ");
        JTextField yaziEmail = new JTextField();
        JLabel labelTelefon = new JLabel("Telefon: ");
        JTextField yaziTelefon = new JTextField();
        JLabel labelPara = new JLabel("Bakiye: ");
        JTextField yaziPara = new JTextField();
        JButton butonKayit = new JButton("Kayıt ol");

        labelId.setBounds(30,20,100,25);
        yaziId.setBounds(140,20,200,25);
        labelAd.setBounds(30,55,100,25);
        yaziAd.setBounds(140,55,200,25);
        labelSoyad.setBounds(30,90,100,25);
        yaziSoyad.setBounds(140,90,200,25);
        labelSifre.setBounds(30,125,100,25);
        yaziSifre.setBounds(140,125,200,25);
        labelEmail.setBounds(30,160,100,25);
        yaziEmail.setBounds(140,160,200,25);
        labelTelefon.setBounds(30,195,100,25);
        yaziTelefon.setBounds(140,195,200,25);
        labelPara.setBounds(30,230,100,25);
        yaziPara.setBounds(140,230,200,25);
        butonKayit.setBounds(140,280,120,30);

        add(labelId); 
        add(yaziId);
        add(labelAd);
        add(yaziAd);
        add(labelSoyad); 
        add(yaziSoyad);
        add(labelSifre);
        add(yaziSifre);
        add(labelEmail);
        add(yaziEmail);
        add(labelTelefon);
        add(yaziTelefon);
        add(labelPara);
        add(yaziPara);
        add(butonKayit);

        butonKayit.addActionListener(e -> {
            try {
                Connection c = DBConnection.baglan();

                PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO musteri (id, ad, soyad, email, telefon, para, sifre) VALUES (?,?,?,?,?,?,?)"
                );

                ps.setInt(1, Integer.parseInt(yaziId.getText()));      // ID
                ps.setString(2, yaziAd.getText());                     // ad
                ps.setString(3, yaziSoyad.getText());                  // soyad
                ps.setString(4, yaziEmail.getText());                  // email
                ps.setString(5, yaziTelefon.getText());                // telefon
                ps.setDouble(6, Double.parseDouble(yaziPara.getText())); // para
                ps.setString(7, new String(yaziSifre.getPassword()));  // sifre

                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Kayıt başarılı!");
                new MusteriGui(Integer.parseInt(yaziId.getText())).setVisible(true);
                dispose();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
    }
}
       
