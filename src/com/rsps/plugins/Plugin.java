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

    private File dataPath;
    private PluginDescription description;

    public abstract void onEnable();

    public abstract void onDisable();

    public PluginDescription getDescription() {
        return description;
    }

    public Server getServer() {
        return RSPS.getServer();
    }
}
