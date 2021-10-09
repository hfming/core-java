package com.hfm.protectivemode;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-14 11:46
 * @Description
 * @date 2021/9/14
 */
public class GuardedObjectId {
    /**
     * 唯一 id
     */
    private int id;

    public int getId() {
        return id;
    }

    public GuardedObjectId(int id) {
        this.id = id;
    }

    // 结果
    private Object response;

    // 获取结果
    public Object get() {
        synchronized (this) {
            // 没有结果
            while (response == null) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
    }

    // 产生结果
    public void complete(Object response) {
        synchronized (this) {
            // 给结果成员变量赋值
            this.response = response;
            this.notifyAll();
        }
    }
}