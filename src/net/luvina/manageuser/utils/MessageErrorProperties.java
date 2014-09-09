/**
 * Copyright(C) 2014 Luvina
 *
 * MessageErrorProperties.java, Jun 26, 2014 LA-PM
 *
 */
package net.luvina.manageuser.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * MessageErrorProperties
 *
 * @author LA-PM
 *
 */
public class MessageErrorProperties {
    static private Map<String, String> data = new HashMap<String, String>();

    /**
     *
     */
    static {
        Properties prop = new Properties();
        try {
            prop.load(MessageProperties.class.getResourceAsStream(("/message_error_ja.properties")));
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
     * getData from file properties
     * @param key key
     * @return String
     */
    static public String getMessage(String key) {
        String string = "";
        if (data.containsKey(key)) {
            string = data.get(key);
        }
        return string;
    }
}
