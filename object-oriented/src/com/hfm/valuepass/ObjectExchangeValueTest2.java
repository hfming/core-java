package com.hfm.valuepass;

/**
 * @author hfm
 * @version 1.01 2020-04-03 12:26
 * @date 2020/4/3
 */
public class ObjectExchangeValueTest2 {
    public static void main(String args[]) {
        ObjectExchangeValueTest2 test = new ObjectExchangeValueTest2();
        test.first();
    }

    public void first() {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i);
    }

    public void second(Value v, int i) {
        i = 0;
        v.i = 20;
        Value val = new Value();
        v = val;
        System.out.println(v.i + " " + i);
    }
}

class Value {
    int i = 15;
}