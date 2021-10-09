package com.hfm.nochange;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-17 17:44
 * @Description
 * @date 2021/9/17
 */
public class MyPool {
    /**
     * 连接池连接个数
     */
    private int poolSize;
    /**
     *
     */
    private Connection[] connections;

    /**
     * 连接状态数组
     */
    private AtomicIntegerArray states;

    public MyPool(int poolSize, String url, String user, String password) {
        this.poolSize = poolSize;
        this.connections = new Connection[poolSize];
        this.states = new AtomicIntegerArray(new int[poolSize]);
        try {
            Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");

            for (int i = 0; i < this.connections.length; i++) {
                connections[i] = DriverManager.getConnection(url, user, password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return
     */
    public Connection getConnection() {
        while (true) {
            for (int i = 0; i < poolSize; i++) {
                if (states.get(i) == 0) {
                    // CAS 设置繁忙状态
                    if (states.compareAndSet(i, 0, 1)) {
                        return connections[i];
                    }
                }
            }
            // 如果没有空闲连接，当前线程进入等待
            // 不然CPU 空转浪费资源
            synchronized (this) {
                try {
                    System.out.println("wait...");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 释放连接
     *
     * @param connection
     * @return
     */
    public boolean releaseConnection(Connection connection) {
        for (int i = 0; i < poolSize; i++) {
            // 在连接池中的连接
            if (connections[i] == connection) {
                states.set(i, 0);
                // 唤醒等待的线程
                synchronized (this) {
                    this.notifyAll();
                }
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyPool myPool = new MyPool(10, "URL", "hfm", "tiger2018");

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                Connection conn = myPool.getConnection();
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myPool.releaseConnection(conn);
            }).start();
        }
    }
}
