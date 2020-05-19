package com.hfm.originalproject.bank.entity;

import com.hfm.originalproject.bank.execption.OverdraftException;

import java.io.Serializable;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-17 13:04
 */
public class CheckingAccount extends Account implements Serializable {
    private static final long serialVersionUID = -1854241550545006425L;
    /**
     * 透支额度
     */
    private double overdraftProtection;

    /**
     * 构造函数
     *
     * @param balance
     * @param overdraftProtection
     */
    public CheckingAccount(double balance, double overdraftProtection) {
        super(balance);
        this.overdraftProtection = overdraftProtection;
    }

    @Override
    public void withdraw(double takeMoney) throws OverdraftException {
        // 如果不够弥补但是存在透支保护，则尝试用 overdraftProtection 得值来弥补该差值（balance-amount）
        if (takeMoney > balance && takeMoney < (balance + overdraftProtection)) {
            // 取出账户中所有的钱
            super.withdraw(balance);
        }
        // 如果弥补该透支所需要的金额大于当前的保护级别。则整个交易失败，但余额未受影响。
        if (takeMoney > (balance + overdraftProtection)) {
            // 抛出透支异常警报
            // 不足育余额 takeMoney - balance - overdraftProtection
            throw new OverdraftException("Insufficient funds for overdraft protection", (takeMoney - balance - overdraftProtection));
        }
        // 如果当前余额足够弥补取款 amount,则正常进行。
        super.withdraw(takeMoney);
    }
}
