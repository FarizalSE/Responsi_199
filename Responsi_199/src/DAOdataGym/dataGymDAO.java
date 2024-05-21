/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdataGym;
import DAOImplements.*;
import com.mysql.cj.xdevapi.Statement;
import com.sun.jdi.connect.spi.Connection;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;
import koneksi.connect;
import java.sql.SQLException;
import java.sql.*;
import model.*;

/**
 *
 * @author Lab Informatika
 */
public class dataGymDAO implements dataGymImplements {
    Connection connection;
    
    final String select = "SELECT * FROM gym;";
    final String insert = "INSERT INTO gym (nama,alat,no_telp,sewa,bayar) VALUES(?,?,?,?,?);";
    final String update = "update gym set nama=?, alat=?, no_telp=?, sewa=? where nama=?;";
    final String delete = "delete from gym where nama=?;";
    
    public dataGymDAO() {
        connection = connect.connection();
    }
    
    @Override
    public List<DataGym>getAllGym() {
        List<DataGym> dz = null;
        try {
            dz = new ArrayList<>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                DataGym gym = new DataGym();
                gym.setNama(rs.getString("nama"));
                gym.setAlat(rs.getString("alat"));
                gym.setNo_Telp(rs.getString("no_telp"));
                gym.setSewa(rs.getInt("sewa"));
                gym.setBayar(rs.getDouble("bayar"));
                dz.add(gym);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataGym.class.getName().log(Level.SEVERE, null, ex));
        }
        return dz;
    } 
    
    @Override
    public void insert(DataGym m) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,m.getNama());
            statement.setString(2,m.getAlat());
            statement.setString(3,m.getNo_Telp());
            statement.setInt(4,m.getSewa());
            statement.setDouble(5, m.getBayar());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void update(DataGym m) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,m.getNama());
            statement.setString(2,m.getAlat());
            statement.setString(3,m.getNo_Telp());
            statement.setInt(4,m.getSewa());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void delete(String Nama) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1,Nama);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    
}
