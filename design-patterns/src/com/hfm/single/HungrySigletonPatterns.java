package com.hfm.single;

/**
 * 饿汉单例设计模式
 *
 * @author hfm
 * @version 1.01 2019-10-16
 */
public class HungrySigletonPatterns {
    /**
     * 2.创建本类私有的静态对象
     */
    private static HungrySigletonPatterns hungryHanSigletonPatterns = new HungrySigletonPatterns();

    /**
     * 1.私有化本类构造函数
     */
    private HungrySigletonPatterns() {
    }

    /**
     * 3.提供公共的静态方法获取该对象
     */
    public static HungrySigletonPatterns getHungryHanSigletonPatterns() {
        return hungryHanSigletonPatterns;
    }
}
