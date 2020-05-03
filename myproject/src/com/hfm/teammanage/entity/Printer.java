package com.hfm.teammanage.entity;

import java.util.Objects;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 键盘类 设备
 * @date 2020-04-18 11:35
 */
public class Printer implements Equipment {
    /**
     * 名称
     */
    private String name;
    /**
     * 类型
     */
    private String type;

    /**
     * 构造函数
     *
     * @param name 名称
     * @param type 类型
     */
    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Printer{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Printer printer = (Printer) o;
        return Objects.equals(name, printer.name) &&
                Objects.equals(type, printer.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }
}
