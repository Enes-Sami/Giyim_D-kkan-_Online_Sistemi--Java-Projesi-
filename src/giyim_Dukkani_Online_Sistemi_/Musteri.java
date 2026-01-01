package giyim_Dukkani_Online_Sistemi_;

public class Musteri extends Kullanici implements Alisveris_islemleri {

	private double para;
    private Sepet sepet;
	private String mail;
	private String numara;

    public Musteri(int id, String ad, String soyad, String numara, String mail, String sifre, double para) {
        super(id, ad, soyad, sifre);
        this.numara = numara;
        this.mail = mail;
        this.para = para;
        this.sepet = new Sepet();
    }
    
    
    @Override
    public void girisYap() {
        System.out.println("Musteri girisi basarili");
    }

    
    
    @Override
    public void sepeteEkle(Urun a) {
        if (a.getKalan() > 0) {
            sepet.uEkle(a);
            System.out.println("Ürün sepete eklendi.");
        } else {
            System.out.println("İstediğiniz üründen kalmamıştır.");
        }
    }

    
    
    @Override
    public void sepettenCikar(Urun a) {
        sepet.uCikar(a);
    }

    
    
    @Override
    public void satinAl() {
        double toplam = sepet.toplamFiyat();
        System.out.println("Toplam Tutar: " + toplam + " TL");

        if (para >= toplam) {
            para -= toplam;

            for (Urun a : sepet.getUrunler()) {
                a.kalanAzalt();
            }

            sepet.temizle();
            System.out.println("Satin alma basarili");
        } else {
            System.out.println("Yetersiz bakiye");
        }
    }
}
