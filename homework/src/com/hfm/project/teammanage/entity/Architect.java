package com.hfm.project.teammanage.entity;

import java.util.Objects;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 架构师类
 * @date 2020-04-18 11:50
 */
public class Architect extends Designer {
    /**
     * @Description 表示公司奖励的股票数量
     */
    private int stock;

    /**
     * 构造函数
     *
     * @param id        ID
     * @param name      姓名
     * @param age       年龄
     * @param saraly    薪水
     * @param equipment 设备
     * @param bonus     奖金
     * @param stock     股票
     */
    public Architect(int id, String name, int age, double saraly, Equipment equipment, double bonus, int stock) {
        super(id, name, age, saraly, equipment, bonus);
        this.stock = stock;
    }

    @Override
    public String getDetailsForTeam() {
        return getMemberDetails() + "\t架构师\t" +
                getBonus() + "\t" + getStock();
    }

    @Override
    public String toString() {
        return getDetails() + "\t架构师\t" + getStatus() + "\t" +
                getBonus() + "\t" + getStock() + "\t" + getEquipment().getDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Architect)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Architect architect = (Architect) o;
        return getStock() == architect.getStock();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getStock());
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
