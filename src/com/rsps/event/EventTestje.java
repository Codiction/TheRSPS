/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsps.event;

import com.rsps.event.events.PlayerDeathEvent;
import com.rsps.event.events.PlayerMoveEvent;

/**
 *
 * @author Admin
 */
public class EventTestje {
    
    @EventHandler
    public void test(PlayerMoveEvent e) {
        System.out.println(e.getName());
    }
    
    @EventHandler
    public void test2(PlayerDeathEvent e) {
        System.out.println(e.getName());
    }
}
