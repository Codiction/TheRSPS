/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=default_license
 * If you do not agree to the terms refrain yourself from using this source!
 */

package com.rsps.plugins.exceptions;

import com.rsps.launch.RSPS;
import com.rsps.plugins.Plugin;

/**
 *
 * @author Arix (Codiction)
 */
public class IncompatiblePluginException extends Exception {

    public IncompatiblePluginException() {
        super("Plugin is not compatible with this version of the server.");
    }
    
    public IncompatiblePluginException(Plugin p) {
        super("'" + p.getDescription().getName() + "' does not meet the requirements for this server version " + RSPS.getServer().getVersion());
    }
}
