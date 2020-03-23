package com.hfm.baisc.java;

public class Wrench {
    public static void main(String[] args) {
        Wrench w = new Wrench();
        Wrench w2 = new Wrench();
        w2 = go(w, w2);
        System.out.print(w2 == w);
    }

    static Wrench go(Wrench wrl, Wrench wr2) {
        Wrench wr3 = wrl;
        wrl = wr2;
        wr2 = wr3;
        return wr3;
    }
}
