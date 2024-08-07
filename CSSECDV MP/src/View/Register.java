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
                if(textField.getName().equals("password")){
                    originalPassword.append(text);
                }
                if(textField.getName().equals("confirmPassword")){
                    originalConfPass.append(text);
                }
                super.replace(fb, offset, length, "*", attrs);
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

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
       
        sqlite = new SQLite();
        Boolean usernameExist = false;
		Boolean passStrength = false;
		Boolean passMatch = false;
        ArrayList<User> users = sqlite.getUsers();
        
        String username = usernameFld.getText();
        String inputUsername = username;
        for (int nCtr = 0; nCtr < users.size(); nCtr++) {
            String existingUsername = users.get(nCtr).getUsername();
            System.out.println(" Username: " + existingUsername);
            if (existingUsername.equals(inputUsername)) {
                usernameExist = true;
                break;
            }
        }
        
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
        
        
        if(!usernameExist && (passStrength && passMatch)){
            try{
                String hashedPassword = generateSHA256(originalPassword.toString()+"supersecuresaltsecdev6969");
                frame.registerAction(usernameFld.getText().toLowerCase(), hashedPassword, hashedPassword);
                sqlite.addLogs("NOTICE", usernameFld.getText().toLowerCase(), "User creation successful", new Timestamp(new Date().getTime()).toString());
                System.out.println("ADDED USER: " + usernameFld.getText() + "\n" + originalPassword.toString() + "\n" + hashedPassword);
                JOptionPane.showMessageDialog(null, "Account Created", "Account Created", JOptionPane.INFORMATION_MESSAGE);
                frame.loginNav();
                
            }catch (Exception e) {
                System.out.println(e.getStackTrace());
            } 
        }

        System.out.println("ORIGINAL PASSWORD: " +originalPassword);
        System.out.println("CONFIRM PASSWORD: " + originalConfPass);
        clearFields();

    }//GEN-LAST:event_registerBtnActionPerformed
	
    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        frame.loginNav();
    }//GEN-LAST:event_backBtnActionPerformed

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

    private void confpassFldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confpassFldKeyTyped
        maskText(confpassFld);
    }//GEN-LAST:event_confpassFldKeyTyped

    private void confpassFldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confpassFldKeyPressed
         if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
            int caretPositionBeforeBackspace = confpassFld.getCaretPosition()-1;
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
