/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import com.sun.jdi.connect.spi.Connection;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.SQLException;

/**
 *
 * @author Lab Informatika
 */
public class connect {
    static Connection con;
    
    public static Connection connection() {
        if(con==null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("gym");
            data.setUser("root");
            data.setPassword("");
            try {
                con = (Connection) data.getConnection();
                System.out.println("Koneksi berhasil!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Koneksi gagal!");
            }
        }
        return null;
    }
}
