/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author c0689497
 */
public class UserLoginTest {
    
    public UserLoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUserName method, of class UserLogin.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        UserLogin instance = new UserLogin();
        String expResult = null;
        String result = instance.getUserName();
        assertEquals("getTotal() does not return zero when no setters called",
                expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserPassword method, of class UserLogin.
     */
    @Test
    public void testGetUserPassword() {
        System.out.println("getUserPassword");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.getUserPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserName method, of class UserLogin.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "";
        UserLogin instance = new UserLogin();
        instance.setUserName(userName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserPassword method, of class UserLogin.
     */
    @Test
    public void testSetUserPassword() {
        System.out.println("setUserPassword");
        String userPassword = "";
        UserLogin instance = new UserLogin();
        instance.setUserPassword(userPassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class UserLogin.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class UserLogin.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class UserLogin.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class UserLogin.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        UserLogin instance = new UserLogin();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class UserLogin.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        UserLogin instance = new UserLogin();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class UserLogin.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = "";
        UserLogin instance = new UserLogin();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validate method, of class UserLogin.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.validate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dataFrom method, of class UserLogin.
     */
    @Test
    public void testDataFrom() {
        System.out.println("dataFrom");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.dataFrom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class UserLogin.
     */
    @Test
    public void testLogout() throws Exception {
        System.out.println("logout");
        UserLogin instance = new UserLogin();
        instance.logout();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
