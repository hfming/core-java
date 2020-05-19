package com.hfm.project.teammanage.entity;

import java.util.Objects;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 设计师类
 * @date 2020-04-18 11:48
 */
public class Designer extends Programmer {
    /**
     * @Description 表示奖金
     */
    private double bonus;

    /**
     * @param id        ID
     * @param name      姓名
     * @param age       年龄
     * @param salary    薪水
     * @param equipment 设备
     * @param bonus     奖金
     */
    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }
    @Override
    public String getDetailsForTeam() {
        return getMemberDetails() + "\t设计师\t" + getBonus();
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" +
                getBonus() + "\t\t\t" + getEquipment().getDescription();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Designer)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Designer designer = (Designer) o;
        return Double.compare(designer.getBonus(), getBonus()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBonus());
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
