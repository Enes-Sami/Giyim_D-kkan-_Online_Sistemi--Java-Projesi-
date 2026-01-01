package giyim_Dukkani_Online_Sistemi_;

public abstract class Kullanici {

    protected int id;
    protected String ad;
    protected String soyad;
    protected String sifre;

    public Kullanici(int id, String ad, String soyad, String sifre) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.sifre = sifre;
    }

    public abstract void girisYap();
}
