package titlemanager.util;

import titlemanager.model.Account;
import java.sql.SQLException;

/**
 * Class Login melakukan validasi login.
 * 
 * @author Fure
 */
public class Login {
    private static Login instance;

    /**
     * Method untuk mendapatkan instance Login.
     * @return
     */
    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
        }
        return instance;
    }

    /**
     * Method untuk melakukan validasi login.
     * @param username
     * @param password
     * @return
     */
    public boolean isLogin(String username, String password) {
        boolean isLog = false;
        Account account = Account.getInstance();
        
        if ("".equals(username)) {
            return false;
        }
        
        try {
            account = Database.getInstance().getUser(username);

            if (account.getUsername().equals(username) && account.getPassword().equals(Utils.encryptPassword(password))) {
                isLog = true;
                return isLog;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        account.clear();
        return isLog;
    }
}
