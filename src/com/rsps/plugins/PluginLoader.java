/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=default_license
 * If you do not agree to the terms refrain yourself from using this source!
 */
package com.rsps.plugins;

import com.rsps.launch.RSPS;
import com.rsps.plugins.exceptions.MissingFileException;
import com.sun.org.omg.SendingContext.CodeBasePackage.URLSeqHelper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 * @author Arix (Codiction)
 */
public class PluginLoader {

    public Plugin loadPlugin(File f) throws MissingFileException, IOException {
        if (!f.exists() || f.isDirectory()) {
            throw new MissingFileException("The path " + f.getAbsolutePath() + " is not a file or does not exist");
        }

        if (!f.getName().toLowerCase().endsWith(".jar")) {
            throw new MissingFileException("The file is not a jar file");
        }

        JarFile pluginJar = new JarFile(f);
        InputStream jarInputStream;
        JarEntry descEntry = pluginJar.getJarEntry("plugin.yml");

        jarInputStream = pluginJar.getInputStream(descEntry);
        PluginDescriptionFile pdf = new PluginDescriptionFile(jarInputStream);

        Plugin out = null;
        ClassLoader loader = null;

        try {
            URL[] urls = new URL[1];
            urls[0] = f.toURI().toURL();
            loader = new PluginClassLoader(this, urls, this.getClass().getClassLoader(), pdf);
            Class<?> jarClass = Class.forName(pdf.getMainClass(), true, loader);
            Class<? extends Plugin> plugin = jarClass.asSubclass(Plugin.class);

            Constructor<? extends Plugin> constructor = plugin.getConstructor();
            
            out = constructor.newInstance();
            RSPS.getServer().getPluginManager().addLoader(pdf.getPluginName(), (PluginClassLoader)loader);
        } catch (Exception e) {
        }
        return out;
    }

}
