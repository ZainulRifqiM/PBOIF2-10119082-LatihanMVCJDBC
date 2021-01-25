/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.zainulrifqi.latihanmvcjdbc.entity;

import java.util.Objects;

/**
 *
 * @author Zainul Rifqi
 *  Nama  : Zainul Rifqi Muwaffaq
    NIM   : 10119082
    Kelas : IF2
    Latihan MVC JDBC
 */
public class Pelanggan {
    
    private Integer Id;
    private String nama,alamat,telepon,email;
    
    public Pelanggan() {
        
    }

    public Pelanggan(String nama, String alamat, String telepon, String email) {
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.email = email;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.Id);
        hash = 73 * hash + Objects.hashCode(this.nama);
        hash = 73 * hash + Objects.hashCode(this.alamat);
        hash = 73 * hash + Objects.hashCode(this.telepon);
        hash = 73 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelanggan other = (Pelanggan) obj;
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.alamat, other.alamat)) {
            return false;
        }
        if (!Objects.equals(this.telepon, other.telepon)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }
    
    
    
}
