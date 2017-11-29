/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.tripplepi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.sfedu.tripplepi.dao.DataProviderCsv;
import ru.sfedu.tripplepi.model.ClassType;
import ru.sfedu.tripplepi.model.Generic;
import ru.sfedu.tripplepi.model.Score;
import java.util.stream.*;
import ru.sfedu.tripplepi.dao.DataProviderXml;
import ru.sfedu.tripplepi.model.ContainerGeneric;
import ru.sfedu.tripplepi.model.Users;

/**
 *
 * @author !Евгений
 */
public class TripplePiClientTest {
    
    public TripplePiClientTest() {
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
     * Test of logBasicSystemInfo method, of class TripplePiClient.
     */
    @Test
    public void testLogBasicSystemInfo() {
        System.out.println("logBasicSystemInfo");
        TripplePiClient instance = new TripplePiClient();
        instance.logBasicSystemInfo();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of main method, of class TripplePiClient.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TripplePiClient.main(args);
        try {
           //DataProviderCsv capi=new DataProviderCsv();
           //Optional<List<Generic>> olg=capi.select(ClassType.SCORE);
           //System.out.println(((Score)olg.get().get(5)).toString());
           //Score sc=new Score(7,4222,false,12);
           //List<Generic> ls = Arrays.asList(new Score(112,552,false,3),new Score(10,3973,true,1),new Score(9,35655,false,122));
           /*ls.get().add(new Score(7,4222,false,12));
           ls.get().add(new Score(8,3973,true,3));
           ls.get().add(new Score(9,35655,false,122));*/
           //System.out.println(((Score)ls.get(1)).toString());
           //System.out.println(((Score)ls.get(1)).toString());
           //System.out.println(capi.delete((Score)olg.get().get(4)).getStatus());
           //System.out.println(capi.insert(ls).getErrorMsg());
           //System.out.println(capi.insert(new Score(112,552,false,12)).getStatus());
           //System.out.println(capi.update(new Score(7,2323,false,7)).getStatus());
           //System.out.println(capi.haveUser(new Users(90,"sss","qqq","eee","2ww","faa222",true,false,2222,"ssss","ssss")).getStatus());
           //System.out.println(capi.haveUser(new Score(7,2323,false,1)).getStatus());
           //capi.deleteById(6, ClassType.USER);
            /*DataProviderCsv capi=new DataProviderCsv();
            DataProviderXml xapi=new DataProviderXml();
            System.out.println(xapi.insert(capi.getUserByID(1)));*/
            DataProviderXml xapi=new DataProviderXml();
            System.out.println(xapi.select(ClassType.TARIF).get().get(0).toString());
            
            /*INSERT*/
            /*DataProviderXml xapi=new DataProviderXml();
            DataProviderCsv capi=new DataProviderCsv();
            ContainerGeneric cg=new ContainerGeneric();
            cg.setContainer(capi.select(ClassType.TREND).get());
            System.out.println(xapi.insert(cg));*/
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(TripplePiClient.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
