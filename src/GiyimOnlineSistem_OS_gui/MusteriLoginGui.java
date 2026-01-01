package GiyimOnlineSistem_OS_gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class MusteriLoginGui extends JFrame {

    public MusteriLoginGui() {

        setTitle("Müşteri Girişi");
        setSize(350,250);
        setLayout(null);

        JLabel labelAd = new JLabel("Ad:");
        JTextField yaziAd = new JTextField();
        JLabel labelSoyad = new JLabel("Soyad:");
        JTextField yaziSoyad = new JTextField();
        JLabel labelSifre = new JLabel("Şifre: ");
        JPasswordField yaziSifre = new JPasswordField();
        JButton Giris = new JButton("Giriş");

        labelAd.setBounds(40,30,100,25);
        yaziAd.setBounds(150,30,150,25);
        labelSoyad.setBounds(40,65,100,25);
        yaziSoyad.setBounds(150,65,150,25);
        labelSifre.setBounds(40,100,100,25);
        yaziSifre.setBounds(150,100,150,25);
        Giris.setBounds(120,150,100,30);

        add(labelAd);
        add(yaziAd);
        add(labelSoyad);
        add(yaziSoyad);
        add(labelSifre);
        add(yaziSifre);
        add(Giris);


        Giris.addActionListener(e -> {
        	try {
                Connection c = DBConnection.baglan();
                PreparedStatement ps = c.prepareStatement("SELECT id FROM musteri WHERE ad=? AND soyad=? AND sifre=?" );

                ps.setString(1, yaziAd.getText());
                ps.setString(2, yaziSoyad.getText());
                ps.setString(3, new String(yaziSifre.getPassword()));

                ResultSet r = ps.executeQuery();
                
            if(r.next()) {
                new MusteriGui(r.getInt("id")).setVisible(true);
                dispose();
            } else {JOptionPane.showMessageDialog(null,
                    "Girilen bilgilerde yanlışlık var.");
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null,"Veritabanı hatası");
        }
    });
}
}
