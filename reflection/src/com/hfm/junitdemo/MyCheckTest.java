package com.hfm.junitdemo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-25 21:48
 * @Description 自定义测试框架
 * @date 2021/6/25
 */
public class MyCheckTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, IOException {
        // 当主方法执行后，会自动自行被检测的所有方法（加了Check注解的方法），判断方法是否有异常，记录到文件中中
        // 获取字节码对象
        Class<MyFunction> myFunctionClass = MyFunction.class;

        MyFunction myFunction = myFunctionClass.newInstance();
        // 传入的参数
        int a = 10, b = 0;
        int count = 0;

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("reflection\\bug.txt"));

        // 获取所有方法
        Method[] declaredMethods = myFunctionClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            declaredMethod.setAccessible(true);

            // 判断方法上是否有 check 注解

            // 如果有就执行方法
            if (declaredMethod.isAnnotationPresent(MyCheckAnnotation.class)) {
                try {
                    declaredMethod.invoke(myFunction, a, b);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    // 记录到文件中
                    count++;
                    bufferedWriter.write(declaredMethod.getName() + "出现异常");
                    bufferedWriter.newLine();
                    bufferedWriter.write("异常的名称为：" + e.getCause().getClass().getSimpleName());
                    bufferedWriter.newLine();
                    bufferedWriter.write("异常的原因为：" + e.getCause().getMessage());
                    bufferedWriter.newLine();
                    bufferedWriter.write("==================");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                }
            }
        }
        bufferedWriter.write("本次异常出现次数为：" + count);
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
