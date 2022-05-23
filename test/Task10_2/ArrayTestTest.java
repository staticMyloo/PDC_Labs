/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Task10_2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author myles
 */
public class ArrayTestTest {
    
    public ArrayTestTest() {
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
     * Test of find method, of class ArrayTest.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int index = 0;
        int[] intArray = {1, 4, 2, 5, 7, 9};
        ArrayTest instance = new ArrayTest();
        
        double expResult;
        double sum  = 0;
        for(int i = 0; i < intArray.length; i++)
        {
            sum += intArray[i];
        }
        expResult = sum / intArray.length;
        //expResult = 4.666666666666667;
        double result = instance.find(index, intArray);
        assertEquals(expResult, result, 0.0);
    }
    
     @Test
    public void testFindLarge() {
        System.out.println("find");
        int index = 0;
        int[] intArray = {1, 4, 2, 5, 7, 9, 10, 2, 3, 4, 5, 0, 1, 2, 2};
        ArrayTest instance = new ArrayTest();
        
        double expResult;
        double sum  = 0;
        for(int i = 0; i < intArray.length; i++)
        {
            sum += intArray[i];
        }
        expResult = sum / intArray.length;
        //expResult = 4.666666666666667;
        double result = instance.find(index, intArray);
        assertEquals(expResult, result, 0.0);
    }
    
    
    @Test
    public void testSize(){
        System.out.println("size");
        int[] intArray = {1, 4, 2, 5, 7, 9};
        int expResult = intArray.length;
        int result = 6;
        assertEquals(expResult, result);
    }
    
}
