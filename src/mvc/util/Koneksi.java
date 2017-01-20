package mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 15312629
 */
public class Koneksi {

    public Statement state;
    private Connection connect;
    String namaDatabase = "jdbc:mysql://localhost/db_uas_15312629";

    public void koneksiDatabase() {
        try {
            connect = DriverManager.getConnection(namaDatabase, "root", "123");
            state = connect.createStatement();
            System.out.println("Koneksi Terhubung");
        } catch (SQLException e) {
            System.err.println("Error! " + e);
        }
    }

}
