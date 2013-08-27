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

    public List<Object> eventContainers = new ArrayList();

    public void addEventContainer(Object c) {
        eventContainers.add(c);
    }

    public void fireEvent(Event e) {

        Method[] methods;

        for (Object o : eventContainers) {
            methods = o.getClass().getMethods();
            for (Method m : methods) {
                if (m.getAnnotation(EventHandler.class) != null) {
                    try {

                        if (m.getParameterTypes()[0].isAssignableFrom(e.getClass())) {
                            m.invoke(o, e);
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
