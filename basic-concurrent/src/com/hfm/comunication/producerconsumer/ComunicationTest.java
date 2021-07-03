package com.hfm.comunication.producerconsumer;

/**
 * 线程通信测试
 */
public class ComunicationTest {
    public static void main(String[] args) {
        //创建一个产品对象
        Product p = new Product();
        //创建线程对象
        Producer producer = new Producer(p);
        Customer customer = new Customer(p);
        //启动线程
        producer.start();
        customer.start();
    }
}
