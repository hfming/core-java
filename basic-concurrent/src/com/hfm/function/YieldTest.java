package com.hfm.function;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 线程让步
 * @date 2020-05-07 17:28
 */
public class YieldTest {
    public static void main(String[] args) {
        // 没有 yield 的先执行完成
//        yieldTest1();
        // 没有 yield 的先执行完成
//        yieldTest2();
        // 优先级为10 的先执行完成
        yieldTest3();
    }

    /**
     * 没有相同优先级的线程
     */
    private static void yieldTest1() {
        EvenNumber2 thread1 = new EvenNumber2("优先级1-11");
        // 设置优先级为1
        thread1.setPriority(1);
        // 默认优先级为5
        OddNumber2 thread2 = new OddNumber2("优先级5-12");

        thread2.start();
        thread1.start();
    }

    /**
     * 相同优先级的线程
     */
    private static void yieldTest2() {
        // 默认优先级为5
        EvenNumber2 thread1 = new EvenNumber2("优先级5-21");
        OddNumber2 thread2 = new OddNumber2("优先级5-22");
        thread1.start();
        thread2.start();
    }

    /**
     * 有更高优先级的线程
     */
    private static void yieldTest3() {
        EvenNumber2 thread1 = new EvenNumber2("优先级10-31");
        // 设置优先级为10
        thread1.setPriority(10);
        // 默认优先级为5
        OddNumber2 thread2 = new OddNumber2("优先级1-32");

        thread1.start();
        thread2.start();
    }
}

/**
 * 奇数
 */
class OddNumber2 extends Thread {
    public OddNumber2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            if (i % 2 != 0) {
                System.out.println(this.getName() + ":" + i);
            }
            if (i % 2 == 0) {
                // yield()，线程让步，暂停当前正在执行的线程，把执行机会让给优先级相同或更高的线程。若队列中没有同优先级的线程，忽略此方法。
                yield();
            }
        }
    }
}

/**
 * 偶数
 */
class EvenNumber2 extends Thread {
    public EvenNumber2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            if (i % 2 == 0) {
                System.out.println(this.getName() + ":" + i);
            }
        }
    }
}