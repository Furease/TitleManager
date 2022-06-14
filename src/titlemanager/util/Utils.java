package titlemanager.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class Utils merupakan class yang berfungsi untuk menyimpan fungsi-fungsi
 * 
 * @author Fure
 */
public class Utils {

    /**
     * Method untuk mengenkripsi password
     * @param password
     * @return
     */
    public static String encryptPassword(String password){
        String encryptedpassword = null;  

        try {  
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());

            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();  

            for (int i=0; i< bytes.length ;i++) {  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }

            encryptedpassword = s.toString();  
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return encryptedpassword;
    }

    /**
     * Method untuk memvalidasi password
     * @param password
     */
    public static void validatePassword(String password) throws Exception {
        if (password.length() < 8) {
            throw new Exception("Password minimal 8 karakter");
        }

        if (!password.matches("[a-zA-Z0-9]+")) {
            throw new Exception("Password harus berupa kombinasi huruf dan angka");
        }

        // pasword max 50 karakter
        if (password.length() > 50) {
            throw new Exception("Password maksimal 50 karakter");
        }
    }

    /**
     * Method untuk memvalidasi nim
     * @param nim
     */
    public static void validateNim(String nim) throws Exception {
        if (nim.length() < 6) {
            throw new Exception("NIM minimal 6 karakter");
        }
        
        // nim hanya angka
        if (!nim.matches("[0-9]+")) {
            throw new Exception("NIM harus berupa angka");
        }

        // nim max 10 karakter
        if (nim.length() > 10) {
            throw new Exception("NIM maksimal 10 karakter");
        }
    }

    /**
     * Method untuk memvalidasi nama
     * @param name
     */
    public static void validateName(String name) throws Exception {
        if (name.length() < 3) {
            throw new Exception("Nama minimal 3 karakter");
        }

        // nama max 50 karakter
        if (name.length() > 50) {
            throw new Exception("Nama maksimal 50 karakter");
        }
    }

    /**
     * Method untuk memvalidasi email
     * @param email
     */
    public static void validateEmail(String email) throws Exception {
        if (email.length() < 6) {
            throw new Exception("Email minimal 6 karakter");
        }

        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}")) {
            throw new Exception("Email tidak valid");
        }

        // email max 50 karakter
        if (email.length() > 50) {
            throw new Exception("Email maksimal 50 karakter");
        }
    }

    /**
     * Method untuk memvalidasi nomor telepon
     * @param number
     */
    public static void validateNumber(String number) throws Exception {
        if (number.length() < 6) {
            throw new Exception("Nomor telepon minimal 6 karakter");
        }

        // nomor telepon hanya angka
        if (!number.matches("[0-9]+")) {
            throw new Exception("Nomor telepon harus berupa angka");
        }

        // nomor telepon max 15 karakter
        if (number.length() > 15) {
            throw new Exception("Nomor telepon maksimal 15 karakter");
        }
    }
}
