/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.akhir;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Fure
 */
public class UserProfiles implements Serializable {
    private String nim, nama, email, nomor;
    // private ArrayList<String> judul, abstrak;

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    // public ArrayList<String> getJudul() {
    //     return judul;
    // }

    // public void setJudul(ArrayList<String> judul) {
    //     this.judul = judul;
    // }

    // public ArrayList<String> getAbstrak() {
    //     return abstrak;
    // }

    // public void setAbstrak(ArrayList<String> abstrak) {
    //     this.abstrak = abstrak;
    // }
}
