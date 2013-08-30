/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=default_license
 * If you do not agree to the terms refrain yourself from using this source!
 */
package com.rsps.event;

import com.rsps.launch.RSPS;
import com.rsps.plugins.Plugin;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arix (Codiction)
 */
public class EventManager {

    public void fireEvent(Event e) {

        Method[] methods;

        for (Plugin p : RSPS.getServer().getPluginManager().getPlugins()) {
            for (Method m : p.getDescription().methodCollection) {
                if (m.getAnnotation(EventHandler.class) != null) {
                    try {

                        if (m.getParameterTypes()[0].isAssignableFrom(e.getClass())) {
                            m.invoke(m.getDeclaringClass(), e);
                        }
                    } catch (IllegalAccessException ex) {
                    } catch (IllegalArgumentException ex) {
                    } catch (InvocationTargetException ex) {
                    }
                }
            }

        }
    }
}
