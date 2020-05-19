package com.hfm.project.teammanage.service;

import com.hfm.project.teammanage.entity.*;
import com.hfm.project.teammanage.myexception.EmployeeAddException;
import com.hfm.project.teammanage.myexception.EmployeeNoFoundException;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-18 12:14
 */
public class TeamService {
    /**
     * @Description 用于自动生成团队成员的memberId
     */
    private int counter;
    /**
     * @Description 团队人数上限
     */
    private final int MAX_MEMBER = 5;
    /**
     * @Description 保存当前团队成员
     */
    private Programmer[] programmers = new Programmer[MAX_MEMBER];
    /**
     * @Description 团队实际人数
     */
    private int total;

    /**
     * 包含所有成员对象的数组，数组大小与成员人数一致
     *
     * @return 返回当前团队的所有对象
     */
    public Programmer[] getTeam() {
        return programmers;
    }

    /**
     * 向团队中添加成员
     *
     * @param employee 开发人员 ID
     * @throws EmployeeAddException 添加失败，TeamException 中包含了失败原因
     */
    public void addMenber(Employee employee) throws EmployeeAddException {
        if (!(employee instanceof Programmer)) {
            throw new EmployeeAddException("该成员不是开发人员，无法添加");
        }

        total = getTotal();
        if (total >= MAX_MEMBER) {
            throw new EmployeeAddException("成员已满，无法添加");
        }
        // 数据类型转化
        Programmer programmer = (Programmer) employee;

        if (programmer.getStatus() == Status.VOCATION) {
            throw new EmployeeAddException("该员正在休假，无法添加");
        }
        if (programmer.getStatus() == Status.BUSY) {
            for (Programmer inEmployee : programmers) {
                if (inEmployee == programmer) {
                    throw new EmployeeAddException("该员工已在本开发团队中");
                }
            }
            throw new EmployeeAddException("该员工已是某团队成员");
        }
        int programmerCount = 0;
        int desginerCount = 0;
        int architectCount = 0;

        for (int i = 0; i < programmers.length; i++) {
            if (programmers[i] != null) {
                // employee 属于程序员类
                if (Programmer.class == programmers[i].getClass()) {
                    programmerCount++;
                    if (programmerCount >= 3) {
                        throw new EmployeeAddException("团队中至多只能有三名程序员");
                    }
                }
                // employee 属于设计师类
                if (programmers[i].getClass() == Designer.class) {
                    desginerCount++;
                    if (desginerCount >= 2) {
                        throw new EmployeeAddException("团队中至多只能有两名设计师");
                    }
                }
                // employee 属于构架师类
                if (programmers[i].getClass() == Architect.class) {
                    architectCount++;
                    if (architectCount >= 1) {
                        throw new EmployeeAddException("团队中至多只能有一名架构师");
                    }
                }
            }
        }

        // 添加员工
        for (int i = 0; i < programmers.length; i++) {
            if (programmers[i] == null) {
                programmers[i] = programmer;
                programmer.setStatus(Status.BUSY);
                if (programmer.getMemberId() == 0) {
                    programmer.setMemberId(++counter);
                }
                return;
            }
        }
    }

    /**
     * @return team 成员数目
     */
    public int getTotal() {
        total = 0;
        for (Programmer programmer : programmers) {
            if (programmer == null) {
                continue;
            } else {
                total++;
            }
        }
        return total;
    }

    /**
     * 从团队中删除成员
     *
     * @param menberId 待删除成员的 memberId
     * @throws EmployeeNoFoundException 找不到指定 memberId 的员工，删除失败
     */
    public void removeMenber(int menberId) throws EmployeeNoFoundException {
        for (int i = 0; i < total; i++) {
            // 找到指定 menberId 的员工，并删除
            if (programmers[i].getMemberId() == menberId) {
                programmers[i].setStatus(Status.FREE);
                programmers[i] = null;
                return;
            }
        }
        // 找不到指定 memberId 的员工，删除失败
        throw new EmployeeNoFoundException("找不到指定 memberId 的员工，删除失败");
    }
}
