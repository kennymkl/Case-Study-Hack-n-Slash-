
package View;

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

public class Login extends javax.swing.JPanel {

    public Frame frame;
    public SQLite sqlite;
    
    private StringBuilder originalPassword = new StringBuilder();
    private int maxLoginAttempts = 3;
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
        // Gets username and lowerCase to check for case insensitivity
        String username = usernameFld.getText();
        String inputUsername = username.toLowerCase();
        for (int nCtr = 0; nCtr < users.size(); nCtr++) {
            String existingUsername = users.get(nCtr).getUsername().toLowerCase();
            if (existingUsername.equals(inputUsername)){
                validUser = true;
            }
        }
        return validUser;
    }
    private Boolean checkIfCorrectPassword(){
        Boolean validUser = false;
        ArrayList<User> users = sqlite.getUsers();
        // Gets username and lowerCase to check for case insensitivity
        String username = usernameFld.getText();
        String inputUsername = username.toLowerCase();
        String inputPassword = generateSHA256(originalPassword.toString()+"supersecuresaltsecdev6969");
        for (int nCtr = 0; nCtr < users.size(); nCtr++) {
            String existingUsername = users.get(nCtr).getUsername().toLowerCase();
            String password = users.get(nCtr).getPassword();
            if (existingUsername.equals(inputUsername) && inputPassword.equals(password)){
                validUser = true;
            }
        }
        return validUser;
    }
    public int getNumberOfAttempts(String username){
        ArrayList<LoginAttempts> attempts = sqlite.getLoginAttempts();
        String inputUsername = username.toLowerCase();
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
        
        // number of attempts
        int numberOfAttempts = getNumberOfAttempts(usernameFld.getText());
        int accountLocked = isAccountLocked(usernameFld.getText());
        
        // if the account is locked prompt the user that the account is locked
        if(accountLocked == 1){
            JOptionPane.showMessageDialog(frame, "The account is locked. Please contact admin", "Account Status", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        }
        // if the account is not locked and the number of login attempts is less than max login attempts, increment it.
        else if(validUsername && !validPassword && numberOfAttempts < maxLoginAttempts && accountLocked ==0){
            // update the login attempts
            sqlite.updateLoginAttempts(usernameFld.getText(),new Timestamp(new Date().getTime()).toString());
      
            // show that the username or password is incorrect
            JOptionPane.showMessageDialog(frame, "The username or password is incorrect.", "Invalid username or password", JOptionPane.INFORMATION_MESSAGE);
            
            numberOfAttempts = getNumberOfAttempts(usernameFld.getText());
            // if number of attempts is >= 3 update the timestamp to add 5 minutes
            if (numberOfAttempts >= maxLoginAttempts) {
                // Update the timestamp to current time + 2 minutes
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.add(Calendar.MINUTE, 2); 
                Timestamp newTimestamp = new Timestamp(cal.getTime().getTime());
                // Update the database with the new timestamp
                sqlite.updateLoginAttempts(usernameFld.getText(), newTimestamp.toString());
            }
            clearFields(); 
        }
        // if the account is locked and reached the number of maximum attempts prompt the user for 2 minutes
        // if the 2 minutes is done, delete the record from the database
        else if (validUsername && !validPassword && numberOfAttempts >= maxLoginAttempts && accountLocked == 0){
            
            accountLockedDueToExcessAttempts();
            clearFields();  
        }
        else if (!validUsername || !validPassword && accountLocked == 0){
            JOptionPane.showMessageDialog(frame, "The username or password is incorrect.", "Invalid username or password", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        }
        else if (numberOfAttempts >= maxLoginAttempts){
            accountLockedDueToExcessAttempts();
        }
        else if (validUsername && validPassword && accountLocked ==0 && numberOfAttempts < maxLoginAttempts){
            // delete the record in the login attempt
            System.out.println(numberOfAttempts);
            sqlite.deleteLoginAttempt(usernameFld.getText());
            clearFields();
         
            // go to the next page
            // AARON DO THIS PART
            frame.mainNav();
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void accountLockedDueToExcessAttempts(){
        Boolean validUsername = checkIfValidUsername();
        Boolean validPassword = checkIfCorrectPassword();
        
        // number of attempts
        int accountLocked = isAccountLocked(usernameFld.getText());
        
        String lockedTime = sqlite.getLockedTimestamp(usernameFld.getText());
            System.out.println(lockedTime);
            sqlite.addLogs("WARNING", usernameFld.getText(), "Account has been locked due to many attempts", new Timestamp(new Date().getTime()).toString());
            // convert to timestamp
            Timestamp lockedTimestamp = Timestamp.valueOf(lockedTime);
            // Get the current timestamp
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            
            // if the current timestamp is before the locked timestamp, prompt that the account is locked
            if (lockedTimestamp != null && currentTimestamp.before(lockedTimestamp)) {
        
                JOptionPane.showMessageDialog(frame, "The account is locked. Please try again in 2 minutes.", "Temporarily Locked Account", JOptionPane.INFORMATION_MESSAGE);
            } 
             // Account lock time expired delete the record and check if the username and password is valid
            else {
                sqlite.deleteLoginAttempt(usernameFld.getText());
                
                // after deleting the login attempt we check if the account is valid
                if(validUsername && validPassword && accountLocked ==0){
                    sqlite.deleteLoginAttempt(usernameFld.getText());
                    clearFields();
                    
                    // GO TO THE NEXT PAGE
                    // AARON PART
                    frame.mainNav();
                    
                }
                // if the account is invalid
                else if (validUsername && !validPassword){
                    sqlite.updateLoginAttempts(usernameFld.getText(),new Timestamp(new Date().getTime()).toString());
                    JOptionPane.showMessageDialog(frame, "The username or password is incorrect.", "Invalid username or password", JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                }
                
                
            }
        clearFields();
    }
    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        frame.registerNav();
    }//GEN-LAST:event_registerBtnActionPerformed

    private void forgotPasswordBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPasswordBtnMouseClicked
//        Object[] options = {"Enter"};
//        String username = JOptionPane.showInputDialog(frame, "Enter Username", "Forgot Password", JOptionPane.PLAIN_MESSAGE);
//        
//        // Check username validity ---> unsure if Im supposed to do this to keep username animosity
////        String usernameRegex = "^[a-zA-Z0-9]{3,16}$";
////        Pattern usernamePattern = Pattern.compile(usernameRegex);
////        Matcher usernameMatcher = usernamePattern.matcher(username);
////        if (!usernameMatcher.matches()) {
////            JOptionPane.showMessageDialog(frame, "Username must be between 3 and 16 characters and contain only alphanumeric characters.");
////        }
//        
//        if(username != null) {
//            JOptionPane.showMessageDialog(frame, "Request for password reset has been sent to your email");
//        }

        String username = JOptionPane.showInputDialog(null, "Enter your username:");

        if (username != null && !username.isEmpty()) {
            // Step 2: Generate a verification code
            Random random = new Random();
            int verificationCode = 100000 + random.nextInt(900000); // Generate a 6-digit code

            // Step 3: Send the verification code via email (this part is commented out)
            // String to = "user@example.com"; // Fetch user's email from the database if available
            // String from = "secdv.grp1user@gmail.com";
            // String host = "smtp.gmail.com";
            // Properties properties = System.getProperties();
            // properties.put("mail.smtp.host", host);
            // properties.put("mail.smtp.port", "465");
            // properties.put("mail.smtp.ssl.enable", "true");
            // properties.put("mail.smtp.auth", "true");
            // Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            //    protected PasswordAuthentication getPasswordAuthentication() {
            //        return new PasswordAuthentication("secdv.grp1user@gmail.com", "awmf vgiu kdda eyny");
            //    }
            // });
            // try {
            //    MimeMessage message = new MimeMessage(session);
            //    message.setFrom(new InternetAddress(from));
            //    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //    message.setSubject("Your Verification Code");
            //    message.setText("Your verification code is: " + verificationCode);
            //    Transport.send(message);
            //    System.out.println("Verification code sent successfully.");
            // } catch (MessagingException mex) {
            //    mex.printStackTrace();
            // }

            // Step 4: Ask the user to enter the verification code
            JOptionPane.showMessageDialog(null, "Verification code has been sent to your email: " + verificationCode);
            String userInputCode = JOptionPane.showInputDialog(null, "Enter the verification code sent to your email:");

            // Step 5: Validate the entered code
            if (String.valueOf(verificationCode).equals(userInputCode)) {
                // Step 6: Allow the user to change the password
                JPasswordField passwordField = new JPasswordField();
                int option = JOptionPane.showConfirmDialog(null, passwordField, "Enter your new password:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (option == JOptionPane.OK_OPTION) {
                    char[] passwordChars = passwordField.getPassword();
                    String newPassword = new String(passwordChars);
                    Arrays.fill(passwordChars, ' '); // Clear the password array for security

                    String hashedPassword = generateSHA256(newPassword + "supersecuresaltsecdev6969");

                    // Change password and update log
                    sqlite.updateUserPassword(username, hashedPassword);
                    sqlite.addLogs("NOTICE", username, "User changed password", new Timestamp(new Date().getTime()).toString());
                    JOptionPane.showMessageDialog(null, "Password changed successfully.");
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

    private void passwordFldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFldKeyTyped
        // TODO add your handling code here:
        maskText(passwordFld);
    }//GEN-LAST:event_passwordFldKeyTyped

    private void passwordFldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
        // Get current caret position before backspace
            int caretPositionBeforeBackspace = passwordFld.getCaretPosition()-1;
        //  System.out.println(caretPositionBeforeBackspace);
            if(caretPositionBeforeBackspace < 0){
                return;
            }
            originalPassword.deleteCharAt(caretPositionBeforeBackspace);
        }
    }//GEN-LAST:event_passwordFldKeyPressed

    private int isAccountLocked(String username){
         //returns 1 account is locked.
        // returns 0 account is unlocked
        // returns -1 means account is invalid
       
        ArrayList<User> users = sqlite.getUsers();
         for(int nCtr = 0; nCtr < users.size(); nCtr++){
//            System.out.println("===== User " + users.get(nCtr).getId() + " =====");
//            System.out.println(" Username: " + users.get(nCtr).getUsername());
//            System.out.println(" Locked: " + users.get(nCtr).getLocked());
//            
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
                super.replace(fb, offset, length, "*", attrs); // replace each character with '*'
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
