/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsps.event;

import com.rsps.event.events.PlayerDeathEvent;
import com.rsps.event.events.PlayerMoveEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class EventManagerTest {
    
    public EventManagerTest() {
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
     * Test of fireEvent method, of class EventManager.
     */
    @Test
    public void testFireEvent() {
        System.out.println("fireEvent");
        Event e = new PlayerMoveEvent();
        Event e2 = new PlayerDeathEvent();
        EventManager instance = new EventManager();
        EventTestje ev = new EventTestje();
        instance.addEventContainer(ev);
        instance.fireEvent(e);
        instance.fireEvent(e2);
        
    }
    
}
