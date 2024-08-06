/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package View;

import Controller.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Aaron Lensmer
 */
public class FrameTest {
    
    public FrameTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of init method, of class Frame.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        Main controller = null;
        Frame instance = new Frame();
        instance.init(controller);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mainNav method, of class Frame.
     */
    @Test
    public void testMainNav() {
        System.out.println("mainNav");
        String username = "";
        int role = 2;
        Frame instance = new Frame();
        instance.mainNav(username, role);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginNav method, of class Frame.
     */
    @Test
    public void testLoginNav() {
        System.out.println("loginNav");
        Frame instance = new Frame();
        instance.loginNav();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerNav method, of class Frame.
     */
    @Test
    public void testRegisterNav() {
        System.out.println("registerNav");
        Frame instance = new Frame();
        instance.registerNav();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerAction method, of class Frame.
     */
    @Test
    public void testRegisterAction() {
        System.out.println("registerAction");
        String username = "";
        String password = "";
        String confpass = "";
        Frame instance = new Frame();
        instance.registerAction(username, password, confpass);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
