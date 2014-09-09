/**
 * Copyright(C) 2014 Luvina
 *
 * DatabaseProperties.java, Jun 25, 2014 LA-PM
 *
 */
package net.luvina.manageuser.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * DatabaseProperties
 * @author LA-PM
 *
 */
@SuppressWarnings("unchecked")
public class DatabaseProperties {
    static private Map<String, String> data = new HashMap<String, String>();

    static {
        Properties prop = new Properties();
        try {
            prop.load(DatabaseProperties.class.getResourceAsStream(("/database.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Enumeration<String> en  = (Enumeration<String>)prop.propertyNames();
        while (en.hasMoreElements()) {
            String key = (String)en.nextElement();
            data.put(key, prop.getProperty(key));
        }
    }



    /**
     * getData
     * @param key Key
     * @return String
     */
    static public String getData(String key) {
        String string = "";
        if (data.containsKey(key)) {
            string = data.get(key);
        }
        return string;
    }
}
