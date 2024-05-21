/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lab Informatika
 */
public class modeltablegym extends AbstractTableModel{
    List<DataGym> dz;
    public modeltablegym(List<DataGym>dz) {
        this.dz = dz;
    }
    
    @Override
    public int getRowCount() {
        return dz.size();
    }
    
    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 :
                return "Nama";
            case 1 :
                return "Alat";
            case 2 :
                return "No_Telp";
            case 3 :
                return "Sewa";
            case 4 :
                return "Bayar";
            default :
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column) {
            case 0 :
                return dz.get(row).getNama();
            case 1 :
                return dz.get(row).getAlat();
            case 2 :
                return dz.get(row).getNo_Telp();
            case 3 :
                return dz.get(row).getSewa();
            case 4 :
                return dz.get(row).getBayar();
            default :
                return null;
        }
    }
}
