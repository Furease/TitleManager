/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tugas.akhir;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Fure
 */
public class SignUpPanel extends javax.swing.JPanel {
    private JScrollPane contentScrollPane;

    /**
     * Creates new form SIgnUpPanel
     */
    public SignUpPanel(JScrollPane contentScrollPane) {
        this.contentScrollPane = contentScrollPane;
        initComponents();
    }

    public SignUpPanel() {
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

        nimTextField = new javax.swing.JTextField();
        namaTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        nomorTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();

        nimTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nimTextFieldActionPerformed(evt);
            }
        });

        namaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaTextFieldActionPerformed(evt);
            }
        });

        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });

        nomorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomorTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("NIM");

        jLabel2.setText("Nama");

        jLabel3.setText("Email");

        jLabel4.setText("Nomor");

        nextButton.setText("next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(nimTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nextButton)
                        .addGap(2, 2, 2)))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {emailTextField, namaTextField, nimTextField, nomorTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nimTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(nextButton)
                .addGap(69, 69, 69))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {emailTextField, namaTextField, nextButton, nimTextField, nomorTextField});

    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        UserProfiles user = new UserProfiles();
        user.setNim(nimTextField.getText());
        user.setNama(namaTextField.getText());
        user.setEmail(emailTextField.getText());
        user.setNomor(nomorTextField.getText());
        // check if textField is already filled
        if (nimTextField.getText().isEmpty() || namaTextField.getText().isEmpty() || emailTextField.getText().isEmpty()
                || nomorTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the textFields");
        } else {

            // konfirimasi
            int result = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin menyimpan data ini?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                // simpan data
                try {
                    Database.getInstance().insertProfile(user);
                    contentScrollPane.setViewportView(new SignUpPassPanel(contentScrollPane, user.getNim()));
                } catch (SQLException ex) {
                    System.err.println(ex);
                    JOptionPane.showMessageDialog(this, "Gagal menyimpan data", "Gagal", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        clearForm();
        nimTextField.requestFocus();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void nimTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nimTextFieldActionPerformed
        // TODO add your handling code here:
        // if enter is pressed, go to next textField
        namaTextField.requestFocus();
    }//GEN-LAST:event_nimTextFieldActionPerformed

    private void namaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaTextFieldActionPerformed
        // TODO add your handling code here:
        // if enter is pressed, go to next textField
        emailTextField.requestFocus();
    }//GEN-LAST:event_namaTextFieldActionPerformed

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // TODO add your handling code here:
        // if enter is pressed, go to next textField
        nomorTextField.requestFocus();
    }//GEN-LAST:event_emailTextFieldActionPerformed

    private void nomorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomorTextFieldActionPerformed
        // TODO add your handling code here:
        // if enter is pressed, go to next textField
        nextButton.doClick();
    }//GEN-LAST:event_nomorTextFieldActionPerformed

    // clearForm
    private void clearForm() {
        nimTextField.setText("");
        namaTextField.setText("");
        emailTextField.setText("");
        nomorTextField.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField namaTextField;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField nimTextField;
    private javax.swing.JTextField nomorTextField;
    // End of variables declaration//GEN-END:variables
}
