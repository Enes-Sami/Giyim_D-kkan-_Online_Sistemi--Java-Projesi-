package GiyimOnlineSistem_OS_gui;

import javax.swing.*;

public class AdminLoginGui extends JFrame {

    public AdminLoginGui() {

        setTitle("Admin Girisi");
        setSize(350,200);
        setLayout(null);

        JLabel labelSifre = new JLabel("Şifre: ");
        JPasswordField yaziSifre = new JPasswordField();
        JButton Giris = new JButton("Giris");

        labelSifre.setBounds(50,40,100,25);
        yaziSifre.setBounds(120,40,150,25);
        Giris.setBounds(120,90,100,30);

        add(labelSifre);
        add(yaziSifre);
        add(Giris);

        Giris.addActionListener(e -> {
            String sifre = new String(yaziSifre.getPassword()).trim();

            if("admin123".equals(sifre)) {
                new AdminGui().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null,"Şifre hatalı");
            }
        });
    }
}
