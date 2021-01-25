/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.zainulrifqi.latihanmvcjdbc.model;

import edu.zainulrifqi.latihanmvcjdbc.database.KingBarbershopDatabase;
import edu.zainulrifqi.latihanmvcjdbc.entity.Pelanggan;
import edu.zainulrifqi.latihanmvcjdbc.error.PelangganException;
import edu.zainulrifqi.latihanmvcjdbc.event.PelangganListener;
import edu.zainulrifqi.latihanmvcjdbc.service.PelangganDao;
import java.sql.SQLException;

/**
 *
 * @author Zainul Rifqi
 *  Nama  : Zainul Rifqi Muwaffaq
    NIM   : 10119082
    Kelas : IF2
    Latihan MVC JDBC
 */
public class PelangganModel {
    
    private int id;
    private String nama;
    private String alamat;
    private String telepon;
    private String email;
    
    private PelangganListener listener;

    public PelangganListener getListener() {
        return listener;
    }

    public void setListener(PelangganListener listener) {
        this.listener = listener;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        fireOnChange();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
        fireOnChange();
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
        fireOnChange();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        fireOnChange();
    }
    
    public void fireOnChange(){
        if (listener!=null) {
            listener.onChange(this);
        }
    }
    
    public void fireOnInsert(Pelanggan pelanggan){
        if (listener!=null) {
            listener.onInsert(pelanggan);
        }
    }
    
    public void fireOnUpdate(Pelanggan pelanggan){
        if (listener!=null) {
            listener.onUpdate(pelanggan);
        }
    }
    
    public void fireOnDelete(){
        if (listener!=null) {
            listener.onDelete();
        }
    }
    
    public void insertPelanggan() throws SQLException, PelangganException {
        
        PelangganDao dao = KingBarbershopDatabase.getPelangganDao();
        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setTelepon(telepon);
        pelanggan.setEmail(email);
        
        dao.insertPelanggan(pelanggan);
        fireOnInsert(pelanggan);
    }
    
    public void updatePelanggan() throws SQLException, PelangganException {
        
        PelangganDao dao = KingBarbershopDatabase.getPelangganDao();
        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setTelepon(telepon);
        pelanggan.setEmail(email);
        pelanggan.setId(id);
        
        dao.updatePelanggan(pelanggan);
        fireOnUpdate(pelanggan);
    }
    
    public void deletePelanggan() throws SQLException, PelangganException {
        
        PelangganDao dao = KingBarbershopDatabase.getPelangganDao();
 
        dao.deletePelanggan(id);
        fireOnDelete();
    }
    
    public void resetPelanggan() {
        setId(0);
        setNama("");
        setAlamat("");
        setTelepon("");
        setEmail("");
    }
}
