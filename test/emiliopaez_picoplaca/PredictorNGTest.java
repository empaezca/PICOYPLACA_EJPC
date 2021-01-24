/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emiliopaez_picoplaca;

import Models.Predictor;
import java.util.Calendar;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Emilio Paez
 */
public class PredictorNGTest {
    
    public PredictorNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
//TEST FAILED BECAUSE THE CAR IS NOT IN PICO Y PLACA
    /**
     * Test of excuteValidation method, of class Predictor.
     */
    @Test
    public void testExcuteValidation() {
        System.out.println("excuteValidation");
        Predictor instance = new Predictor("PCL555","27-01-2021","10:00");
        Boolean expResult = true;
        //if true the car can't be on the road
        //if false the car can be on the road
        Boolean result = instance.excuteValidation();
        assertEquals(result, expResult);
    }

//TEST PASSED BECAUSE THE CAR IS IN PICO Y PLACA
//    @Test
//    public void testExcuteValidation2() {
//        System.out.println("excuteValidation");
//        Predictor instance = new Predictor("PCL555","27-01-2021","10:00");
//        Boolean expResult = false;
//        //if true the car can't be on the road
//        //if false the car can be on the road
//        Boolean result = instance.excuteValidation();
//        assertEquals(result, expResult);
//    }
    
}
