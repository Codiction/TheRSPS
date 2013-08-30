/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsps.plugins;

import java.io.InputStream;
import java.lang.reflect.Method;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 *
 * @author Admin
 */
public class PluginDescriptionFile {
    
    FileConfiguration fc;
    
    //load some commonly used things into variables to avoid reading files
    private String name, mainClass;
    private int version;
    public Method[] methodCollection;
    public PluginDescriptionFile(InputStream s) {
        fc = YamlConfiguration.loadConfiguration(s);
        name = fc.getString("name");
        mainClass = fc.getString("main");
        version = fc.getInt("version");
    }
    
    public String getPluginName() {
        return fc.getString("name");
    }
    
    public String getMainClass() {
        return mainClass;
    }
    
    public int getVersion() {
        return version;
    }
}

