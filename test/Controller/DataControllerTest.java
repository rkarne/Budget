/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Annual;
import pojo.Data;
import pojo.Datab;
import pojo.Monthly;

/**
 *
 * @author c0689497
 */
public class DataControllerTest {
    
    public DataControllerTest() {
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
     * Test of getUserdata method, of class DataController.
     */
    @Test
    public void testGetUserdata() {
        System.out.println("getUserdata");
        DataController instance = new DataController();
        List<Data> expResult = null;
        List<Data> result = instance.getUserdata();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserobj method, of class DataController.
     */
    @Test
    public void testGetUserobj() {
        System.out.println("getUserobj");
        DataController instance = new DataController();
        Data expResult = null;
        Data result = instance.getUserobj();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsedata method, of class DataController.
     */
    @Test
    public void testGetUsedata() {
        System.out.println("getUsedata");
        DataController instance = new DataController();
        List<Datab> expResult = null;
        List<Datab> result = instance.getUsedata();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUseobj method, of class DataController.
     */
    @Test
    public void testGetUseobj() {
        System.out.println("getUseobj");
        DataController instance = new DataController();
        Datab expResult = null;
        Datab result = instance.getUseobj();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsdata method, of class DataController.
     */
    @Test
    public void testGetUsdata() {
        System.out.println("getUsdata");
        DataController instance = new DataController();
        List<Monthly> expResult = null;
        List<Monthly> result = instance.getUsdata();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsobj method, of class DataController.
     */
    @Test
    public void testGetUsobj() {
        System.out.println("getUsobj");
        DataController instance = new DataController();
        Monthly expResult = null;
        Monthly result = instance.getUsobj();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUdata method, of class DataController.
     */
    @Test
    public void testGetUdata() {
        System.out.println("getUdata");
        DataController instance = new DataController();
        List<Annual> expResult = null;
        List<Annual> result = instance.getUdata();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUobj method, of class DataController.
     */
    @Test
    public void testGetUobj() {
        System.out.println("getUobj");
        DataController instance = new DataController();
        Annual expResult = null;
        Annual result = instance.getUobj();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DataController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Data d = null;
        DataController instance = new DataController();
        String expResult = "";
        String result = instance.delete(d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class DataController.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        DataController instance = new DataController();
        String expResult = "";
        String result = instance.add();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserId method, of class DataController.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        DataController instance = new DataController();
        int expResult = 0;
        int result = instance.getUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonthly method, of class DataController.
     */
    @Test
    public void testGetMonthly() throws Exception {
        System.out.println("getMonthly");
        DataController instance = new DataController();
        String expResult = "";
        String result = instance.getMonthly();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnnual method, of class DataController.
     */
    @Test
    public void testGetAnnual() {
        System.out.println("getAnnual");
        DataController instance = new DataController();
        String expResult = "";
        String result = instance.getAnnual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
