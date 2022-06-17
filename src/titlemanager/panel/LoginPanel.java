package titlemanager.panel;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import titlemanager.util.Login;

/**
 * Class LoginPanel menampilkan panel untuk login.
 *
 * @author Fure
 */
public class LoginPanel extends javax.swing.JPanel {
    private JScrollPane contentScrollPane;

    /**
    * Creates new form LoginPanel
    * @param contentScrollPane JScrollPane untuk menampilkan panel ini
    */
    public LoginPanel(JScrollPane contentScrollPane) {
        this.contentScrollPane = contentScrollPane;
        initComponents();
    }

    /**
     * Creates new form LoginPanel
     */
    public LoginPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();
        passTextField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        signUpLabel = new javax.swing.JLabel();

        usernameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/titlemanager/icon/icons8_user_16px.png"))); // NOI18N
        usernameLabel.setLabelFor(userTextField);
        usernameLabel.setText("Username");

        passwordLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/titlemanager/icon/icons8_password_16px.png"))); // NOI18N
        passwordLabel.setLabelFor(passTextField);
        passwordLabel.setText("Password");

        userTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTextFieldActionPerformed(evt);
            }
        });

        passTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passTextFieldActionPerformed(evt);
            }
        });

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        signUpLabel.setText("Sign Up");
        signUpLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(signUpLabel)
                        .addGap(18, 18, 18)
                        .addComponent(loginButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLabel)
                            .addComponent(passwordLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {passTextField, userTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signUpLabel)
                    .addComponent(loginButton))
                .addGap(83, 83, 83))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method untuk melakukan login
     * @param evt
     */
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String username = userTextField.getText();
        String password = new String(passTextField.getPassword());

        // Cek apakah username dan password kosong
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fields tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Cek apakah username dan password sama dengan yang ada di database, jika sama maka login berhasil
        if (Login.getInstance().isLogin(username, password)) {
            contentScrollPane.setViewportView(new SearchPanel(contentScrollPane));
        } else {
            JOptionPane.showMessageDialog(this, "Username atau Password salah", "Gagal", JOptionPane.ERROR_MESSAGE);

            // Kosongkan field username dan password
            userTextField.setText("");
            passTextField.setText("");

            // Focus ke username field
            userTextField.requestFocus();
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    /**
     * Method untuk menuju halaman sign up
     * @param evt
     */
    private void signUpLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpLabelMouseClicked
        // Menuju halaman sign up
        contentScrollPane.setViewportView(new SignUpPanel(contentScrollPane));
    }//GEN-LAST:event_signUpLabelMouseClicked

    /**
     * Method untuk memindahkan focus ke field password
     * @param evt
     */
    private void userTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTextFieldActionPerformed
        // Ketika enter di tekan, maka pindah ke field password
        passTextField.requestFocus();
    }//GEN-LAST:event_userTextFieldActionPerformed

    /**
     * Method untuk menekan login button ketika tombol enter di tekan.
     * @param evt
     */
    private void passTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passTextFieldActionPerformed
        // Ketika enter di tekan, maka klik tombol login
        loginButton.doClick();
    }//GEN-LAST:event_passTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passTextField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel signUpLabel;
    private javax.swing.JTextField userTextField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
