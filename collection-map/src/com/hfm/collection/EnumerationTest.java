package com.hfm.collection;

import org.junit.jupiter.api.Test;

import java.util.Enumeration;
import java.util.StringTokenizer;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-17 2:21
 */
public class EnumerationTest {
    @Test
    public void enumerationTest() {
        // Enumration 接口不能创建对象，只能创建实现接口的类对象
        Enumeration enumeration = new Enumeration() {
            @Override
            public boolean hasMoreElements() {
                return false;
            }

            @Override
            public Object nextElement() {
                return null;
            }
        };
    }

    /**
     * Enumration 接口实现类 StringTokenizer
     */
    @Test
    public void stringTokenizerTest() {
        Enumeration enumeration = new StringTokenizer("A-B-C", "-");
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
    }
}
