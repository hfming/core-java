package com.hfm.project.familyaccount.view;

import java.util.Scanner;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 模拟实现一个基于文本界面的《家庭记账软件》
 * @date 2020-04-17 15:38
 */
public class FamilyAccount {
    /**
     * 家庭起始的生活基本金为 10000 元。
     */
    private static double originalMoney = 10000.0;
    private static Scanner scanner = new Scanner(System.in);
    private static final StringBuilder[] SELECT_NUMS = new StringBuilder[]{new StringBuilder("1"), new StringBuilder("2"),
            new StringBuilder("3"), new StringBuilder("4")};
    private static final StringBuilder[] VERIFY = new StringBuilder[]{new StringBuilder("Y"), new StringBuilder("N")};

    public static void main(String[] args) {
        // 选择
        StringBuilder selectNum;
        // 账户详情
        StringBuilder accountDetail = new StringBuilder();
        while (true) {
            selectNum = new StringBuilder(scanner.next());
            // 收支明细
            if (SELECT_NUMS[0].toString().equals(selectNum.toString())) {
                detil(accountDetail);
                printMainView();
                continue;
            }
            // 登记收入
            if (SELECT_NUMS[1].toString().equals(selectNum.toString())) {
                income(accountDetail);
                printMainView();
                continue;
            }
            // 登记支出
            if (SELECT_NUMS[2].toString().equals(selectNum.toString())) {
                disburse(accountDetail);
                printMainView();
                continue;
            }
            //  退出程序
            if (SELECT_NUMS[3].toString().equals(selectNum.toString())) {
                if (exit()) {
                    continue;
                }
                break;
            }
            System.out.println("--------------输入错误，请重新输入--------------");
        }
    }

    /**
     * 退出
     *
     * @return 返回 boolean
     */
    private static boolean exit() {
        StringBuilder selectNum;
        System.out.print("即将退出程序，请确认(Y/N):");
        while (true) {
            selectNum = new StringBuilder(scanner.next());
            if (VERIFY[0].toString().equalsIgnoreCase(selectNum.toString())) {
                System.out.println("--------------退出程序，期待您再次使用--------------");
                return false;
            }
            if (VERIFY[1].toString().equalsIgnoreCase(selectNum.toString())) {
                System.out.println("--------------返回程序主界面--------------");
                return true;
            }
            System.out.print("输入错误，请重新输入：");
        }
    }

    /**
     * 账户详情
     *
     * @param accountDetil 详细信息
     */
    private static void detil(StringBuilder accountDetil) {
        System.out.println("--------------收支明细--------------");
        System.out.println("收支\t收支金额\t账户余额\t收支说明");
        System.out.println(accountDetil);
    }

    /**
     * 登记支出
     *
     * @param accountDetil 详细信息
     */
    private static void disburse(StringBuilder accountDetil) {
        double balance;
        System.out.print("本次支出金额：");
        while (true) {
            try {
                balance = Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.print("输入金额有错误，请重新输入:");
                continue;
            }
            if (originalMoney == 0) {
                System.out.println("--------------账户剩余 0 元,返回主界面--------------");
                detil(accountDetil);
                return;
            }
            if (balance > originalMoney) {
                System.out.print("账户剩余不足，输入金额有误，请重新输入:");
                detil(accountDetil);
                continue;
            }
            break;
        }
        System.out.print("本次支出入说明：");
        originalMoney -= balance;
        accountDetil.append("支出\t").append(balance).append("\t\t").append(originalMoney).append("\t\t").append(scanner.next()).append("\r\n");
    }

    /**
     * 登记收入
     *
     * @param accountDetil 详细信息
     */
    private static void income(StringBuilder accountDetil) {
        double balance;
        System.out.print("本次收入金额：");
        while (true) {
            try {
                balance = Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.print("输入金额有错误，请重新输入:");
                continue;
            }
            break;
        }
        System.out.print("本次收入说明：");
        originalMoney += balance;
        accountDetil.append("收入\t").append(balance).append("\t\t").append(originalMoney).append("\t\t").append(scanner.next()).append("\r\n");
    }

    /**
     * 打印主页面信息
     */
    public static void printMainView() {
        System.out.println("--------------家庭收支记账软件--------------");
        System.out.println("              1. 收支明细                   ");
        System.out.println("              2. 登记收入                   ");
        System.out.println("              3. 登记支出                   ");
        System.out.println("              4. 退出程序                   ");
        System.out.print("请输入整数 1-4 进行选择：");
    }
}
