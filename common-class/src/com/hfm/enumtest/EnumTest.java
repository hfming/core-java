package com.hfm.enumtest;

import java.util.*;

/**
 * 枚举类的使用
 *
 * @author Cay Horstmann
 * @version 1.0 2004-05-24
 */
public class EnumTest {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job--you paid attention to the _.");
        }
    }
}

/**
 * 枚举类 大 中 小 巨大
 */
enum Size {
    // 枚举对象
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L"),
    EXTRA_LARGE("XL");

    // 私有化构造方法
    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    private String abbreviation;
}
