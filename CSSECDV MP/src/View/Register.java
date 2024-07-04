
package View;


import Controller.SQLite;
import Model.User;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import javax.swing.JOptionPane; 



public class Register extends javax.swing.JPanel {

    public Frame frame;
    private StringBuilder originalPassword = new StringBuilder();
    private StringBuilder originalConfPass  = new StringBuilder();
    private StringBuilder maskedPass = new StringBuilder();
    private StringBuilder maskedConfPass = new StringBuilder();
    public SQLite sqlite;
    
    
    public Register() {
        initComponents();
        passwordFld.setName("password");
        confpassFld.setName("confirmPassword");
        
    }

    private void maskText(JTextField textField) {
       
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
               // if text field is Password
                if(textField.getName().equals("password")){
                    originalPassword.append(text);
                }
                 // if text field is confirm Password
                if(textField.getName().equals("confirmPassword")){
                    originalConfPass.append(text);
                }
                super.replace(fb, offset, length, "*", attrs); // replace each character with '*'
            }
        });
    }
    
	
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerBtn = new javax.swing.JButton();
        passwordFld = new javax.swing.JTextField();
        usernameFld = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        confpassFld = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
		
		passStrength = new javax.swing.JOptionPane();
		
		
		
        registerBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registerBtn.setText("REGISTER");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

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
		

        usernameFld.setBackground(new java.awt.Color(240, 240, 240));
        usernameFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernameFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        confpassFld.setBackground(new java.awt.Color(240, 240, 240));
        confpassFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        confpassFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        confpassFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "CONFIRM PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        confpassFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confpassFldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                confpassFldKeyTyped(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backBtn.setText("<Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usernameFld)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordFld, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confpassFld, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(200, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confpassFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
       {
           MessageDigest md = MessageDigest.getInstance("SHA-256");
           return md.digest(input.getBytes(StandardCharsets.UTF_8));
       }

       public static String toHexString(byte[] hash)
       {
          
           BigInteger number = new BigInteger(1, hash);
           StringBuilder hexString = new StringBuilder(number.toString(16));
           while (hexString.length() < 64)
           {
               hexString.insert(0, '0');
           }
           return hexString.toString();
       }

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
       
        // check first for all existing users
        sqlite = new SQLite();
        Boolean usernameExist = false;
		Boolean passStrength = false;
		Boolean passMatch = false;
        ArrayList<User> users = sqlite.getUsers();
        
        // Gets username and lowerCase to check for case insensitivity
        String username = usernameFld.getText();
        String inputUsername = username.toLowerCase();
        for (int nCtr = 0; nCtr < users.size(); nCtr++) {
            String existingUsername = users.get(nCtr).getUsername().toLowerCase();
            System.out.println(" Username: " + existingUsername);
            if (existingUsername.equals(inputUsername)) {
                usernameExist = true;
                break;
            }
        }
        // Checks for the username validity
        
        String usernameRegex = "^[a-zA-Z0-9]{3,16}$";
        Pattern usernamePattern = Pattern.compile(usernameRegex);
        Matcher usernameMatcher = usernamePattern.matcher(username);
            
        System.out.println(usernameExist);
        
        if(usernameExist){
            JOptionPane.showMessageDialog(null, "Username already exists. Please choose a different username.", "Warning", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if (!usernameMatcher.matches()) {
        JOptionPane.showMessageDialog(null, "Username must be between 3 and 16 characters and contain only alphanumeric characters.", "Warning", JOptionPane.INFORMATION_MESSAGE);
        return;
        }
        
        // NOTE CHANGE THIS ADD AN IF STATEMENT TO CHECK IF THE PASSWORD IS STRONG just like the one above. IMPLEMENT PASSWORD SECURE AND MATCHING
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{15,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(originalPassword);
		if (matcher.matches()) {
			passStrength = true;
		}
		
		if((originalPassword.toString().equals(originalConfPass.toString()))){
				passMatch = true;
		}
		
		if(passMatch == false){
			System.out.println("Password does not match");
			JOptionPane.showMessageDialog(null, "Password does not match", "Warning", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(passStrength == false){
			JOptionPane.showMessageDialog(null, "Password must contain at least 1 lowercase letter\n"+
												"Password must contain at least 1 uppercase letter\n"+
												"Password must contain at least 1 number\n"+
												"Password must contain at least 1 special character\n", "Warning", JOptionPane.INFORMATION_MESSAGE);
		}
        
        
        // if the username is unique and the password is secure, store the user
        if(!usernameExist && (passStrength && passMatch)){
            // store to the database of the users
            try{
                String hashedPassword = toHexString(getSHA(originalPassword.toString()));
                frame.registerAction(usernameFld.getText(), hashedPassword, hashedPassword);
                sqlite.addLogs("NOTICE", usernameFld.getText(), "User creation successful", new Timestamp(new Date().getTime()).toString());
                System.out.println("ADDED USER: " + usernameFld.getText() + "\n" + originalPassword.toString() + "\n" + hashedPassword);
            }catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
          
           
        }
		
		
        
        System.out.println("ORIGINAL PASSWORD: " +originalPassword);
        System.out.println("CONFIRM PASSWORD: " + originalConfPass);
        clearFields();
        
        
        //frame.loginNav();
    }//GEN-LAST:event_registerBtnActionPerformed

	

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        frame.loginNav();
    }//GEN-LAST:event_backBtnActionPerformed

    private void passwordFldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFldKeyTyped
        // calal the maskText everytime the key is pressed
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

    private void confpassFldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confpassFldKeyTyped
        // TODO add your handling code here:
        maskText(confpassFld);
    }//GEN-LAST:event_confpassFldKeyTyped

    private void confpassFldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confpassFldKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
        // Get current caret position before backspace
            int caretPositionBeforeBackspace = confpassFld.getCaretPosition()-1;
        //  System.out.println(caretPositionBeforeBackspace);
            if(caretPositionBeforeBackspace < 0){
                return;
            }
            originalConfPass.deleteCharAt(caretPositionBeforeBackspace);
        }
    }//GEN-LAST:event_confpassFldKeyPressed
    private void removeDocumentFilter(JTextField textField) {
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(null);
    }
    private void clearFields() {
    removeDocumentFilter(passwordFld);
    removeDocumentFilter(confpassFld);

    // Clear the text fields
    usernameFld.setText("");
    passwordFld.setText("");
    confpassFld.setText("");

    originalPassword.setLength(0);
    originalConfPass.setLength(0);
    maskedPass.setLength(0);
    maskedConfPass.setLength(0);

    maskText(passwordFld);
    maskText(confpassFld);
}
    
	private javax.swing.JOptionPane passStrength;
	
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField confpassFld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField passwordFld;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField usernameFld;
    // End of variables declaration//GEN-END:variables
}
