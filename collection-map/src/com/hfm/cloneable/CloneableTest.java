package com.hfm.cloneable;

import com.hfm.entity.StudentCloneable;
import com.hfm.entity.StudentNoCloneable;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-27 16:42
 */
public class CloneableTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 创建未实现 cloneable 接口的 StudentNoCloneable类对象
        StudentNoCloneable student1 = new StudentNoCloneable(1, "fef", 34);
        // 没有 clone 方法不能进行 clone
        //student1

        // 创建实现 cloneable接口的 StudetnCloneable 接口
        StudentCloneable student2 = new StudentCloneable(2, "fe", 89);
        // 调用 clone 方法实现对 Student2 的 clone
        Object clone = student2.clone();

        System.out.println(clone);
    }
}
