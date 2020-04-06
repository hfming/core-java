package com.hfm.knowledge;

/**
 * 访问权限修饰符
 *
 * @author hfm
 * @version 1.01 2020-04-03 17:24
 * @date 2020/4/3
 */
public class AccessModifierPerson {
    private int f1 = 1;
    int f2 = 2;
    protected int f3 = 3;
    public int f4 = 4;

    private void fm1() {
        System.out.println("in fm1() f1=" + f1);
    }

    void fm2() {
        System.out.println("in fm2() f2=" + f2);
    }

    protected void fm3() {
        System.out.println("in fm3() f3=" + f3);
    }

    public void fm4() {
        System.out.println("in fm4() f4=" + f4);
    }
}
