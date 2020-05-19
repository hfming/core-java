package com.hfm.runnable;

/**
 * 自定义线程
 *
 * @author hfm
 */
public class BankRunnable implements Runnable {
    private static int allMoney = 5000;
    private String name;

    /**
     * 构造函数
     */
    public BankRunnable() {
        super();
    }

    /**
     * 构造函数
     */
    public BankRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            // 同步锁，解决线程安全问题
            synchronized (this.getClass()) {
                if (allMoney > 0) {
                    allMoney -= 100;
                    System.out.println(this.name + "取了100元，还剩余" + allMoney);
                    Thread thread = new Thread();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 静态的同步函数 -->当前方法所属的类的class文件对象。
     */
    public synchronized static void getMoney() {
        while (true) {
            if (allMoney > 0) {
                System.out.println(Thread.currentThread().getName() + "取走了100块，还剩余" + (allMoney - 100) + "块");
                allMoney -= 100;
            } else {
                System.out.println("取光了...");
                break;
            }
        }
    }

    public static void main(String[] args) {
        BankRunnable man = new BankRunnable("man");
        BankRunnable woman = new BankRunnable("woman");
        Thread thread1 = new Thread(man, "man");
        Thread thread2 = new Thread(woman, "woman");
        thread1.start();
        thread2.start();
    }
}
