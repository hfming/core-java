package com.hfm.project.teammanage.view;

import com.hfm.project.teammanage.service.TeamService;
import com.hfm.project.teammanage.entity.Employee;
import com.hfm.project.teammanage.myexception.EmployeeAddException;
import com.hfm.project.teammanage.myexception.EmployeeNoFoundException;
import com.hfm.project.teammanage.service.NameListService;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-18 18:16
 */
public class TeamView {
    private static NameListService nameListService = new NameListService();
    private static TeamService teamService = new TeamService();
    private static Scanner scanner = new Scanner(System.in);
    private static final StringBuilder[] SELECT_NUMS = new StringBuilder[]{new StringBuilder("1"), new StringBuilder("2"),
            new StringBuilder("3"), new StringBuilder("4")};
    private static final StringBuilder[] VERIFY = new StringBuilder[]{new StringBuilder("Y"), new StringBuilder("N")};

    public static void main(String[] args) {
        // 选择
        StringBuilder selectNum;
        try {
            printMainView();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        OUT:
        while (true) {

            selectNum = new StringBuilder(scanner.next());
            // 团队列表
            if (SELECT_NUMS[0].toString().equals(selectNum.toString())) {
                printAllEmployee();
                try {
                    printMainView();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                continue;
            }
            // 添加团队成员
            if (SELECT_NUMS[1].toString().equals(selectNum.toString())) {
                addEmployee();
                try {
                    printMainView();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                continue;
            }
            // 删除团队成员
            if (SELECT_NUMS[2].toString().equals(selectNum.toString())) {
                delectEmployee();
                try {
                    printMainView();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                continue;
            }
            //  退出程序
            if (SELECT_NUMS[3].toString().equals(selectNum.toString())) {
                if (exit()) {
                    try {
                        printMainView();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    continue;
                }
                break;
            }
            System.out.print("输入错误，请重新输入:");
        }
    }


    private static void printAllEmployee() {
        System.out.println("----------------------团队成员列表----------------------");
        if (teamService.getTotal() == 0) {
            System.out.println("开发团队目前没有成员！");
        } else {
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
            for (int i = 0; i < teamService.getTeam().length; i++) {
                if (teamService.getTeam()[i] != null) {
                    System.out.println(teamService.getTeam()[i].getDetailsForTeam());
                }
            }
        }
        System.out.println("-------------------------------------------------------");
        // 按回车键继续...
        TSUtility.readReturn();
    }

    private static void addEmployee() {
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加的员工ID：");
        int id = scanner.nextInt();
        try {
            Employee e = nameListService.getEmployeeById(id);
            // System.out.println(e.toString());
            teamService.addMenber(e);
            System.out.println("---------------------添加成功---------------------");
        } catch (EmployeeAddException e) {
            System.out.println("添加失败，原因：" + e.getMessage());
        }
        // 按回车键继续...
        TSUtility.readReturn();
    }

    private static void delectEmployee() {
        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除员工的TID：");
        int id = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N)：");
        char yn = TSUtility.readConfirmSelection();
        if (Objects.equals('N', yn)) {
            return;
        }
        try {
            teamService.removeMenber(id);
            System.out.println("---------------------删除成功---------------------");
        } catch (EmployeeNoFoundException e) {
            System.out.println("删除失败，原因：" + e.getMessage());
        }
        // 按回车键继续...
        TSUtility.readReturn();
    }


    /**
     * @Description 打印主页面
     */
    private static void printMainView() throws Exception {
        System.out.println("----------------------开发团队调度软件----------------------");
        Employee[] employees = nameListService.getAllEmployees();
        if (employees.length == 0) {
            throw new Exception("员工数据加载错误，请检查程序!");
        } else {
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
            for (Employee employee : employees) {
                System.out.println(" " + employee);
            }
        }
        System.out.println("-----------------------------------------------------------");
        System.out.print("1 团队列表\t2 添加团队成员\t3 删除团队成员\t4-退出程序\t请选择(1-4):");
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
}
