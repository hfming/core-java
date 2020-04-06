package com.hfm.knowledge;

/**
 * @author hfm
 * @version 1.01 2020-04-03 17:26
 * @date 2020/4/3
 */
public class AccessModifierChild extends AccessModifierPerson {
    private int c1 = 21;
    public int c2 = 22;

    private void cm1() {
        System.out.println("in cm1() c1=" + c1);
    }

    public void cm2() {
        System.out.println("in cm2() c2=" + c2);
    }

    public static void main(String[] args) {
        int i;
        AccessModifierPerson p = new AccessModifierPerson();
        // i = p.f3; i = p.f4;
        i = p.f2;
        // p.fm3(); p.fm4();
        p.fm2();
        AccessModifierChild c = new AccessModifierChild();
        // i = c.f3; i = c.f4;
        i = c.f2;
        // i = c.c2;
        i = c.c1;
        // c.cm2(); c.fm2(); c.fm3(); c.fm4()
        c.cm1();
    }
}
