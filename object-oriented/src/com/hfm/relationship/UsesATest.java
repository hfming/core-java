package com.hfm.relationship;

/**
 * 类与类之间的关系
 * 依赖 Demo
 * 如果一个类的方法操纵另一个类的对象，我们就说一个类依赖于另一个类。
 *
 * @author hfm
 * @version 1.01 2020-03-26 18:02
 * @date 2020/3/26
 */
public class UsesATest {
    public static void main(String[] args) {
        People people = new People();
        Knife knife = new Knife();
        people.cut(knife);
    }
}

/**
 * 实体类 人
 */
class People {
    /**
     * People 类的方法中含有 knife 类
     */
    public void cut(Knife knife) {
        knife.cut();
    }
}

/**
 * 实体类 刀
 */
class Knife {
    public void cut() {
        System.out.println("切水果");
    }
}

