/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.akhir;

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

            // sql = "INSERT INTO project VALUES(?, ?, ?)";
            // pstmt = conn.prepareStatement(sql);
            // for (int i = 0; i < userProfiles.getJudul().size(); i++) {
            //     pstmt.setString(1, userProfiles.getJudul().get(i));
            //     pstmt.setString(2, userProfiles.getAbstrak().get(i));
            //     pstmt.setString(3, userProfiles.getNim());
            //     pstmt.executeUpdate();
            // }

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

                // sql = "SELECT * FROM project WHERE nim = ?";
                // pstmt = conn.prepareStatement(sql);
                // pstmt.setString(1, nim);
                // rs = pstmt.executeQuery();
                // ArrayList<String> judul = new ArrayList<>();
                // ArrayList<String> abstrak = new ArrayList<>();
                // while (rs.next()) {
                //     judul.add(rs.getString("judul"));
                //     abstrak.add(rs.getString("abstrak"));
                // }
                // userProfiles.setJudul(judul);
                // userProfiles.setAbstrak(abstrak);
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

    // public List<Mahasiswa> getListMahasiswa() throws SQLException {
    //     List<Mahasiswa> mhsList = new ArrayList<>();
    //     Connection conn = getConnection();
    //     try {
    //         String sql = "SELECT * FROM mahasiswa";
    //         Statement stmt = conn.createStatement();
    //         ResultSet rs = stmt.executeQuery(sql);
    //         while (rs.next()) {
    //             Mahasiswa mhs = new Mahasiswa();
    //             mhs.setNim(rs.getString("nim"));
    //             mhs.setNama(rs.getString("nama"));
    //             mhs.setJenisKelamin(rs.getString("jenis_kelamin"));
    //             mhs.setUmur(rs.getInt("umur"));
    //             mhs.setAlamat(rs.getString("alamat"));
    //             mhs.setProvinsi(rs.getString("provinsi"));
    //             mhs.setHobi(new ArrayList<>(Arrays.asList(rs.getString("hobi").split(","))));
    //             mhsList.add(mhs);
    //         }
    //     } catch (SQLException ex) {
    //         throw ex;
    //     } finally {
    //         if (conn != null) {
    //             conn.close();
    //         }
    //     }

    //     return mhsList;
    // }

    // public Mahasiswa getMahasiswa(String nim) throws SQLException {
    //     Mahasiswa mhs = new Mahasiswa();
    //     Connection conn = getConnection();
    //     try {
    //         String sql = "SELECT * FROM mahasiswa WHERE nim = ?";
    //         PreparedStatement pstmt = conn.prepareStatement(sql);
    //         pstmt.setString(1, nim);
    //         ResultSet rs = pstmt.executeQuery();
    //         if (rs.next()) {
    //             mhs.setNim(rs.getString("nim"));
    //             mhs.setNama(rs.getString("nama"));
    //             mhs.setJenisKelamin(rs.getString("jenis_kelamin"));
    //             mhs.setUmur(rs.getInt("umur"));
    //             mhs.setAlamat(rs.getString("alamat"));
    //             mhs.setProvinsi(rs.getString("provinsi"));
    //             mhs.setHobi(new ArrayList<>(Arrays.asList(rs.getString("hobi").split(","))));
    //         }
    //     } catch (SQLException ex) {
    //         throw ex;
    //     } finally {
    //         if (conn != null) {
    //             conn.close();
    //         }
    //     }

    //     return mhs;
    // }

    // public void updateMahasiswa(String nim, Mahasiswa mahasiswa) throws SQLException {
    //     Connection conn = getConnection();
    //     try {
    //         String sql = "UPDATE mahasiswa SET nim = ?, nama = ?, jenis_kelamin = ?, umur = ?, alamat = ?, provinsi = ?, hobi = ? WHERE nim = ?";
    //         PreparedStatement pstmt = conn.prepareStatement(sql);
    //         pstmt.setString(1, mahasiswa.getNim());
    //         pstmt.setString(2, mahasiswa.getNama());
    //         pstmt.setString(3, mahasiswa.getJenisKelamin());
    //         pstmt.setInt(4, mahasiswa.getUmur());
    //         pstmt.setString(5, mahasiswa.getAlamat());
    //         pstmt.setString(6, mahasiswa.getProvinsi());
    //         pstmt.setString(7, String.join(",", mahasiswa.getHobi()));
    //         pstmt.setString(8, nim);
    //         pstmt.executeUpdate();
    //     } catch (SQLException ex) {
    //         throw ex;
    //     } finally {
    //         if (conn != null) {
    //             conn.close();
    //         }
    //     }
    // }

    // public void deleteMahasiswa(String nim) throws SQLException {
    //     Connection conn = getConnection();
    //     try {
    //         String sql = "DELETE FROM mahasiswa WHERE nim = ?";
    //         PreparedStatement pstmt = conn.prepareStatement(sql);
    //         pstmt.setString(1, nim);
    //         pstmt.executeUpdate();
    //     } catch (SQLException ex) {
    //         throw ex;
    //     } finally {
    //         if (conn != null) {
    //             conn.close();
    //         }
    //     }
    // }


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
