package com.hfm.valuepass;

import java.util.Arrays;

/**
 * @author hfm
 * @version 1.01 2020-04-13 17:30
 * @date 2020/4/13
 */
public class StringExchangeValue2 {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};
    String[] strs = new String[]{"ggg", "sds"};
    int[] arr = {1, 2, 3, 4, 5, 6, 7};

    public static void main(String[] args) {
        StringExchangeValue2 s2 = new StringExchangeValue2();
        s2.change(s2.str, s2.ch, s2.strs, s2.arr);
        // good 交换失败
        System.out.println(s2.str);
        // best 交换成功
        System.out.println(s2.ch); // char 数组会直接打印输出内容
        // {"aaa","sds"} 交换成功
        System.out.println(Arrays.toString(s2.strs));

        // 交换失败
        System.out.println(Arrays.toString(s2.arr));
    }

    public void change(String str, char[] ch, String[] strs, int[] arr) {
        // String 为引用数据类型，传递内存地址，str 为形参，形参发生改变，不会对实参进行修改
        // 除非修改的是内存地址中的数据，而不是内存地址本身
        str = "New String";
        // arr 为数组是引用数据类型，传递内存地址，arr 为形参，形参发生改变，不会对实参进行修改
        arr = new int[]{2, 3, 4, 5, 6, 7};
        ch[0] = 'b';
        strs[0] = "aaa";
    }
}
