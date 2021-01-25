/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.zainulrifqi.latihanmvcjdbc.impl;

import edu.zainulrifqi.latihanmvcjdbc.entity.Pelanggan;
import edu.zainulrifqi.latihanmvcjdbc.error.PelangganException;
import edu.zainulrifqi.latihanmvcjdbc.service.PelangganDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Zainul Rifqi
 *  Nama  : Zainul Rifqi Muwaffaq
    NIM   : 10119082
    Kelas : IF2
    Latihan MVC JDBC
 */
public class PelangganDaoImpl implements PelangganDao{
    
    private Connection connection;
    
    private final String insertPelanggan = "INSERT INTO PELANGGAN (NAMA,ALAMAT,TELEPON,EMAIL) VALUES (?,?,?,?)";
    private final String updatePelanggan = "UPDATE PELANGGAN SET NAMA=?, ALAMAT=?, TELEPON=?, EMAIL=? WHERE ID=?";
    private final String deletePelanggan = "DELETE FROM PELANGGAN WHERE ID=?";
    private final String getById = "SELECT * FROM PELANGGAN WHERE ID=?";
    private final String getByEmail = "SELECT * FROM PELANGGAN WHERE EMAIL=?";
    private final String selectAll = "SELECT * FROM PELANGGAN";

    public PelangganDaoImpl(Connection connection) {
        this.connection = connection; 
    }
    
    

    @Override
    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException {
        PreparedStatement statemant = null;
        try {
            connection.setAutoCommit(false);
            
            statemant =  connection.prepareStatement(insertPelanggan, Statement.RETURN_GENERATED_KEYS);
            statemant.setString(1, pelanggan.getNama());
            statemant.setString(2, pelanggan.getAlamat());
            statemant.setString(3, pelanggan.getTelepon());
            statemant.setString(4, pelanggan.getEmail());
            statemant.executeUpdate();
            
            ResultSet result = statemant.getGeneratedKeys();
            if (result.next()) {
                pelanggan.setId(result.getInt(1));
            }
            
            connection.commit();
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            
            throw new PelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statemant!=null) {
                try {
                statemant.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void updatePelanggan(Pelanggan pelanggan) throws PelangganException {
         PreparedStatement statemant = null;
        try {
            connection.setAutoCommit(false);
            statemant =  connection.prepareStatement(updatePelanggan);
            statemant.setString(1, pelanggan.getNama());
            statemant.setString(2, pelanggan.getAlamat());
            statemant.setString(3, pelanggan.getTelepon());
            statemant.setString(4, pelanggan.getEmail());
            statemant.setInt(5, pelanggan.getId());
            statemant.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            
            throw new PelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statemant!=null) {
                try {
                statemant.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void deletePelanggan(Integer id) throws PelangganException {
         PreparedStatement statemant = null;
        try {
            connection.setAutoCommit(false);
            statemant =  connection.prepareStatement(deletePelanggan);
            statemant.setInt(1, id);
            statemant.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            
            throw new PelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statemant!=null) {
                try {
                statemant.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public Pelanggan getPelanggan(Integer id) throws PelangganException {
        PreparedStatement statemant = null;
        try {
            connection.setAutoCommit(false);
            statemant =  connection.prepareStatement(getById);
            statemant.setInt(1, id);
            ResultSet result =  statemant.executeQuery();
            Pelanggan pelanggan = null;
            
            if (result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
                
            } else {
                throw new PelangganException("Pelanggan dengan id " + id + " tidak ditemukan");
            }
            connection.commit();
            return pelanggan;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            
            throw new PelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statemant!=null) {
                try {
                statemant.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public Pelanggan getPelanggan(String email) throws PelangganException {
        PreparedStatement statemant = null;
        try {
            connection.setAutoCommit(false);
            statemant =  connection.prepareStatement(getByEmail);
            statemant.setString(1, email);
            ResultSet result =  statemant.executeQuery();
            Pelanggan pelanggan = null;
            
            if (result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
                
            } else {
                throw new PelangganException("Pelanggan dengan email " + email + " tidak ditemukan");
            }
            connection.commit();
            return pelanggan;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            
            throw new PelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statemant!=null) {
                try {
                statemant.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public List<Pelanggan> selectAllPelanggan() throws PelangganException {
        Statement statemant = null;
        List<Pelanggan> list = new ArrayList<>();
        
        try {
            connection.setAutoCommit(false);
            statemant =  connection.createStatement();
            ResultSet result =  statemant.executeQuery(selectAll);
            Pelanggan pelanggan = null;
            
            while (result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
                list.add(pelanggan);
            } 
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            
            throw new PelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statemant!=null) {
                try {
                statemant.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
}
