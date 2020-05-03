package com.hfm.teammanage.service;

import com.hfm.teammanage.entity.*;
import com.hfm.teammanage.myexception.EmployeeNoFoundException;

import static com.hfm.teammanage.service.Data.EMPLOYEES;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 员工管理类
 * @date 2020-04-18 11:58
 */
public class NameListService {
    /**
     * @Description 用来保存公司所有员工对象
     */
    private Employee[] employees;

    /**
     * @Description 构造函数
     */
    public NameListService() {
        // 创建员工集合类
        this.employees = new Employee[Data.EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {
            // 获取通用的属性
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment eq;
            double bonus;
            int stock;
            switch (type) {
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case Data.PROGRAMMER:
                    eq = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, eq);
                    break;
                case Data.DESIGNER:
                    eq = createEquipment(i);
                    bonus = Integer.parseInt(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, eq, bonus);
                    break;
                case Data.ARCHITECT:
                    eq = createEquipment(i);
                    bonus = Integer.parseInt(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, eq, bonus, stock);
                    break;
            }
        }
    }

    /**
     * 创建设备
     *
     * @param index 员工 ID
     * @return 设备
     */
    private Equipment createEquipment(int index) {
        int type = Integer.parseInt(Data.EQIPMENTS[index][0]);
        switch (type) {
            case Data.PC:
                return new PC(Data.EQIPMENTS[index][1], Data.EQIPMENTS[index][2]);
            case Data.NOTEBOOK:
                int price = Integer.parseInt(Data.EQIPMENTS[index][2]);
                return new NoteBook(Data.EQIPMENTS[index][1], price);
            case Data.PRINTER:
                return new Printer(Data.EQIPMENTS[index][1], Data.EQIPMENTS[index][2]);
        }
        return null;
    }

    /**
     * @param id 指定员工的ID
     * @return 指定员工对象
     * @throws EmployeeNoFoundException 找不到指定的员工
     * @Description 获取指定ID的员工对象。
     */
    public Employee getEmployeeById(int id) throws EmployeeNoFoundException {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new EmployeeNoFoundException("没有找到该员工");
    }

    /**
     * @return 包含所有员工对象的数组
     * @Description 获取当前所有员工
     */
    public Employee[] getAllEmployees() {
        return employees;
    }
}
