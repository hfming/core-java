package com.hfm.project.customermanage.view;

import com.hfm.project.customermanage.entity.Customer;
import com.hfm.project.customermanage.entity.Customers;
import com.hfm.project.customermanage.entity.Sex;

import java.util.Scanner;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 客户信息管理软件主界面
 * @date 2020-04-17 18:00
 */
public class CustomerView {
    private static Scanner scanner = new Scanner(System.in);
    private static final StringBuilder[] SELECT_NUMS = new StringBuilder[]{new StringBuilder("1"), new StringBuilder("2"), new StringBuilder("3"),
            new StringBuilder("4"), new StringBuilder("5"), new StringBuilder("6")};
    private static final StringBuilder[] VERIFY = new StringBuilder[]{new StringBuilder("Y"), new StringBuilder("N")};

    private static StringBuilder selectNum = null;
    private static StringBuilder name = null;
    private static StringBuilder sex = null;
    private static StringBuilder age = null;
    private static StringBuilder phoneNumber = null;
    private static StringBuilder email = null;
    private static Customer customer = null;
    /**
     * 客户类集合
     */
    private static Customers customers = new Customers();

    public static void main(String[] args) {
        while (true) {
            printMainView();
            selectNum = new StringBuilder(scanner.next());
            // 添加客户
            if (SELECT_NUMS[0].toString().equals(selectNum.toString())) {
                System.out.println("--------------添加客户--------------");
                if (addCustomer()) {
                    System.out.println("--------------添加完成--------------");
                }
                continue;
            }
            // 删除客户
            if (SELECT_NUMS[1].toString().equals(selectNum.toString())) {
                System.out.println("--------------删除客户--------------");
                if (removeCustomer()) {
                    System.out.println("--------------删除成功--------------");
                }
                continue;
            }
            // 修改客户
            if (SELECT_NUMS[2].toString().equals(selectNum.toString())) {
                System.out.println("--------------修改客户--------------");
                if (changeCustomer()) {
                    System.out.println("--------------修改成功--------------");
                }
                continue;
            }
            // 查询客户
            if (SELECT_NUMS[3].toString().equals(selectNum.toString())) {
                System.out.println("--------------查询客户--------------");
                if (printCustomer()) {
                    System.out.println("--------------查询成功--------------");
                }
                continue;
            }
            // 打印客户列表
            if (SELECT_NUMS[4].toString().equals(selectNum.toString())) {
                System.out.println("--------------查询所有客户--------------");
                boolean allCustomer = customers.getAllCustomer();
                if (allCustomer) {
                    System.out.println("--------------查询成功--------------");
                }
                continue;
            }
            // 退出程序
            if (SELECT_NUMS[5].toString().equals(selectNum.toString())) {
                System.out.print("即将退出程序，请确认(Y/N):");
                if (exit()) {
                    continue;
                }
                break;
            }
            System.out.print("输入错误，请重新输入：");
        }
    }

    /**
     * 打印指定客户
     *
     * @return 返回 boolean
     */
    private static boolean printCustomer() {
        int index;
        while (true) {
            System.out.print("请输入待打印用户ID(-1退出):");
            try {
                index = scanner.nextInt();
                if (index == -1) {
                    return true;
                }
                if (index < 0 || customers.getSize() < index) {
                    System.out.print("输入的 ID 错误，超出用户范围，查无此人，请重新输入:");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.print("输入的 ID 错误，请重新输入：");
                continue;
            }
            break;
        }
        if (customer == null) {
            return false;
        } else {
            System.out.println("ID\t姓名\t性别\t年龄\t电话号码\t邮箱");
            System.out.println(customer.getName() + "\t" + customer.getSex().getSex() + "\t" + customer.getAge() + "\t" + customer.getPhoneNumber() + "\t" + customer.getEmail());
            return true;
        }
    }

    /**
     * 修改客户信息
     *
     * @return 返回 boolean
     */
    private static boolean changeCustomer() {
        int index = 0;
        while (true) {
            System.out.print("请输入待修改用户ID(-1退出):");
            try {
                index = scanner.nextInt();
                if (index == -1) {
                    return true;
                }
                if (index < 0 || customers.getSize() < index) {
                    System.out.print("输入的 ID 错误，超出用户范围，查无此人，请重新输入:");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.print("输入的 ID 错误，请重新输入：");
                continue;
            }
            break;
        }
        customer = customers.getCustomer(index);
        if (customer == null) {
            return false;
        } else {
            customer.setName(setName().toString());
            customer.setAge(Integer.parseInt(setAge().toString()));
            customer.setSex((sex.toString().equals(Sex.MAN.getSex()) ? Sex.MAN : Sex.WOMAN));
            customer.setPhoneNumber(phoneNumber.toString());
            customer.setEmail(email.toString());
            return true;
        }
    }

    /**
     * 删除客户
     *
     * @return 返回 boolean
     */
    private static boolean removeCustomer() {
        int index = 0;

        while (true) {
            System.out.print("请输入待删除用户ID(-1退出):");
            try {
                index = scanner.nextInt();
                if (index == -1) {
                    return false;
                }
                if (index < 0 || customers.getSize() < index) {
                    System.out.print("输入的 ID 错误，超出用户范围，查无此人，请重新输入:");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.print("输入的 ID 错误，请重新输入：");
                continue;
            }
            break;
        }

        System.out.print("即将删除ID为" + index + "的客户，请确认(Y/N):");
        while (true) {
            selectNum = new StringBuilder(scanner.next());
            if (VERIFY[0].toString().equalsIgnoreCase(selectNum.toString())) {
                return customers.delectCustomer(index);
            }
            if (VERIFY[1].toString().equalsIgnoreCase(selectNum.toString())) {
                System.out.println("--------------返回程序主界面--------------");
                return false;
            }
            System.out.print("输入错误，请重新输入：");
        }
    }

    /**
     * 添加客户
     *
     * @return 返回 boolean
     */
    private static boolean addCustomer() {
        return customers.addCustomer(getCustomer());
    }

    /**
     * 设置对象
     *
     * @return null
     */
    private static Customer getCustomer() {
        name = setName();
        sex = setSex();
        age = setAge();
        phoneNumber = setPhoneNumber();
        email = setEmail();

        customer = new Customer(name.toString(), (sex.toString().equals(Sex.MAN.getSex()) ? Sex.MAN : Sex.WOMAN),
                Integer.parseInt(age.toString()), phoneNumber.toString(), email.toString());
        return customer;
    }

    /**
     * 设置姓名
     *
     * @return 返回 StringBuilder
     */
    private static StringBuilder setName() {
        System.out.print("姓名：");
        while (true) {
            name = new StringBuilder(scanner.next());
            // 1.可以是中文
            // 2.可以是英文，允许输入点（英文名字中的那种点）， 允许输入空格
            // 3.中文和英文不能同时出现
            // 4.长度在20个字符以内
            if (name.toString().matches("^(?:[\\u4e00-\\u9fa5]+)(?:●[\\u4e00-\\u9fa5]+)*$|^[a-zA-Z0-9]+\\s?[\\.·\\-()a-zA-Z]*[a-zA-Z]+$\n")) {
                break;
            } else {
                System.out.print("输出错误，请重新输入：");
            }
        }
        return name;
    }

    /**
     * 设置邮箱
     *
     * @return 返回 StringBuilder
     */
    private static StringBuilder setEmail() {
        System.out.print("邮箱：");
        while (true) {
            email = new StringBuilder(scanner.next());
            //
            if (email.toString().matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+")) {
                break;
            }
            System.out.print("输出错误，请重新输入：");
        }
        return email;
    }

    /**
     * 设置电话
     *
     * @return 返回 StringBuilder
     */
    private static StringBuilder setPhoneNumber() {
        System.out.print("电话：");
        while (true) {
            phoneNumber = new StringBuilder(scanner.next());
            // 匹配一个手机号
            // 手机号码的规则：
            // 1. 首位必须是1.
            // 2. 第二位： 3 4 、5 、 7、 8、
            // 3. 长度必须是11位
            if (phoneNumber.toString().matches("1[34578]\\d{9}")) {
                break;
            }
            System.out.print("输出错误，请重新输入：");
        }
        return phoneNumber;
    }

    /**
     * 设置年龄
     *
     * @return 返回 StringBuilder
     */
    private static StringBuilder setAge() {
        System.out.print("年龄：");
        while (true) {
            age = new StringBuilder(scanner.next());
            if (age.toString().matches("[1-9]|[1-9][0-9]|1[0-5][0-9]")) {
                break;
            }
            System.out.print("输出错误，请重新输入：");
        }
        return age;
    }

    /**
     * 设置性别
     *
     * @return 返回 StringBuilder
     */
    private static StringBuilder setSex() {
        System.out.print("性别：");
        while (true) {
            sex = new StringBuilder(scanner.next());
            if (sex.toString().matches("男") || sex.toString().matches("女")) {
                break;
            }
            System.out.print("输出错误，请重新输入：");
        }
        return sex;
    }

    /**
     * 退出程序
     *
     * @return 返回 StringBuilder
     */
    private static boolean exit() {
        do {
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
        } while (true);
    }

    /**
     * 打印主页面
     */
    private static void printMainView() {
        System.out.println("--------------客户信息管理软件--------------");
        System.out.println("              1. 添加客户                   ");
        System.out.println("              2. 删除客户                   ");
        System.out.println("              3. 修改客户                   ");
        System.out.println("              4. 查询客户                   ");
        System.out.println("              5. 打印客户列表               ");
        System.out.println("              6. 退出程序                   ");
        System.out.print("请输入整数 1-6 进行选择:");
    }
}
