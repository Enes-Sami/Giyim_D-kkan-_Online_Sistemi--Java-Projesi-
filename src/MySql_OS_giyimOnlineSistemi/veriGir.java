package MySql_OS_giyimOnlineSistemi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class veriGir {

    static final String DB_URL = "sql uzantısı/Giyim_Dukkani_Online";
    static final String USER = "kullanıcı adı";
    static final String PASS = "şifre";

    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stm = conn.createStatement();


        String a1 = "INSERT INTO urun VALUES(303,'Çizgili Gomlek','Mor'           ,'Pamuk','M' ,900 ,10,false)";
        String a2 = "INSERT INTO urun VALUES(304,'Kot Ceket'     ,'Levays'        ,'Kot'  ,'L' ,3900,5 ,true)";
        String a3 = "INSERT INTO urun VALUES(305,'Kot Pantolon'  ,'Dolca Gabriel' ,'Kot'  ,'XS',600 ,7 ,false)";
        String a4 = "INSERT INTO urun VALUES(306,'Spor Ayakkabi' ,'Abibas'        ,'Deri' ,'36',2100,3 ,true)";

        String b1 = "INSERT INTO musteri VALUES(100,'Enes Sami','GUZEL','kucukPatron@gmail.com','05153955631',1000,'1234')";
        String b2 = "INSERT INTO musteri VALUES(101,'Bedo'     ,'CAM'  ,'deliCocuk@gmail.com'  ,'05347643031',2700,'1234')";
        String b3 = "INSERT INTO musteri VALUES(102,'Omer'     ,'CAM'  ,'Omar42@gmail.com'     ,'05714340631',5000,'1234')";

    
        //stm.executeUpdate("DELETE FROM sepet_urun;");
        //stm.executeUpdate("DELETE FROM sepet;");
        //stm.executeUpdate("DELETE FROM musteri");
        //stm.executeUpdate("DELETE FROM urun");



        stm.executeUpdate(a1);
        stm.executeUpdate(a2);
        stm.executeUpdate(a3);
        stm.executeUpdate(a4);
      
        stm.executeUpdate(b1);
        stm.executeUpdate(b2);
        stm.executeUpdate(b3);
        
        stm.executeUpdate("DELETE FROM musteri WHERE id IS NULL");
        stm.executeUpdate("DELETE FROM urun WHERE id IS NULL");

        System.out.println("Veriler eklendi");
    }
}
