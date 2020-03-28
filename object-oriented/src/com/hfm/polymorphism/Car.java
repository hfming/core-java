package com.hfm.polymorphism;

public abstract class Car {
    private String name;
    private String uuid;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 车类构造方法
     *
     * @param name
     * @param uuid
     * @param color
     */
    public Car(String name, String uuid, String color) {
        this.name = name;
        this.uuid = uuid;
        this.color = color;
    }

    public abstract void run();

    public static void speedUp() {
        System.out.println("父类加速方法！");
    }
}
