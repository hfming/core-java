package com.hfm.baisc;

/**
 * @author hfm
 * @version 1.01 2020-04-01 20:37
 * @date 2020/4/1
 */
public class CompareNum {
    public static void main(String[] args) {
        //调用方法compare，传递两个整数
        //并接收方法计算后的结果，布尔值
        boolean bool = compare(3, 8);
        System.out.println(bool);
    }

    /**
     * 定义比较两个整数是否相同的方法
     * 返回值类型，比较的结果布尔类型
     * 参数：不确定参与比较的两个整数
     */
    public static boolean compare(int a, int b) {
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }
}
