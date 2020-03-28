package com.hfm.entity;

/**
 * 实体类
 *
 * @author hfm
 * @version 1.01 2019-10-18
 */
public class Book {
    private int id;
    private String name;
    private double price;

    /**
     * 重写toString
     *
     * @return
     */
    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

    /**
     * 重写hashCode
     *
     * @return
     */
    @Override
    public int hashCode() {
        return id;
    }

    /**
     * 重写equals
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        return true;
    }

    /**
     * 无参构造函数
     */
    public Book() {
        super();
    }

    /**
     * 全参构造函数
     *
     * @param id
     * @param name
     * @param price
     */
    public Book(int id, String name, double price) {
        this();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
