package com.hfm.nolockconcurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-17 11:40
 * @Description
 * @date 2021/9/17
 */
public class UnsafeTest {
    static Unsafe unsafe;

    static {
        try {
            // 反射反射获取 Unsafe 对象
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new Error(e);
        }
    }

    static Unsafe getUnsafe() {
        return unsafe;
    }

    static class Student {
        volatile int id;
        volatile String name;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Student{");
            sb.append("id=").append(id);
            sb.append(", name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) throws NoSuchFieldException {
        Field id = Student.class.getDeclaredField("id");
        Field name = Student.class.getDeclaredField("name");

        // 获得成员变量的偏移量
        long idOffset = unsafe.objectFieldOffset(id);
        long nameOffset = unsafe.objectFieldOffset(name);

        Student student = new Student();
        // 使用 cas 方法替换成员变量的值
        // 返回 true ,修改成功
        System.out.println(unsafe.compareAndSwapInt(student, idOffset, 0, 20));
//        unsafe.compareAndSwapLong()

        // 返回 true ,修改成功
        System.out.println(unsafe.compareAndSwapObject(student, nameOffset, null, "张三"));
        System.out.println(student);
    }
}
