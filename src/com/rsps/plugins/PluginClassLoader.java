/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsps.plugins;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class PluginClassLoader extends URLClassLoader {

    private final PluginLoader loader;
    private final Map<String, Class<?>> classes = new HashMap<String, Class<?>>();
    

    public PluginClassLoader(final PluginLoader loader, final URL[] urls, final ClassLoader parent) {
        this(loader, urls, parent, null);
    }

    PluginClassLoader(final PluginLoader loader, final URL[] urls, final ClassLoader parent, PluginDescriptionFile pdf) {
        super(urls, parent);
        this.loader = loader;
        constructClassCache(pdf);
    }

    @Override
    public void addURL(URL url) {
        super.addURL(url);
    }

    public final void constructClassCache(PluginDescriptionFile p) {
        List<Method> collection = new ArrayList();
        for (String c : getClasses()) {
            try {
                Object found = findClass(c);
                for (Method m : found.getClass().getMethods()) {
                    collection.add(m);
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        p.methodCollection = collection.toArray(new Method[0]);

    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> foundClass = classes.get(name);

        if (foundClass == null) {
            foundClass = super.findClass(name);

            if (foundClass != null) {
                classes.put(name, foundClass);
            }
        }

        return foundClass;
    }

    public Set<String> getClasses() {
        return classes.keySet();
    }
}
