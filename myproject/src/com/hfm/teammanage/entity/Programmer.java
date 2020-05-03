package com.hfm.teammanage.entity;

import java.util.Objects;

import static com.hfm.teammanage.entity.Status.FREE;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 程序员类：继承人员父类
 * @date 2020-04-18 11:25
 */
public class Programmer extends Employee {
    /**
     * @Description 用来记录成员加入开发团队后在团队中的ID
     */
    private int memberId;
    /**
     * 是项目service包下自定义的类，声明三个对象属性，分别表示成员的状态。
     * FREE-空闲
     * BUSY-已加入开发团队
     * VOCATION-正在休假
     */
    private Status status = FREE;
    /**
     * @Description 表示该成员领用的设备
     */
    private Equipment equipment;

    /**
     * 构造函数
     *
     * @param id        ID
     * @param name      姓名
     * @param age       年龄
     * @param saraly    薪水
     * @param equipment 设备
     */
    public Programmer(int id, String name, int age, double saraly, Equipment equipment) {
        super(id, name, age, saraly);
        this.equipment = equipment;
    }

    protected String getMemberDetails() {
        return getMemberId() + "/" + getDetails();
    }
    public String getDetailsForTeam() {
        return getMemberDetails() + "\t程序员";
    }

    @Override
    public String toString() {
        return getDetails() + "\t程序员\t" + status + "\t\t\t\t\t" + equipment.getDescription();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Programmer)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Programmer that = (Programmer) o;
        return getEquipment().equals(that.getEquipment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEquipment());
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int menberId) {
        this.memberId = menberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
