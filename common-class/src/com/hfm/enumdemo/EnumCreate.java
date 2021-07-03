package com.hfm.enumdemo;

import org.junit.jupiter.api.Test;

/**
 * @author hfm
 * @version 1.01 2020-04-08 18:49
 * @date 2020/4/8
 * @Description 枚举类的创建
 */
public class EnumCreate {
    @Test
    public void enumTest() {
        // JDK 5.0 之前自定义枚举类
        System.out.println(Season.AUTUMN);
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.WINTER);

        // JDK 5.0 之后使用 Enum 创建枚举类对象
        SeasonEnum autumn = SeasonEnum.AUTUMN;
        System.out.println(autumn);
        System.out.println(autumn.toString());

        // 返回所有枚举对象
        SeasonEnum[] values = SeasonEnum.values();
        for (SeasonEnum seasonEnum : values) {
            System.out.println(seasonEnum);
        }

        // 返回指定的枚举对象
        SeasonEnum seasonEnum = SeasonEnum.valueOf("SPRING");
        System.out.println(seasonEnum);
    }
}

/**
 * 自定义枚举类
 */
class Season {
    // 枚举类中的属性值必须是 private final 修饰的
    /**
     * 季节的名称
     */
    private final String SEASONNAME;
    /**
     * 季节的描述
     */
    private final String SEASONDESC;

    /**
     * 1. 私有化类的构造器，保证不能在类的外部创建其对象
     *
     * @param seasonName
     * @param seasonDesc
     */
    private Season(String seasonName, String seasonDesc) {
        this.SEASONNAME = seasonName;
        this.SEASONDESC = seasonDesc;
    }

    /**
     * 2. 在类的内部创建枚举类的实例。声明为：public static final
     */
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "白雪皑皑");

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Season{");
        sb.append("SEASONNAME='").append(SEASONNAME).append('\'');
        sb.append(", SEASONDESC='").append(SEASONDESC).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getSEASONNAME() {
        return SEASONNAME;
    }

    public String getSEASONDESC() {
        return SEASONDESC;
    }
}

/**
 * 使用 Emum 创建枚举类
 */
enum SeasonEnum {
    // 枚举对象
    SPRING("春天", "春风又绿江南岸"),
    SUMMER("夏天", "映日荷花别样红"),
    AUTUMN("秋天", "秋水共长天一色"),
    WINTER("冬天", "窗含西岭千秋雪");
    private final String SEASONNAME;
    private final String SEASONDESC;

    private SeasonEnum(String seasonName, String seasonDesc) {
        this.SEASONNAME = seasonName;
        this.SEASONDESC = seasonDesc;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SeasonEnum{");
        sb.append("seasonName='").append(SEASONNAME).append('\'');
        sb.append(", seasonDesc='").append(SEASONDESC).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getSeasonName() {
        return SEASONNAME;
    }

    public String getSeasonDesc() {
        return SEASONDESC;
    }
}