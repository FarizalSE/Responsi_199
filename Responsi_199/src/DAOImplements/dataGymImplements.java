/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplements;
import java.util.List;
import model.*;
/**
 *
 * @author Lab Informatika
 */
public interface dataGymImplements {
    void insert(DataGym m);
    void update(DataGym m);
    void delete(String name);
    public List<DataGym>getAllGym();
}
