/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=default_license
 * If you do not agree to the terms refrain yourself from using this source!
 */
package com.rsps.launch;


import com.rsps.color.ChatColor;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;
import org.fusesource.jansi.AnsiConsole;

/**
 *
 * @author Arix (Codiction)
 */
public class RSPS {

    private static Server server;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            for (String argument : args) {
                if (argument.equalsIgnoreCase("nojansi")) {
                    Config.USE_JANSI = false;
                }
            }
        }
        
        initJansi();
        initServer();
       
        
    }

    public RSPS() {}

    private static void initJansi() {
        if (Config.USE_JANSI) {
            AnsiConsole.systemInstall();
        }
    }
    
    private static void initServer() {
        setServer(Server.getInstance());
        
    }
    
    private static void setServer(Server s) {
        if(server != null) {
            return;
        }
        
        server = s;
    }
    
    public static Server getServer() {
        return server;
    }

    public static void println(Object clss, String message) {
        if (Config.USE_JANSI && isEnabled()) {
            AnsiConsole.out().println("<" + ChatColor.DARK_AQUA + clss.getClass().getSimpleName() + ChatColor.RESET + "> " + message + ChatColor.RESET);
        }
    }

}
