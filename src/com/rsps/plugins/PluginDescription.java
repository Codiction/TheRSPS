/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=default_license
 * If you do not agree to the terms refrain yourself from using this source!
 */
package com.rsps.plugins;

import com.rsps.launch.RSPS;
import java.util.List;

/**
 *
 * @author Arix (Codiction)
 */
public class PluginDescription {

    private String name;
    private int version;
    private String mainClass;
    public List<String> dependencies;
    private String minimumServerBuild;

    public PluginDescription(String pluginName, String main, int version, List<String> deps, String minServerBuild) {
        dependencies = deps;
        name = pluginName;
        this.version = version;
        mainClass = main;
        minimumServerBuild = minServerBuild;
    }

    public String getName() {
        return name;
    }

    public int getVersion() {
        return version;
    }

    public String getMainClass() {
        return mainClass;
    }

    public boolean isCompatibleWithServer() {
        if(getVersion() >= RSPS.getServer().getVersion()) {
            return true;
        } else {
            return false;
        }
    }
}
