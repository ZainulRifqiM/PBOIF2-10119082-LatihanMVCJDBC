/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.zainulrifqi.latihanmvcjdbc.service;

import edu.zainulrifqi.latihanmvcjdbc.entity.Pelanggan;
import edu.zainulrifqi.latihanmvcjdbc.error.PelangganException;
import java.util.List;

/**
 *
 * @author Zainul Rifqi
 *  Nama  : Zainul Rifqi Muwaffaq
    NIM   : 10119082
    Kelas : IF2
    Latihan MVC JDBC
 */
public interface PelangganDao {
    
    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException;
    
    public void updatePelanggan(Pelanggan pelanggan) throws PelangganException;
    
    public void deletePelanggan(Integer id) throws PelangganException;
    
    public Pelanggan getPelanggan(Integer id) throws PelangganException;
    
    public Pelanggan getPelanggan(String email) throws PelangganException;
    
    public List<Pelanggan> selectAllPelanggan() throws PelangganException;
    
}
