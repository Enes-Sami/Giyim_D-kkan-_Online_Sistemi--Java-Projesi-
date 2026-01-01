package giyim_Dukkani_Online_Sistemi_;

public class Test {

    public static void main(String[] args) {

        Urun a1 = new Urun("Gömlek",       "Buggaman","Pamuk","M", 900, 10,false);
        Urun a2 = new Urun("Kot Ceket",    "Levays",  "Kot",  "L", 3900,5, true);
        Urun a3 = new Urun("Kot Pantolon", "Antioch", "Kot",  "XS",600, 7, false);
        Urun a4 = new Urun("Spor Ayakkabı","Abibas",  "Deri", "36",2100,3, true);

        Musteri b1 = new Musteri(100, "Enes Sami", "GUZEL", "kucukPatron@gmail.com", "05153955631", "1234", 1000);
        Musteri b2 = new Musteri(101, "Bedo",      "CAM",   "deliCocuk@gmail.com",   "05347643031", "1234", 2700);
        Musteri b3 = new Musteri(102, "Omer",      "CAM",   "Omar42@gmail.com",      "05714340631", "1234", 5000);

        b1.girisYap();
        b1.sepeteEkle(a1);
        b1.sepeteEkle(a3);
        b1.satinAl();

        b2.girisYap();
        b2.sepeteEkle(a2);

        b3.girisYap();
        b3.sepeteEkle(a4);
    }
}
