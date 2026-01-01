package giyim_Dukkani_Online_Sistemi_;

public class Urun {

    private int id;
    private String urunTipi;
    private String marka;
    private String malzeme;
    private String beden;
    private double fiyat;
    private int miktar;
    private boolean orijinal;

    public Urun(String urunTipi, String marka, String malzeme,
                String beden, double fiyat, int miktar, boolean orijinal) {

        this.urunTipi = urunTipi;
        this.marka = marka;
        this.malzeme = malzeme;
        this.beden = beden;
        this.fiyat = fiyat;
        this.miktar = miktar;
        this.orijinal = orijinal;
    }

    public double getFiyat() {
        return fiyat;
    }

    public int getKalan() {
        return miktar;
    }

    public void kalanAzalt() {
        miktar=miktar-1;
    }

    public String getUrunTipi() {
        return urunTipi;
    }
}
