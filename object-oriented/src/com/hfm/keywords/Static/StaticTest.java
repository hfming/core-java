package com.hfm.keywords.Static;

/**
 * static 测试
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class StaticTest {
    public static void main(String[] args) {
        Father father = new Child();
        Father.print();
        Child.print();

        Count count1 = new Count();
        Count count2 = new Count();
        Count count3 = new Count();
        System.out.println(Count.num);

        People people1 = new People();
        People people2 = new People();
        People people3 = new People();
        People people4 = new People();
        System.out.println(People.count);
    }
}
