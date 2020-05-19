package com.hfm.project.teammanage.entity;

import java.util.Objects;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 笔记本类 设备
 * @date 2020-04-18 11:32
 */
public class NoteBook implements Equipment {
    /**
     * 模具
     */
    private String model;
    /**
     * 价格
     */
    private double price;

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "model='" + model + '\'' +
                ", price=" + price +
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
        NoteBook noteBook = (NoteBook) o;
        return Double.compare(noteBook.price, price) == 0 &&
                Objects.equals(model, noteBook.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
