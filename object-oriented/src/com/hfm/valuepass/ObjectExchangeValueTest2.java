package com.hfm.valuepass;

/**
 * 值传递练习
 *
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
        // 传递对象地址及基本数据，交换失败
        second(v, i);
        // 20 5
        System.out.println(v.i + " " + i);
    }

    public void second(Value v, int i) {
        i = 0;
        v.i = 20;
        Value val = new Value();
        // 形参发生改变，实参没有变化
        v = val;
        // 15 0
        System.out.println(v.i + " " + i);
    }
}

class Value {
    int i = 15;
}