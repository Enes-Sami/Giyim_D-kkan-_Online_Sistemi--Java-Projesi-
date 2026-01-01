package GiyimOnlineSistem_OS_gui;

import javax.swing.*;
import java.sql.*;

public class UrunEkleGui extends JFrame {

    public UrunEkleGui() {

        setTitle("Yeni Ürün Ekle");
        setSize(400,400);
        setLayout(null);

        JLabel lId = new JLabel("Ürün ID:");
        JTextField tId = new JTextField();

        JLabel lTip = new JLabel("Ürün Tipi:");
        JTextField tTip = new JTextField();

        JLabel lMarka = new JLabel("Marka:");
        JTextField tMarka = new JTextField();

        JLabel lMalzeme = new JLabel("Malzeme:");
        JTextField tMalzeme = new JTextField();

        JLabel lBeden = new JLabel("Beden:");
        JTextField tBeden = new JTextField();

        JLabel lFiyat = new JLabel("Fiyat:");
        JTextField tFiyat = new JTextField();

        JLabel lStok = new JLabel("Stok:");
        JTextField tStok = new JTextField();

        JCheckBox cbOrijinal = new JCheckBox("Orijinal mi?");
        JButton ekle = new JButton("Ürünü Ekle");

        lId.setBounds(30,20,100,25);     tId.setBounds(140,20,200,25);
        lTip.setBounds(30,55,100,25);    tTip.setBounds(140,55,200,25);
        lMarka.setBounds(30,90,100,25);  tMarka.setBounds(140,90,200,25);
        lMalzeme.setBounds(30,125,100,25);tMalzeme.setBounds(140,125,200,25);
        lBeden.setBounds(30,160,100,25); tBeden.setBounds(140,160,200,25);
        lFiyat.setBounds(30,195,100,25); tFiyat.setBounds(140,195,200,25);
        lStok.setBounds(30,230,100,25);  tStok.setBounds(140,230,200,25);
        cbOrijinal.setBounds(140,260,150,25);
        ekle.setBounds(140,300,120,30);

        add(lId); add(tId);
        add(lTip); add(tTip);
        add(lMarka); add(tMarka);
        add(lMalzeme); add(tMalzeme);
        add(lBeden); add(tBeden);
        add(lFiyat); add(tFiyat);
        add(lStok); add(tStok);
        add(cbOrijinal);
        add(ekle);

        ekle.addActionListener(e -> {
            try {
                Connection c = DBConnection.baglan();
                PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO urun VALUES (?,?,?,?,?,?,?,?)"
                );

                ps.setInt(1, Integer.parseInt(tId.getText()));
                ps.setString(2, tTip.getText());
                ps.setString(3, tMarka.getText());
                ps.setString(4, tMalzeme.getText());
                ps.setString(5, tBeden.getText());
                ps.setDouble(6, Double.parseDouble(tFiyat.getText()));
                ps.setInt(7, Integer.parseInt(tStok.getText()));
                ps.setBoolean(8, cbOrijinal.isSelected());

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Ürün eklendi");
                dispose();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
    }
}
