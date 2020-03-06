package com.hfming.array;

        import java.util.Arrays;

/**
 * Arrays.fill( ) 方法测试
 *
 * @author hfm
 * @version 1.01 2019-10-02
 */
public class AssaysFillTest {
    public static void main(String[] args) {
        String str[] = {"s2", "s4", "s1", "s3", null};
        System.out.println(Arrays.toString(str));

        // 填充数组
        Arrays.fill(str, "s5");
        System.out.println(Arrays.toString(str));

        // 按照指定位置填充数组
        Arrays.fill(str, 1, 4, "s0");
        System.out.println(Arrays.toString(str));
    }
}
