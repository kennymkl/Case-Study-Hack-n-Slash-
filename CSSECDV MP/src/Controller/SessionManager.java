/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author pipoc
 */
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class SessionManager {
    public SQLite sqlite;
    private static SessionManager instance;
    private String loggedInUser;
    private Timer sessionTimer;
    private final int SESSION_TIMEOUT = 2 * 60 * 1000;

    private SessionManager() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void startSession(String username) {
        loggedInUser = username;
        System.out.println("Session Start for: " + loggedInUser);
        startSessionTimer();
    }

    private void startSessionTimer() {
        sqlite = new SQLite();
        if (sessionTimer != null) {
            sessionTimer.cancel();
        }
        sessionTimer = new Timer();
        sessionTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                sqlite.addLogs("LOGOUT", loggedInUser,"Session expired.", new Timestamp(new Date().getTime()).toString());
                invalidateSession();
            }
        }, SESSION_TIMEOUT);
    }

    public void invalidateSession() {
        System.out.println("Session Ended for: " + loggedInUser);
        
        loggedInUser = null;
        if (sessionTimer != null) {
            sessionTimer.cancel();
        }
        JOptionPane.showMessageDialog(null, "Session has expired. You will be redirected to the login page after an action is performed. Please log in again.", "Session Timeout", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean isSessionValid() {
        return loggedInUser != null;
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void resetSessionTimer() {
        startSessionTimer();
    }
    
}
