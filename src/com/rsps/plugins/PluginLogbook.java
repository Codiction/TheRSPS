/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsps.plugins;

import com.rsps.color.ChatColor;
import com.rsps.launch.RSPS;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.fusesource.jansi.AnsiConsole;

/**
 *
 * @author Admin
 */
public class PluginLogbook {

    private String name = null;
    String time;
    private Plugin plugin;

    public PluginLogbook(Plugin p) {
        name = p.getDescription().getPluginName();
        plugin = p;
    }

    private void calculateTime() {
        time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    public void info(String message) {
        calculateTime();
        if (!RSPS.isColorEnabled()) {
            System.out.println("[INFO] " + time + " <" + name + "> " + message);
        } else {
            AnsiConsole.out().println("[INFO] " + time + " <" + name + "> " + message + ChatColor.RESET);
        }
    }

    public void warn(String message) {
        calculateTime();
        if (!RSPS.isColorEnabled()) {
            System.out.println("[WARNING] " + time + " <" + name + "> " + message);
        } else {
            AnsiConsole.out().println("[" + ChatColor.GOLD + "WARNING" + ChatColor.RESET + "] " + time + " <" + name + "> " + message + ChatColor.RESET);
        }
    }

    public void error(String message) {
        calculateTime();
        if (!RSPS.isColorEnabled()) {
            System.out.println("[ERROR] " + time + " <" + name + "> " + message);
        } else {
            AnsiConsole.out().println("[" + ChatColor.RED + "ERROR" + ChatColor.RESET + "] " + time + " <" + name + "> " + message + ChatColor.RESET);
        }
    }

    public void debug(String message) {
        calculateTime();
        if (!plugin.isDebugMode()) {
            return;
        }

        if (!RSPS.isColorEnabled()) {
            System.out.println("[DEBUG] " + time + " <" + name + "> " + message);
        } else {
            AnsiConsole.out().println("[" + ChatColor.PURPLE + "DEBUG" + ChatColor.RESET + "] " + time + " <" + name + "> " + message + ChatColor.RESET);
        }
    }
}
