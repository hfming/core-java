package com.hfming.encapsulation;

/**
 * 封装类的测试
 * @author hfm
 */
public class EncapsulationStudentTest {
    public static void main(String[] args) {
        // 创建PackaingStudent对象
        EncapsulationStudent packaingStudent = new EncapsulationStudent();

        /// 因为封装后不能直接访问对象的成员变量
        //packaingStudent.name =  "hfm";

        // 通过公共的方法访问对象的属性
        packaingStudent.setName("hfm");
        packaingStudent.setAge(25);

        System.out.println(packaingStudent.getName());
        System.out.println(packaingStudent.getAge());
    }
}
