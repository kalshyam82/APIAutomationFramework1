package com.tmb.utils;

import com.constants.FrameworkConstants;
import com.enums.PropertiesType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils(){}

    private static Properties properties = new Properties();
    private static Map<String, String> map = new HashMap<>();

    public static void readPropertyFileandStoreInMap(){
        try {
            FileInputStream inputStream = new FileInputStream("");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
     //   properties.forEach((key, value) -> map.put(String.valueOf(key), String.valueOf(value)));

        for(Map.Entry<Object,Object> temp: properties.entrySet()){
            String key = String.valueOf(temp.getKey());
            String value = String.valueOf(temp.getValue());
            map.put(key, value);
        }
    }
    static {
        try(FileInputStream inputStream = new FileInputStream(FrameworkConstants.getPropertyFilePath())) {
                 properties.load(inputStream);
        }   catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        //   properties.forEach((key, value) -> map.put(String.valueOf(key), String.valueOf(value)));

        for(Map.Entry<Object,Object> temp: properties.entrySet()){
            String key = String.valueOf(temp.getKey());
            String value = String.valueOf(temp.getValue());
            map.put(key, value);
           // System.out.println("value = " + value);
        }
    }
    public static String getValue(PropertiesType key){

        return map.get(key.name().toLowerCase());
    }
}
