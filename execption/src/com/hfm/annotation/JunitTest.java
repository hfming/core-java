package com.hfm.annotation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

/**
 * @author hfm
 * @version 1.01 2020-04-14 18:47
 * @date 2020/4/14
 */
public class JunitTest {
    @Before
    public void test1() {
        System.out.println("@Before");
    }

    @BeforeClass
    public void test2() {
        System.out.println("@BeforeClass");
    }

    @Test
    public void test3() {
        System.out.println("@Test");
    }

    @After
    public void test4() {
        System.out.println("@After");
    }

    @AfterClass
    public void test5() {
        System.out.println("@AfterClass");
    }
}
