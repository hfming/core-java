package com.hfm.originalproject.teammanage.service;

import com.hfm.originalproject.teammanage.domain.*;

public class NameListService {
	private Employee[] employees;
	public NameListService() {
		employees = new Employee[Data.EMPLOYEES.length];

		for (int i = 0; i < employees.length; i++) {
			// 获取通用的属性
			int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
			int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
			String name = Data.EMPLOYEES[i][2];
			int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
			double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

			//
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
				employees[i] = new Architect(id, name, age, salary, eq, bonus,
						stock);
				break;
			}
		}
	}

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

	public Employee[] getAllEmployees() {
		return employees;
	}

	public Employee getEmployee(int id) throws TeamException {
		for (Employee e : employees) {
			if (e.getId() == id) {
				return e;
			}
		}
		throw new TeamException("该员工不存在");
	}
}
