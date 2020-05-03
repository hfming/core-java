package com.hfm.entity;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 季节枚举类
 * @date 2020-04-20 16:29
 */
public enum Season {
    /**
     * 春天
     */
    SPRING("春天"),
    /**
     * 夏天
     */
    SUMMER("夏天"),
    /**
     * 秋天
     */
    AUTUMN("秋天"),
    /**
     * 冬天
     */
    WINTER("冬天");
    private String season;

    private Season(String season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Season{" +
                "season='" + season + '\'' +
                '}';
    }

    public String getSeason() {
        return season;
    }
}

