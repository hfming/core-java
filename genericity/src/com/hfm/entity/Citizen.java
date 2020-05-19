package com.hfm.entity;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-30 17:56
 */
public class Citizen {
    private String name;

    public Citizen(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                '}';
    }
}
