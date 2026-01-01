package MySql_OS_giyimOnlineSistemi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class veriTabani {
    static final String DB_URL = "sql uzantısı/";
    static final String USER = "kullanıcı adı";
    static final String PASS = "şifre";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stm = conn.createStatement();

            String sql = "CREATE DATABASE Giyim_Dukkani_Online";
            stm.executeUpdate(sql);

            System.out.println("Veritabani olusturuldu");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
