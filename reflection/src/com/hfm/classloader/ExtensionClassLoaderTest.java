package com.hfm.classloader;

import java.io.File;
import java.util.StringTokenizer;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 扩展类加载器
 * @date 2020-05-13 9:08
 */
public class ExtensionClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader platformClassLoader = ClassLoader.getPlatformClassLoader();
        System.out.println(platformClassLoader);

        File[] extDirs = getExtDirs();
        for (File extDir : extDirs) {
            System.out.println(extDir);
        }
    }

    /**
     * ExtClassLoader类中获取路径的源代码
     */
    private static File[] getExtDirs() {
        // 加载<JAVA_HOME>/lib/ext目录中的类库
        String s = System.getProperty("java");
        File[] dirs;
        if (s != null) {
            StringTokenizer st = new StringTokenizer(s, File.pathSeparator);
            int count = st.countTokens();
            dirs = new File[count];
            for (int i = 0; i < count; i++) {
                dirs[i] = new File(st.nextToken());
            }
        } else {
            dirs = new File[0];
        }
        return dirs;
    }
}
