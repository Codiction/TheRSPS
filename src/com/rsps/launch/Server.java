/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=default_license
 * If you do not agree to the terms refrain yourself from using this source!
 */
package com.rsps.launch;

import com.rsps.plugins.PluginManager;

/**
 *
 * @author Arix (Codiction)
 */
public class Server {
    
    private boolean running = false;
    private PluginManager pluginManager;
    
    
    private Server() {
        
    }
    
    public void start() {
        pluginManager = new PluginManager();
    }
    
    public PluginManager getPluginManager() {
        return pluginManager;
    }
    
    public int getVersion() {
        return Config.SERVER_VERSION;
    }
    
    
    public static Server getInstance() {
        return ServerHolder.INSTANCE;
    }
    
    private static class ServerHolder {

        private static final Server INSTANCE = new Server();
    }
}
