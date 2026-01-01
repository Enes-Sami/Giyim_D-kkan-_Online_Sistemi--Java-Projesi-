package GiyimOnlineSistem_OS_gui;

import javax.swing.*;

public class AnaMenuGui extends JFrame {

    public AnaMenuGui() {

        setTitle("Zevkiş Giyim");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JButton butunAdminler = new JButton("Admin Girisi");
        JButton butunMusteriler = new JButton("Musteri Girisi");
        JButton butunKayitlar = new JButton("Musteri Kayit Olma");
        JButton Cikis = new JButton("Cikis");

        butunAdminler.setBounds(120,40,150,30);
        butunMusteriler.setBounds(120,80,150,30);
        butunKayitlar.setBounds(120,120,150,30);
        Cikis.setBounds(120,160,150,30);

        add(butunAdminler);
        add(butunMusteriler);
        add(butunKayitlar);
        add(Cikis);

        butunAdminler.addActionListener(e -> new AdminLoginGui().setVisible(true));
        butunMusteriler.addActionListener(e -> new MusteriLoginGui().setVisible(true));
        butunKayitlar.addActionListener(e -> new MusteriKayitGui().setVisible(true));
        Cikis.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        new AnaMenuGui().setVisible(true);
    }
}
