/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.zainulrifqi.latihanmvcjdbc.main;

import edu.zainulrifqi.latihanmvcjdbc.database.KingBarbershopDatabase;
import edu.zainulrifqi.latihanmvcjdbc.entity.Pelanggan;
import edu.zainulrifqi.latihanmvcjdbc.error.PelangganException;
import edu.zainulrifqi.latihanmvcjdbc.service.PelangganDao;
import edu.zainulrifqi.latihanmvcjdbc.view.MainViewPelanggan;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Zainul Rifqi
 *  Nama  : Zainul Rifqi Muwaffaq
    NIM   : 10119082
    Kelas : IF2
    Latihan MVC JDBC
 */
public class PBOIF210119082LatihanMVCJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, PelangganException {
        // TODO code application logic here
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainViewPelanggan pelanggan = new MainViewPelanggan();
                    pelanggan.loadDatabase();
                    pelanggan.setVisible(true);
                } catch (SQLException e) {
                } catch (PelangganException ex) {
                    Logger.getLogger(PBOIF210119082LatihanMVCJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}
