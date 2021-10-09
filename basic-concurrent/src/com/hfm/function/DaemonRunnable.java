package com.hfm.function;

/**
 * 守护线程/后台线程
 *
 * @author hfm
 */
public class DaemonRunnable implements Runnable {
    private String name;

    public String getName() {
        return name;
    }

    public DaemonRunnable() {
        super();
    }

    public DaemonRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println(this.getName() + "已经下载了：" + i + "%");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("下载完毕，正在安装更新包！！！");
    }

    public static void main(String[] args) throws InterruptedException {
        // 所有线程默认为 非守护线程
        DaemonRunnable daemonThread = new DaemonRunnable("守护线程");
        // 将 Runnable 传入 Thread 构造函数中
        Thread thread = new Thread(daemonThread, "守护线程");
        // 设置为守护线程
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 100; i++) {
            Thread.sleep(100);
            // 打印当前线程
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
