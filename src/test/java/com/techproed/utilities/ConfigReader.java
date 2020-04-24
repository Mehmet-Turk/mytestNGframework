package com.techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //this class reads information from configuration.properties file and pass information to other classes
    private static Properties properties;

    static{
        String path = "configuration.properties";
        try {
            FileInputStream file = new FileInputStream(path);//opening the file
            properties = new Properties();//initialize the properties file
            properties.load(file);//loading the file
            file.close();//closing the file
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
