package giyim_Dukkani_Online_Sistemi_;

import java.util.ArrayList;

public class Sepet {

    private ArrayList<Urun> urunler;

    
    public Sepet() {
        urunler = new ArrayList<>();
    }

    
    public void uEkle(Urun a) {
        urunler.add(a);
    }

    
    public void uCikar(Urun a) {
        urunler.remove(a);
    }

    
    public double toplamFiyat() {
        double toplam = 0;
        for (int i = 0; i < urunler.size(); i++) {
            toplam += urunler.get(i).getFiyat();
        }
        return toplam;
    }

    
    
    public ArrayList<Urun> getUrunler() {
        return urunler;
    }

    
    
    public void temizle() {
        urunler.clear();
    }
}
