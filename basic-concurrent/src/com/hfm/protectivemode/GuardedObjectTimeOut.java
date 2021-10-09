package com.hfm.protectivemode;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-14 11:46
 * @Description
 * @date 2021/9/14
 */
public class GuardedObjectTimeOut {
    // 结果
    private Object response;

    // 获取结果
    public Object get(Long timeout) {
        synchronized (this) {
            // 起始时间
            long l = System.currentTimeMillis();

            // 没有结果
            while (response == null) {
                // 还需要等待多长时间(总共需要的时间 - 已经等待的时间)
                long waittime = timeout - (System.currentTimeMillis() - l);
                // 如果经历的时间大于等待时间直接退出循环，然后返回结果(不管结果是否已经生成)
                // 还需要等待是时间小于 0
                if (waittime < 0) {
                    break;
                }
                try {
                    this.wait(waittime);
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