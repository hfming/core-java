package com.hfming.encapsulation;

/**
 * 封装Student类
 *
 * @author hfm
 * @version 1.01 -2019-10-16
 */
public class EncapsulationStudent {
    // 用private进行修饰，外部类不能进行访问，只有内部类可以进行访问
    private String name;
    private int age;

    /**
     * 成员方法
     */
    public void study() {
        System.out.println("study");
    }

    /**
     * 创建公共的 Get 与 Set 方法，使外部类可以间接访问本类成员变量
     * urn
     */
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
        if (age > 0){
            this.age = age;
        }else {
            System.out.println("输入错误值");
        }
    }
}
