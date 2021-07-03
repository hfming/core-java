package com.hfm.junit;

import org.junit.*;

/**
 * @author hfm
 * @version 1.01 2020-04-14 18:47
 * @date 2020/4/14
 */
public class JunitTest {
    @Before // 测试方法之前运行
    public void test1() {
        System.out.println("@Before");
    }

    @BeforeClass // 类加载前运行
    public static void test2() {
        System.out.println("@BeforeClass");
    }

    @Test // 测试方法
    public void test3() {
        System.out.println("@Test");
    }

    @After // 测试方法之后运行
    public void test4() {
        System.out.println("@After");
    }

    @AfterClass // 所有方法完成之后运行
    public static void test5() {
        System.out.println("@AfterClass");
    }
}
