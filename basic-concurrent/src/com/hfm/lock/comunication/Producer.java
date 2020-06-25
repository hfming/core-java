package com.hfm.lock.comunication;

/**
 * 生产者类
 *
 * @author hfm
 */
public class Producer extends Thread {
    private Employee employee;

    public Producer(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void run() {
        employee.buy();
    }
}
