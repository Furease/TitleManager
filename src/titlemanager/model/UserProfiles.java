package titlemanager.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class UserProfiles untuk menyimpan data user profiles.
 * 
 * @author Fure
 */
public class UserProfiles implements Serializable {
    private String nim;
    private String nama;
    private String email;
    private String nomor;

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
}
