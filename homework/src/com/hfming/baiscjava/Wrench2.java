package com.hfming.baiscjava;

public class Wrench2 {
    int size;

    public static void main(String[] args) {
        Wrench2 w = new Wrench2();
        w.size = 11;
        Wrench2 w2 = go(w, w.size);
        System.out.print(w2.size);
    }

    public static Wrench2 go(Wrench2 wr,int s) {
        s = 12;
        return wr;
    }
}
