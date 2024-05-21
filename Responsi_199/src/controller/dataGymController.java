/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAOdataGym.dataGymDAO;
import DAOImplements.dataGymImplements;
import javax.swing.JOptionPane;
import model.*;
import view.MainView;

/**
 *
 * @author Lab Informatika
 */
public class dataGymController {
    MainView frame;
    dataGymImplements impldatagym;
    List<DataGym>dz,dp;
    
    public dataGymController(MainView frame) {
        this.frame = frame;
        impldatagym = new dataGymDAO();
        dz = impldatagym.getAllGym();
    }
    
    public void isiTabel () {
        dz = impldatagym.getAllGym();
        
    }
}
