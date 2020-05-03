package com.hfm.customermanage.entity;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 性别枚举类对象
 * @date 2020-04-17 17:18
 */
public enum Sex {
    /**
     * 男
     */
    MAN("男"),
    /**
     * 女
     */
    WOMAN("女");

    Sex(String sex) {
        this.sex = sex;
    }

    private final String sex;

    public String getSex() {
        return sex;
    }
}
