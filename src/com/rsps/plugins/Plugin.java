/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=default_license
 * If you do not agree to the terms refrain yourself from using this source!
 */
package com.rsps.plugins;

import com.rsps.launch.RSPS;
import com.rsps.launch.Server;
import java.io.File;

/**
 *
 * @author Arix (Codiction)
 */
public abstract class Plugin {
    
    private File dataPath = null;
    private PluginDescriptionFile description = null;
    private boolean isEnabled = false;
    private ClassLoader classLoader = null;
    private PluginLogbook logger = null;
    private boolean debug = false;
    
    private boolean initialized = false;
    
    public final boolean isDebugMode() {
        return debug;
    }
    
    public final void init(PluginDescriptionFile desc, ClassLoader loader, PluginLogbook logbook, File datafolder) {
        if(!initialized) {
            initialized = true;
            description = desc;
            classLoader = loader;
            logger = logbook;
            dataPath = datafolder;
        }
    }
    
    public final ClassLoader getClassLoader() {
        return classLoader;
    }
    
    public File getDataFolder() {
        return dataPath;
    }
    
    public final void setDebugMode(boolean flag) {
        debug = flag;
    }

    public abstract void onEnable();

    public abstract void onDisable();

    public final PluginDescriptionFile getDescription() {
        return description;
    }

    public final Server getServer() {
        return RSPS.getServer();
    }
    
    public final PluginLogbook getLogger() {
        return logger;
    }
}
