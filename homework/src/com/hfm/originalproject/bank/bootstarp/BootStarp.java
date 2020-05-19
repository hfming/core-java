package com.hfm.originalproject.bank.bootstarp;

import com.hfm.originalproject.bank.entity.Bank;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 主方法
 * @date 2020-05-17 13:54
 */
public class BootStarp {
    public static void main(String[] args) {
        // 1.创建银行对象
        Bank bank = Bank.getBank();

        // 获取客户个数
        System.out.println(bank.getNumberOfCustomer());

        // 添加用户
        bank.addCustomer("h", "fm");
        bank.addCustomer("h", "fm");
        bank.addCustomer("h", "fa");
        bank.addCustomer("h", "fl");
        System.out.println(bank.getNumberOfCustomer());
    }
}
