package com.hfm.keywords.This;

/**
 * this 关键字的使用
 *
 * @author fhm
 * @version 1.01 2019-10-17
 */
public class Baby {

    private String id;
    private String name;

    /**
     * 无参构造方法
     */
    public Baby() {
        this.id = null;
        this.name = null;
        System.out.println("本类无参构造函数被调用了！");
    }

    /**
     * 构造方法
     *
     * @param id
     * @param name
     */
    public Baby(String id, String name) {
        // 调用本类无参构造函数
        this();
        // 使用this关键字指定使用本类成员变量
        this.id = id;
        this.name = name;
    }

    /**
     * 公共行为
     */
    public void cry() {
        String id = "001";
        // 使用this关键字指定使用本类成员变量
        System.out.println(this.id);
    }

    /**
     * set与get
     *
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
