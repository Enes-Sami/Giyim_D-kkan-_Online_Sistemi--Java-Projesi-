package MySql_OS_giyimOnlineSistemi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class tableCreate {

    static final String DB_URL = "sql uzantısı/Giyim_Dukkani_Online";
    static final String USER = "kullanıcı adı";
    static final String PASS = "şifre";

    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stm = conn.createStatement();

        String musteri =
                "CREATE TABLE musteri (" +
                "id INTEGER NOT NULL ," +
                "ad VARCHAR(40)," +
                "soyad VARCHAR(40)," +
                "email VARCHAR(50)," +
                "telefon VARCHAR(15)," +
                "para DOUBLE," +
                "sifre VARCHAR(20)," +
                "PRIMARY KEY (id))";

        String urun =
                "CREATE TABLE urun (" +
                "id INTEGER NOT NULL," +
                "urun_tipi VARCHAR(40)," +
                "marka VARCHAR(40)," +
                "malzeme VARCHAR(40)," +
                "beden VARCHAR(10)," +
                "fiyat DOUBLE," +
                "stok INT," +
                "orijinal BOOLEAN," +
                "PRIMARY KEY (id))";

        String sepet =
                "CREATE TABLE sepet (" +
                "id INTEGER NOT NULL," +
                "musteri_id INT," +
                "PRIMARY KEY (id))";

        String sepetUrun =
                "CREATE TABLE sepet_urun (" +
                "sepet_id INT," +
                "urun_id INT)";

        stm.executeUpdate(musteri);
        stm.executeUpdate(urun);
        stm.executeUpdate(sepet);
        stm.executeUpdate(sepetUrun);
        stm.executeUpdate("DELETE FROM musteri WHERE id IS NULL");
        stm.executeUpdate("DELETE FROM urun WHERE id IS NULL");


        System.out.println("Tablolar olusturuldu");
    }
}
