package View;

import Controller.SessionManager;
import Controller.SQLite;
import Model.LoginAttempts;
import Model.User;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.*;
import java.util.Arrays;

import javax.swing.JOptionPane;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.*;

public class Login extends javax.swing.JPanel {

    private String username;
    private int role;
    
    public Frame frame;
    public SQLite sqlite;
    
    private StringBuilder originalPassword = new StringBuilder();
    private int maxLoginAttempts = 5;
    
    public Login() {
        initComponents();
        sqlite = new SQLite();
    }
    
    public String generateSHA256(String input) {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
                StringBuilder hexString = new StringBuilder();
                for (byte b : hash) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) {
                        hexString.append('0');
                    }
                    hexString.append(hex);
                }
                return hexString.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
    }
    
    private Boolean checkIfValidUsername() {
        Boolean validUser = false;
        ArrayList<User> users = sqlite.getUsers();
        String username = usernameFld.getText();
        String inputUsername = username;
        for (int nCtr = 0; nCtr < users.size(); nCtr++) {
            String existingUsername = users.get(nCtr).getUsername();
            if (existingUsername.equals(inputUsername)){
                validUser = true;
                this.username = inputUsername;
                this.role = users.get(nCtr).getRole();
            }
        }
        return validUser;
    }
    
    private Boolean checkIfCorrectPassword(){
        Boolean validUser = false;
        ArrayList<User> users = sqlite.getUsers();
        String username = usernameFld.getText();
        String inputUsername = username;
        String inputPassword = generateSHA256(originalPassword.toString()+"supersecuresaltsecdev6969");
        for (int nCtr = 0; nCtr < users.size(); nCtr++) {
            String existingUsername = users.get(nCtr).getUsername();
            String password = users.get(nCtr).getPassword();
            if (existingUsername.equals(inputUsername) && inputPassword.equals(password)){
                validUser = true;
            }
        }
        return validUser;
    }
    
    public int getNumberOfAttempts(String username){
        ArrayList<LoginAttempts> attempts = sqlite.getLoginAttempts();
        String inputUsername = username;
        int attempt = 0;
        for(int nCtr = 0; nCtr < attempts.size(); nCtr++){
            if(inputUsername.equals(attempts.get(nCtr).getUsername())){       
                attempt = attempts.get(nCtr).getAttempts();
            }
        }
        return attempt;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernameFld = new javax.swing.JTextField();
        passwordFld = new javax.swing.JTextField();
        registerBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
        forgotPasswordBtn = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        usernameFld.setBackground(new java.awt.Color(240, 240, 240));
        usernameFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernameFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        passwordFld.setBackground(new java.awt.Color(240, 240, 240));
        passwordFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        passwordFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordFldKeyTyped(evt);
            }
        });

        registerBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registerBtn.setText("REGISTER");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        loginBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        loginBtn.setText("LOGIN");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        forgotPasswordBtn.setForeground(new java.awt.Color(51, 102, 255));
        forgotPasswordBtn.setText("Forgot Password");
        forgotPasswordBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPasswordBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(forgotPasswordBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(registerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(usernameFld)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordFld, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forgotPasswordBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed

        Boolean validUsername = checkIfValidUsername();
        Boolean validPassword = checkIfCorrectPassword();
        
        int numberOfAttempts = getNumberOfAttempts(usernameFld.getText());
        int accountLocked = isAccountLocked(usernameFld.getText());
        
        if(accountLocked == 1 && validUsername && validPassword){
            JOptionPane.showMessageDialog(frame, "This account is locked. Please contact an admin.", "Account Status", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        }
        else if(accountLocked == 1 && (!validUsername || !validPassword)){
            JOptionPane.showMessageDialog(frame, "This account is locked. Please contact an admin.", "Account Status", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        }
        else if(validUsername && !validPassword && numberOfAttempts < maxLoginAttempts && accountLocked == 0){
            sqlite.updateLoginAttempts(usernameFld.getText(),new Timestamp(new Date().getTime()).toString());
            sqlite.addLogs("WARNING", usernameFld.getText(), "Login attempt. Incorrect credentials.", new Timestamp(new Date().getTime()).toString());
            JOptionPane.showMessageDialog(frame, "The username or password is incorrect.", "Invalid username or password", JOptionPane.INFORMATION_MESSAGE);
            numberOfAttempts = getNumberOfAttempts(usernameFld.getText());
            
            if (numberOfAttempts >= maxLoginAttempts) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.add(Calendar.MINUTE, 15); 
                Timestamp newTimestamp = new Timestamp(cal.getTime().getTime());
                sqlite.updateLockAccountStatus(usernameFld.getText(),1);
                sqlite.addLogs("WARNING", usernameFld.getText(),"Excessive incorrect login attempts.", new Timestamp(new Date().getTime()).toString());
                sqlite.deleteLoginAttempt(usernameFld.getText());
                sqlite.updateLoginAttempts(usernameFld.getText(), newTimestamp.toString());
            }
            clearFields(); 
        }

        else if (validUsername && !validPassword && numberOfAttempts >= maxLoginAttempts && accountLocked == 0){
            sqlite.updateLockAccountStatus(usernameFld.getText(),1);
            sqlite.addLogs("WARNING", usernameFld.getText(),"Excessive incorrect login attempts.", new Timestamp(new Date().getTime()).toString());
            sqlite.deleteLoginAttempt(usernameFld.getText());
            JOptionPane.showMessageDialog(frame, "This account is locked. Please contact an admin.", "Locked Account", JOptionPane.INFORMATION_MESSAGE);
            clearFields();  
        }
        
        else if (!validUsername || !validPassword && accountLocked == 0){
            JOptionPane.showMessageDialog(frame, "The username or password is incorrect.", "Invalid username or password", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        }
        
        else if (validUsername && validPassword && accountLocked == 0 && numberOfAttempts < maxLoginAttempts){
            System.out.println(numberOfAttempts);
            sqlite.deleteLoginAttempt(usernameFld.getText());
            clearFields();
            SessionManager.getInstance().startSession(username);
            frame.mainNav(username, role);
        }
    }//GEN-LAST:event_loginBtnActionPerformed
    
    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        frame.registerNav();
    }//GEN-LAST:event_registerBtnActionPerformed

    private void forgotPasswordBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPasswordBtnMouseClicked
        String username = JOptionPane.showInputDialog(null, "Enter your username:");
        
        if (username != null && !username.isEmpty()) {
            Random random = new Random();
            int verificationCode = 100000 + random.nextInt(900000);
            
            String to = "user@example.com";
            String from = "secdv.grp1user@gmail.com";
            String host = "smtp.gmail.com";
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.auth", "true");
            Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("secdv.grp1user@gmail.com", "awmf vgiu kdda eyny");
                }
             });
            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("Your Verification Code");
                message.setText("Your verification code is: " + verificationCode);
                Transport.send(message);
                System.out.println("Verification code sent successfully.");
            } catch (MessagingException mex) {
                mex.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "Verification code has been sent to your email.");
            String userInputCode = JOptionPane.showInputDialog(null, "Enter the verification code sent to your email:");

            if (String.valueOf(verificationCode).equals(userInputCode)) {
                JPasswordField passwordField = new JPasswordField();
                int option = JOptionPane.showConfirmDialog(null, passwordField, "Enter your new password:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (option == JOptionPane.OK_OPTION) {
                    char[] passwordChars = passwordField.getPassword();
                    String newPassword = new String(passwordChars);
                    Arrays.fill(passwordChars, ' ');

                    if (!isPasswordValid(newPassword)) {
                        JOptionPane.showMessageDialog(null, "Password must contain at least 1 lowercase letter\n"+
												"Password must contain at least 1 uppercase letter\n"+
												"Password must contain at least 1 number\n"+
												"Password must contain at least 1 special character\n", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        String hashedPassword = generateSHA256(newPassword + "supersecuresaltsecdev6969");
                        sqlite.updateUserPassword(username, hashedPassword);
                        sqlite.addLogs("NOTICE", username, "User changed password", new Timestamp(new Date().getTime()).toString());
                        JOptionPane.showMessageDialog(null, "Password changed successfully.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Password change canceled.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect verification code. Please try again.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Username cannot be empty.");
        }
    }//GEN-LAST:event_forgotPasswordBtnMouseClicked
    
    private boolean isPasswordValid(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{15,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    
    private void passwordFldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFldKeyTyped
        maskText(passwordFld);
    }//GEN-LAST:event_passwordFldKeyTyped

    private void passwordFldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFldKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
            int caretPositionBeforeBackspace = passwordFld.getCaretPosition()-1;
            if(caretPositionBeforeBackspace < 0){
                return;
            }
            originalPassword.deleteCharAt(caretPositionBeforeBackspace);
        }
    }//GEN-LAST:event_passwordFldKeyPressed

    private int isAccountLocked(String username){
        ArrayList<User> users = sqlite.getUsers();
         for(int nCtr = 0; nCtr < users.size(); nCtr++){
            if(username.equals(users.get(nCtr).getUsername())){
                return users.get(nCtr).getLocked();
            }
        }
        return -1;
    }
    
    private void clearFields() {
        removeDocumentFilter(passwordFld);
        usernameFld.setText("");
        passwordFld.setText("");
        originalPassword.setLength(0);
        maskText(passwordFld);
    }
    
    private void maskText(JTextField textField) {
       
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                originalPassword.append(text);
                super.replace(fb, offset, length, "*", attrs);
            }
        });
    }
    
    private void removeDocumentFilter(JTextField textField) {
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(null);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel forgotPasswordBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JTextField passwordFld;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField usernameFld;
    // End of variables declaration//GEN-END:variables
}
