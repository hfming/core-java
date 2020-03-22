package com.hfm.operators;

/**
 * 逻辑运算符
 * 注意事项：
 * 1. 逻辑运算符只能用于boolean值。
 * 2. 与、或需要左右各自有一个boolean值，但是取反只要有唯一的一个boolean值即可。
 * 3. 与、或两种运算符，如果有多个条件，可以连续写。
 *
 * @author hfm
 * @version 1.1 2019-09-17
 */
public class LogicalOperator {
    public static void main(String[] args) {
        // & 与
        // true
        System.out.println(true & true);
        // false
        System.out.println(true & false);
        // false
        System.out.println(false & true);
        // false
        System.out.println(false & false);

        // | 或
        // true
        System.out.println(true | true);
        // true
        System.out.println(true | false);
        // true
        System.out.println(false | true);
        // false
        System.out.println(false | false);

        // ! 飞
        // false
        System.out.println(!true);
        // true
        System.out.println(!!true);

        // ^ 异或
        // false
        System.out.println(true ^ true);
        // true
        System.out.println(true ^ false);
        // true
        System.out.println(false ^ true);
        // false
        System.out.println(false ^ false);

        // && 短路与
        // true
        System.out.println(true && true);
        // false
        System.out.println(true && false);
        // false
        System.out.println(false && true);
        //false
        System.out.println(false && false);

        // || 短路或
        // true
        System.out.println(true || true);
        // true
        System.out.println(true || false);
        // true
        System.out.println(false || true);
        // false
        System.out.println(false || false);

        // 年龄
        int age = 17;
        // 工作经验
        int workAge = 3;
        System.out.println("条件满足吗？" + (age >= 18 && workAge++ >= 2));
        // 4
        System.out.println("工作经验：" + workAge);
    }
}
