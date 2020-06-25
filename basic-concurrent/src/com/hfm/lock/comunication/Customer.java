package com.hfm.lock.comunication;

/**
 * 消费者类
 *
 * @author hfm
 */
public class Customer extends Thread {
    private Employee employee;

    public Customer(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void run() {
        employee.sale();
    }
}
