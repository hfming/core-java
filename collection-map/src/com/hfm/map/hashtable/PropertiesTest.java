package com.hfm.map.hashtable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-23 16:34
 */
public class PropertiesTest {
    public static void main(String[] args){
        try(FileInputStream fileInputStream = new FileInputStream(new File("collection-map/jdbc.properties")); ) {
            Properties properties = new Properties();
            properties.load(fileInputStream);

            String name = properties.getProperty("name");
            System.out.println(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
