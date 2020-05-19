package com.hfm.originalproject.bank.entity;

import java.io.Serializable;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-17 13:01
 */
public class SavingAccount extends Account implements Serializable {
    private static final long serialVersionUID = 3559982375243584305L;

    private double interestRate;

    /**
     * 构造函数
     *
     * @param balance
     */
    public SavingAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }
}
