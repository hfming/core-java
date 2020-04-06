package com.hfm.initialize;

/**
 * @author hfm
 * @version 1.01 2020-04-04 16:14
 * @date 2020/4/4
 */
public class LeafTest2 {
    public static void main(String[] args) { // 由父及子 静态先行
        System.out.println("77777777777");
        System.out.println("************************");
        new Son();
        System.out.println("************************");

        new Son();
        System.out.println("************************");
        new Father();
    }
}

class Father {
    static {
        System.out.println("11111111111");
    }

    {
        System.out.println("22222222222");
    }

    public Father() {
        System.out.println("33333333333");
    }
}

class Son extends Father {
    static {
        System.out.println("44444444444");
    }

    {
        System.out.println("55555555555");
    }

    public Son() {
        System.out.println("66666666666");
    }
}
