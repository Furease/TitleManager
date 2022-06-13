package titlemanager.util;

import titlemanager.model.UserProfiles;
import titlemanager.model.Project;
import titlemanager.model.Item;
import titlemanager.model.Account;
import java.io.Serializable;
import java.util.ArrayList;
import java.sql.*;


/**
 * Class Database mengimplementasikan interface Serializable untuk menyimpan
 * dan mengambil data dari database.
 * 
 * @author Fure
 */
public class Database implements Serializable {
    public static Database instance;

    private final String DB_TYPE = "mysql";         // database type
    private final String DB_HOST = "localhost";     // database host
    private final String DB_PORT = "3306";          // database port
    private final String DB_NAME = "titlemanager";  // nama database
    private final String DB_USER = "root";          // username database
    private final String DB_PASS = "";              // password database

    /**
     * Constructor Database.
     */
    private Database() {
    }

    /**
     * Method getInstance mengembalikan instance dari class Database.
     * @return
     */
    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    /**
     * Method getConnection melakukan koneksi ke database.
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:" + DB_TYPE + "://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME,
                DB_USER, DB_PASS);
    }

    /**
     * Method insertUserProfile menyimpan data user profile ke database.
     * @param userProfiles
     * @throws SQLException
     */
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

    /**
     * Method getUserProfiles mengambil data user dari database.
     * @param nim
     * @return
     * @throws SQLException
     */
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

    /**
     * Method updateUserProfiles mengubah data user dari database.
     * @param userProfiles
     * @throws SQLException
     */
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

    /**
     * Method deleteUserProfile menghapus data user dari database.
     * @param nim
     * @throws SQLException
     */
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

    /**
     * Method getProjects mengambil data project dari database.
     * @param id
     * @return
     * @throws SQLException
     */
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

    /**
     * Method insertProject mengisi data project ke database.
     * @param project
     * @return
     * @throws SQLException
     */
    public void insertProject(Project project) throws SQLException {
        Connection conn = getConnection();

        try {
            String sql = "INSERT INTO project VALUES(?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, project.getId());
            pstmt.setString(2, project.getJudul());
            pstmt.setString(3, project.getAbstrak());
            pstmt.setString(4, project.getNim());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    /**
     * Method updateProject mengubah data project dari database.
     * @param project
     * @throws SQLException
     */
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

    /**
     * Method deleteProject menghapus data project dari database.
     * @param id
     * @throws SQLException
     */
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

    /**
     * Method getJudulByKeyword mengambil data project dari database
     * berdasarkan keyword, kemudian dilakukan pengeditan pada string
     * sehingga dapat tampil bold untuk keyword yang dicari.
     * @param keyword
     * @return
     * @throws SQLException
     */
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

    /**
     * Method getJudulById mengambil data project dari database
     * @param id
     * @return
     * @throws SQLException
     */
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



    /**
     * Method setUser mengatur data user ke database.
     * @param username
     * @param password
     * @throws SQLException
     */
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

    /**
     * Method getUser mengambil data user dari database.
     * termasuk password.
     * @param username
     * @return
     * @throws SQLException
     */
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
}
