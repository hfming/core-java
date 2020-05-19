package com.hfm.project.teammanage.entity;

import java.util.Objects;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description PC类 设备
 * @date 2020-04-18 11:30
 */
public class PC implements Equipment {
    /**
     * 模具
     */
    private String model;
    /**
     * 显示器
     */
    private String display;

    /**
     * 构造函数
     *
     * @param model   模具
     * @param display 显示器
     */
    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    @Override
    public String toString() {
        return "PC{" +
                "model='" + model + '\'' +
                ", display='" + display + '\'' +
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
        PC pc = (PC) o;
        return Objects.equals(model, pc.model) &&
                Objects.equals(display, pc.display);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, display);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }
}
