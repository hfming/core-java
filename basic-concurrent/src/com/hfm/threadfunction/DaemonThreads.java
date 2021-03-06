package com.hfm.threadfunction;

/**
 * 守护线程/后台线程
 *
 * @author hfm
 */
public class DaemonThreads extends Thread {
    public DaemonThreads() {
        super();
    }

    public DaemonThreads(String name) {
        super(name);
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
        DaemonThreads daemonThread = new DaemonThreads("守护线程");
        // 设置为守护线程
        daemonThread.setDaemon(true);
        daemonThread.start();
        for (int i = 0; i < 100; i++) {
        	Thread.sleep(100);
        	// 打印当前线程
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
