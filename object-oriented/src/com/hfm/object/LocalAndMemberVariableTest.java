package com.hfm.object;

/**
 * 局部变量与成员变量 Demo
 *
 * @author hfm
 * @version 1.01 2020-03-26 20:15
 * @date 2020/3/26
 */
public class LocalAndMemberVariableTest {
    public static void main(String[] args) {
        LocalAndMemberVariable localAndMemberVariable = new LocalAndMemberVariable();
        // 成员变量与初始值，整形初始值为1，浮点型为0.0，Boolean为false,char 型为'\u0000',object 型初始值为 null
        System.out.println(localAndMemberVariable.getVariable());
        // 公共方法可以调用
        localAndMemberVariable.print();
        // 私有方法只能本类使用
        //localAndMemberVariable.sleep();
    }
}

class LocalAndMemberVariable {
    /**
     * 成员变量
     * 定义在类之内，方法之外
     * 成员变量是用于描述一类事物公共属性
     */
    private String variable;

    public String getVariable() {
        return variable;
    }

    public void setVariable1(String variable) {
        this.variable = variable;
    }

    /**
     * 公共成员方法
     */
    public void print() {
        // 局部变量
        // 定义在类之内，方法之内
        // 局部变量是用于提供一个变量给方法内部去使用的。
        String variable;
        // 局部变量需要初始化才能使用
        //System.out.println(variable);
    }

    /**
     * 私有方法
     */
    private void sleep() {
        System.out.println("I Just want sleep!");
    }
}