package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {

    //To read properties from Configuration
    private static Properties properties;

    static {
        String path = "Config.properties";
        try {

            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}

