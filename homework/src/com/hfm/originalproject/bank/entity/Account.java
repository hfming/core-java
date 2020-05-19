package com.hfm.originalproject.bank.entity;

import com.hfm.originalproject.bank.execption.OverdraftException;

import java.io.Serializable;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 银行账户实体类
 * @date 2020-05-17 12:29
 */
public class Account implements Serializable {
    private static final long serialVersionUID = 7844811280809751213L;
    /**
     * 余额
     */
    protected double balance;

    /**
     * 构造函数
     *
     * @param balance
     */
    public Account(double balance) {
        this.balance = balance;
    }

    /**
     * 声明一个公有方法 geBalance，该方法用于获取当前余额。
     *
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 声明一个公有方法 deposit,该方法向当前余额增加金额。
     *
     * @param addMoney
     * @return
     */
    public boolean deposit(double addMoney) {
        this.balance += addMoney;
        return true;
    }

    /**
     * 声明一个公有方法 withdraw 从当前余额中减去金额。
     *
     * @param takeMoney
     * @throws OverdraftException
     */
    public void withdraw(double takeMoney) throws OverdraftException {
        if (this.balance < takeMoney) {
            // 抛出透支异常警报
            // 不足余额 takeMoney - balance
            throw new OverdraftException("no overdraft protection", takeMoney - balance);
        } else {
            this.balance -= takeMoney;
        }
    }
}
