package Controller;


import Model.History;
import Model.Logs;
import Model.Product;
import Model.User;
import View.Frame;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    
    public SQLite sqlite;
    
    public static void main(String[] args) {
        new Main().init();
    }
    
    public void init(){
        sqlite = new SQLite();
        sqlite.createNewDatabase();

        sqlite.createHistoryTable();
        sqlite.createLogsTable();
        sqlite.createProductTable();
        sqlite.createUserTable();
        sqlite.createLogInAttempts();

        ArrayList<User> users = sqlite.getUsers();
        for(int nCtr = 0; nCtr < users.size(); nCtr++){
            System.out.println("===== User " + users.get(nCtr).getId() + " =====");
            System.out.println(" Username: " + users.get(nCtr).getUsername());
            System.out.println(" Password: " + users.get(nCtr).getPassword());
            System.out.println(" Role: " + users.get(nCtr).getRole());
            System.out.println(" Locked: " + users.get(nCtr).getLocked());
        }
        
        Frame frame = new Frame();
        frame.init(this);
    }
    
}
