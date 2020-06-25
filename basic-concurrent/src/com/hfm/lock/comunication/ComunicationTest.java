package com.hfm.lock.comunication;

/**
 * 线程通信测试
 */
public class ComunicationTest {
    public static void main(String[] args) {
        Employee employee = new Employee();
        //创建线程对象
        Producer producer = new Producer(employee);
        Customer customer = new Customer(employee);
        //启动线程
        producer.start();
        customer.start();
    }
}
