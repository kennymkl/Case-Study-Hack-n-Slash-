/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Wilson
 */
public class LoginAttempts {
    private int id;
    private String username;
    private int attempts = 0;
    private Timestamp timestamp;
    
    private SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
    
    // constructor
    public LoginAttempts(int id, String username, int attempts, String timestamp){
        this.id = id;
        this.username = username;
        this.attempts = attempts;
        try {
            this.timestamp = new Timestamp(dateformat.parse(timestamp).getTime());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public SimpleDateFormat getDateformat() {
        return dateformat;
    }

    public void setDateformat(SimpleDateFormat dateformat) {
        this.dateformat = dateformat;
    }
    
    
    
}
