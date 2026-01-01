package GiyimOnlineSistem_OS_gui;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static final String URL = "jdbc:mysql://localhost:3306/Giyim_Dukkani_Online";
    static final String USER = "root";
    static final String PASS = "mySqlpasword123.";

    public static Connection baglan() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
