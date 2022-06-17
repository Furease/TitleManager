package titlemanager.model;

/**
 * Class Project untuk membungkus data project. 
 * 
 * @author Fure
 */
public class Project {
    int     id;
    String  judul;
    String  abstrak;
    String  nim;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getAbstrak() {
        return abstrak;
    }

    public void setAbstrak(String abstrak) {
        this.abstrak = abstrak;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
    
    
    
}
