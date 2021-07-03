package com.hfm.comunication.producerconsumer;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 美食家
 * @date 2020-05-07 11:33
 */
public class Foodie implements Serializable, Runnable {
    private static final long serialVersionUID = 4795997072516333119L;
    private long id;
    private String name;
    private int age;

    private Bun bun;

    public Foodie(String name, Bun bun) {
        this.name = name;
        this.bun = bun;
    }

    /**
     * 线程方法：如果没有包子了，需要通知包子店生成包子
     */
    @Override
    public void run() {
        // 一直循环唤醒
        while (true) {
            synchronized (bun) {
                // 没包子
                if (bun.isFlag() == false) {
                    try {
                        bun.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("吃货正在吃" + bun.getPier() + bun.getXianer() + "包子");
                bun.setFlag(false);
                bun.notify();
            }
        }
    }

    public Foodie() {
    }

    public Foodie(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Foodie(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Foodie)) {
            return false;
        }
        Foodie foodie = (Foodie) o;
        return getId() == foodie.getId() &&
                getAge() == foodie.getAge() &&
                Objects.equals(getName(), foodie.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge());
    }

    @Override
    public String toString() {
        return "Foodie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
