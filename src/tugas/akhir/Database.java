/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.akhir;

import model.UserProfiles;
import model.Project;
import model.Item;
import model.Account;
import java.io.Serializable;
import java.util.ArrayList;
import java.sql.*;


/**
 *
 * @author Fure
 */
public class Database implements Serializable {
    public static Database instance;

    private final String DB_TYPE = "mysql";
    private final String DB_HOST = "localhost";
    private final String DB_PORT = "3306";
    private final String DB_NAME = "titlemanager";
    private final String DB_USER = "root";
    private final String DB_PASS = "";

    private Database() {
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:" + DB_TYPE + "://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME,
                DB_USER, DB_PASS);
    }

    // public void insertMahasiswa(Mahasiswa mahasiswa) throws SQLException {
    //     Connection conn = getConnection();
    //     try {
    //         String sql = "INSERT INTO mahasiswa VALUES(?, ?, ?, ?, ?, ?, ?)";
    //         PreparedStatement pstmt = conn.prepareStatement(sql);
    //         pstmt.setString(1, mahasiswa.getNim());
    //         pstmt.setString(2, mahasiswa.getNama());
    //         pstmt.setString(3, mahasiswa.getJenisKelamin());
    //         pstmt.setInt(4, mahasiswa.getUmur());
    //         pstmt.setString(5, mahasiswa.getAlamat());
    //         pstmt.setString(6, mahasiswa.getProvinsi());
    //         pstmt.setString(7, String.join(",", mahasiswa.getHobi()));
    //         pstmt.executeUpdate();
    //     } catch (SQLException ex) {
    //         throw ex;
    //     } finally {
    //         if (conn != null) {
    //             conn.close();
    //         }
    //     }
    // }

    public void insertProfile(UserProfiles userProfiles) throws SQLException {
        Connection conn = getConnection();
        try {
            String sql = "INSERT INTO user_profiles VALUES(?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userProfiles.getNim());
            pstmt.setString(2, userProfiles.getNama());
            pstmt.setString(3, userProfiles.getEmail());
            pstmt.setString(4, userProfiles.getNomor());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    public UserProfiles getUserProfiles(String nim) throws SQLException {
        Connection conn = getConnection();
        try {
            String sql = "SELECT * FROM user_profiles WHERE nim = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nim);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                UserProfiles userProfiles = new UserProfiles();
                userProfiles.setNim(rs.getString("nim"));
                userProfiles.setNama(rs.getString("nama"));
                userProfiles.setEmail(rs.getString("email"));
                userProfiles.setNomor(rs.getString("nomor"));
                return userProfiles;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    // update user profile
    public void updateUserProfile(UserProfiles userProfiles) throws SQLException {
        Connection conn = getConnection();
        try {
            String sql = "UPDATE user_profiles SET nama = ?, email = ?, nomor = ? WHERE nim = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userProfiles.getNama());
            pstmt.setString(2, userProfiles.getEmail());
            pstmt.setString(3, userProfiles.getNomor());
            pstmt.setString(4, userProfiles.getNim());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    // delete user profile
    public void deleteUserProfile(String nim) throws SQLException {
        Connection conn = getConnection();
        try {
            String sql = "DELETE FROM user_profiles WHERE nim = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nim);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    // insert project



    //get Project by id
    public Project getProject(int id) throws SQLException {
        Connection conn = getConnection();
        try {
            String sql = "SELECT * FROM project WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setJudul(rs.getString("judul"));
                project.setAbstrak(rs.getString("abstrak"));
                project.setNim(rs.getString("nim"));
                return project;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    // update project
    public void updateProject(Project project) throws SQLException {
        Connection conn = getConnection();
        try {
            String sql = "UPDATE project SET judul = ?, abstrak = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, project.getJudul());
            pstmt.setString(2, project.getAbstrak());
            pstmt.setInt(3, project.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    // delete project
    public void deleteProject(int id) throws SQLException {
        Connection conn = getConnection();
        try {
            String sql = "DELETE FROM project WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    // get array list of judul from searh keyword
    public ArrayList<Item> getJudulByKeyword(String keyword) throws SQLException {
        Connection conn = getConnection();
        try {
            // pisahkan keyword menjadi array
            String[] keywords = keyword.split(" ");
            String sql = "SELECT * FROM project WHERE ";
            for (int i = 0; i < keywords.length; i++) {
                if (i == 0) {
                    sql += "judul LIKE '%" + keywords[i] + "%'";
                } else {
                    sql += " AND judul LIKE '%" + keywords[i] + "%'";
                }
            }

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Item> items = new ArrayList<>();

            while (rs.next()) {
                Item item = new Item();
                int id = rs.getInt("id");
                String judul = rs.getString("judul");
                String[] judulTempSplit = judul.split(" ");
                String judulBold = "";


                // pilih keyword yang sama dengan judul
                for (int i = 0; i < judulTempSplit.length; i++) {
                    for (int j = 0; j < keywords.length; j++) {
                        if (judulTempSplit[i].toLowerCase().contains(keywords[j].toLowerCase()) && !keywords[j].equals("")) {
                            judulBold += judulTempSplit[i] + " ";
                        }
                    }
                }
                
                String[] selectedKeyword = judulBold.split(" ");
                // bold keyword per kata case insensitive
                for (int i = 0; i < selectedKeyword.length; i++) {
                    if (!selectedKeyword[i].equals("")) judul = judul.replace(selectedKeyword[i], "<b>" + selectedKeyword[i] + "</b>");
                }
                item.setValue(id);
                // menambahkan tag html
                item.setDescription("<html>" + judul + "</></html>");
                items.add(item);
            }
            return items;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    // get judul by id
    public String getJudulById(int id) throws SQLException {
        Connection conn = getConnection();
        try {
            String sql = "SELECT judul FROM project WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("judul");
            } else {
                return null;
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }



    // get username and password from database
    public void setUser (String username, String password) throws SQLException {
        Connection conn = getConnection();
        try {
            String sql = "INSERT INTO accounts (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    public Account getUser(String username) throws SQLException {
        Account user = Account.getInstance();
        Connection conn = getConnection();
        try {
            String sql = "SELECT * FROM accounts WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }







    // private ArrayList<Mahasiswa> data = new ArrayList<>();
    
    // private Database(){
    // }
 
    // public static synchronized Database getInstance(){
    //     loadFile();
    //     if(instance == null){
    //         instance = new Database();
    //     }
    //     return instance;
    // }
 
    // public void insertMahasiswa(Mahasiswa mahasiswa){
    //     data.add(mahasiswa);
    //     updateFile();
    // }
 
    // public List<Mahasiswa> getListMahasiswa(){
    //     return data;
    // }

    // private static void loadFile() {
    //     try {
    //         File f = new File("src/latihan/gui/database.dat");
    //         FileInputStream fis = new FileInputStream(f);
    //         ObjectInputStream ois = new ObjectInputStream(fis);
    //         instance = (Database) ois.readObject();
    //         ois.close();
    //         fis.close();
    //     } catch (FileNotFoundException ex) {
    //         System.err.println("File tidak ditemukan");
    //     } catch (IOException ex) {
    //         System.err.println("File gagal dibaca");
    //     } catch (ClassNotFoundException ex) {
    //         System.err.println("Format File salah");
    //     }
    // }

    // private static void updateFile() {
    //     try {
    //         FileOutputStream fos = new FileOutputStream("src/latihan/gui/database.dat");
    //         ObjectOutputStream oos = new ObjectOutputStream(fos);
    //         oos.writeObject(instance);
    //         oos.close();
    //         fos.close();
    //     } catch (FileNotFoundException ex) {
    //         System.err.println("File tidak ditemukan");
    //     } catch (IOException ex) {
    //         System.err.println("File tidak dapat ditulis");
    //     }
    // }
}
