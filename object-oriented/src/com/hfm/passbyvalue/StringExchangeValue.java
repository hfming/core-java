package com.hfm.passbyvalue;

/**
 * 值传递
 *
 * @author hfm
 */
public class StringExchangeValue {
    public static void main(String[] args) {
        String str1 = "1";
        String str2 = "2";
        System.out.println("str1=" + str1 + " str2=" + str2);

        exchangeStringValue(str1, str2);
        // 交换失败
        System.out.println("str1=" + str1 + " str2=" + str2);

        String temp = str1;
        str1 = str2;
        str2 = str1;
        // 交换成功
        System.out.println("str1=" + str1 + " str2=" + str2);
    }

    /**
     * 交换String类型变量的值，交换失败，传递的是String变量储存的字符串常量池中的地址，不会进行交换,形参引用的内存空间发生改变，实参不变
     *
     * @param str1
     * @param str2
     */
    public static void exchangeStringValue(String str1, String str2) {
        String temp = str1;
        str1 = str2;
        str2 = temp;
    }
}
