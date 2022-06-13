/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package titlemanager.util;

import titlemanager.model.Account;
import java.sql.SQLException;

/**
 *
 * @author Fure
 */
public class Login {
    private static Login instance;
    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
        }
        return instance;
    }

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
