/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsps.plugins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class PluginManager {
    
    HashMap<String, PluginClassLoader> pluginLoaders = new HashMap();
    List<Plugin> plugins = new ArrayList();
    
    public void addLoader(String name, PluginClassLoader loader) {
        pluginLoaders.put(name, loader);
    }
    
    public void removeLoader(String name) {
        pluginLoaders.remove(name);
    }
    
    public void addPlugin(Plugin p) {
        plugins.add(p);
    }
    
    public void removePlugin(Plugin p) {
        plugins.remove(p);
    }
    
    public Set<String> getPluginLoaders() {
        return pluginLoaders.keySet();
    }
    
    public List<Plugin> getPlugins() {
        return plugins;
    }
    
    public Plugin getPlugin(String name) {
        for(Plugin p : getPlugins()) {
            if(p.getDescription().getPluginName().equals(name)) {
                return p;
            }
        }
        return null;
    }
    
    public PluginClassLoader getPluginClassLoader(String name) {
        return pluginLoaders.get(name);
    }
}
