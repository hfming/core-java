package com.hfm.junit;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-11 12:19
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 1. 定义测试类
 * 测试类名：被测试的类名Test CalculatorTest
 * 包名：xxx.xxx.xx.test cn.itcast.test
 */
public class CalculatorTest {
    /**
     * 2.定义测试方法
     * 方法名：test测试的方法名		testAdd()
     * 返回值：void
     * 参数列表：空参
     * <p>
     * 3.给方法加 @Test
     * <p>
     * 4.导入junit依赖环境
     */
    @Test
    public void testAdd() {
        int a = 89;
        int b = 72;
        int sum = add(a, b);

        // 可以使用断言来判结果是否与预期相同
        Assert.assertEquals(161, sum);
    }

    /**
     * 普通方法
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int... b) {
        int sum = 0;
        sum += a;
        for (int i : b) {
            sum += i;
        }
        return sum;
    }

    @Before
    public void before() {
        System.out.println("准备测试阶段！");
    }

    @Test
    public void testing() {
        System.out.println("正在测试阶段！");
    }

    @After
    public void after() {
        System.out.println("测试结束！");
    }
}
