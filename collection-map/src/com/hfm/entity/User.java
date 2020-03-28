package com.hfm.entity;

/**
 * 用户类
 *
 * @author hfm
 * @version 1.01 2019-10-18
 */
public class User {
    private int id;
    private String name;
    private String passWord;

    /**
     * 无参构造方法
     */
    public User() {
        super();
    }

    /**
     * 全参构造方法
     *
     * @param
     * @param
     */
    public User(int id, String userName, String passWord) {
        super();
        this.id = id;
        this.name = userName;
        this.passWord = passWord;
    }

    /**
     * 重写 toString
     *
     * @return
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + name + ", passWord=" + passWord + "]";
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
     * 重写 equals
     *
     * @param
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        User user = null;
        if (obj instanceof User) {
            user = (User) obj;
        }
        if (user.getId() == this.id && user.getName().equals(this.name) && user.getPassWord().equals(this.passWord)) {
            return true;
        }
        return false;
    }

    /**
     * 公共Set与get方法
     *
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        this.name = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
