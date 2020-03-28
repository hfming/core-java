package com.hfm.entity;

/**
 * 集合操作实体类
 *
 * @author hfm
 * @version 1.01 2019-10-18
 */
public class People {
    private String id;
    private String name;
    private int age;

    /**
     * 无参构造函数
     */
    public People() {
        super();
    }

    /**
     * 全参构造函数
     *
     * @param id
     * @param name
     * @param age
     */
    public People(String id, String name, int age) {
        this();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * 重写 toString
     *
     * @return
     */
    @Override
    public String toString() {
        return "People [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

    /**
     * 重写 hashCode
     *
     * @return
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /**
     * 重写 equals
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
        People other = (People) obj;
        if (age != other.age)
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    /**
     * 公共get 与Set方法
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
