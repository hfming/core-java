package com.hfm.object;

import java.util.Arrays;

/**
 * System类测试
 *
 * @author hfm
 * @version 1.01 2020-03-25
 */
public class SystemTest {

    public static void main(String[] args) {
        // 获取当前系统时间
        System.out.println(System.currentTimeMillis());
        // 获取环境变量信息
        System.out.println(System.getenv("JAVA_HOME"));

        System.out.println(System.getProperties());
        System.out.println(System.getProperty("os.name"));
        /**
         * 判断操作系统
         */
        String osName = System.getProperty("os.name");
        if ("Windows 7".equals(osName)) {
            System.out.println("软件安装中...");
        } else {
            System.out.println("赶快换系统吧，我软件不兼用你系统!!");
        }
        // 源数组
        int[] srcArr = {10, 9, 4, 19};
        // 目标数组
        int[] destArr = new int[4];
        System.arraycopy(srcArr, 1, destArr, 2, 2);
        System.out.println("目标数组的元素：" + Arrays.toString(destArr));
        // 建议jvm尽快的启动垃圾回收器回收垃圾。
        System.gc();
        System.exit(0);
    }
}
