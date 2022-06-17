package titlemanager.panel;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import titlemanager.util.Database;
import titlemanager.util.Utils;

/**
 * Class SignUpPassPanel menampilkan panel untuk sign up,
 * untuk mengisi password.
 * 
 * @author Fure
 */
public class SignUpPassPanel extends javax.swing.JPanel {
    private JScrollPane contentScrollPane;
    private String username;
    /**
     * Creates new form SignUpPass
     * @param contentScrollPane JScrollPane untuk menampilkan panel ini
     * @param username username untuk index database
     */
    public SignUpPassPanel(JScrollPane contentScrollPane, String username) {
        this.contentScrollPane = contentScrollPane;
        this.username = username;
        initComponents();
        usernameTextField.setText(username);
        passTextField.requestFocus();
    }

    /**
     * Creates new form SignUpPass
     */
    public SignUpPassPanel() {
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

        usernameTextField = new javax.swing.JTextField();
        passTextField = new javax.swing.JPasswordField();
        confirmPassTextField = new javax.swing.JPasswordField();
        saveButton = new javax.swing.JButton();
        passwordLabel = new javax.swing.JLabel();
        confirmPassLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        backLabel = new javax.swing.JLabel();

        usernameTextField.setEditable(false);

        passTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passTextFieldActionPerformed(evt);
            }
        });

        confirmPassTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPassTextFieldActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        passwordLabel.setText("Password");

        confirmPassLabel.setText("Konfirmasi Password");

        usernameLabel.setText("Username / NIM");

        backLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/titlemanager/icon/icons8_return_32px_1.png"))); // NOI18N
        backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(passwordLabel)
                        .addGap(92, 92, 92)
                        .addComponent(passTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernameLabel)
                        .addGap(55, 55, 55)
                        .addComponent(usernameTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmPassLabel)
                            .addComponent(backLabel))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(confirmPassTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveButton)))))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmPassTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmPassLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton)
                    .addComponent(backLabel))
                .addGap(63, 63, 63))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method untuk menyimpan data form ke database
     * @param evt
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String password = new String(passTextField.getPassword());
        String confirmPassword = new String(confirmPassTextField.getPassword());
        // Field validation
        if (password.equals("") || confirmPassword.equals("")) {
            JOptionPane.showMessageDialog(this, "Password tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            clearForm();
            return;
        }

        if (password.equals(confirmPassword)) {
            try {
                Utils.validatePassword(password);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                clearForm();
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Password tidak sama");
            return;
        }

        // yes or no dialog
        int reply = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menyimpan password?", "Konfirmasi",
                JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                Database.getInstance().setUser(username, Utils.encryptPassword(password));
                JOptionPane.showMessageDialog(this, "Sign Up Success");
                contentScrollPane.setViewportView(new LoginPanel(contentScrollPane));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(this, "Sign Up Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        clearForm();
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * Method untuk mengubah fokus ke field berikutnya
     * @param evt
     */
    private void passTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passTextFieldActionPerformed
        confirmPassTextField.requestFocus();
    }//GEN-LAST:event_passTextFieldActionPerformed

    /**
     * Method untuk mengubah fokus ke field berikutnya
     * @param evt
     */
    private void confirmPassTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPassTextFieldActionPerformed
        saveButton.doClick();
    }//GEN-LAST:event_confirmPassTextFieldActionPerformed

    /**
     * Method untuk kembali ke panel login dan menghapus data user yang sudah
     * dimasukkan sebelumnya
     * @param evt
     */
    private void backLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLabelMouseClicked
        // hapus data user profile 
        try {
            Database.getInstance().deleteUserProfile(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // kembali ke login panel
        contentScrollPane.setViewportView(new LoginPanel(contentScrollPane));
    }//GEN-LAST:event_backLabelMouseClicked

    /**
     * Method untuk membersihkan field
     */
    private void clearForm() {
        passTextField.setText("");
        confirmPassTextField.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backLabel;
    private javax.swing.JLabel confirmPassLabel;
    private javax.swing.JPasswordField confirmPassTextField;
    private javax.swing.JPasswordField passTextField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
