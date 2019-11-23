package com.hfming.singlecase;

/**
 * 懒汉单例设计模式
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class LazySigletonPattens {
    // 1.私有化本类构造函数
    private LazySigletonPattens() {

    }

    // 2.创建本类私有的静态变量
	// 单例对象
    // volatile关键字
    private volatile static LazySigletonPattens lazySigletonPattens = null;

    // 3.创建公共静态方法获取本类对象,获取之前判断是否为空，如果为空需要初始化对象
    // 静态工厂方法
    public static LazySigletonPattens getInstance() {
		// 双重检测机制
        if (lazySigletonPattens == null) {
            // 同步锁
            synchronized (LazySigletonPattens.class) {
				// 双重检测机制
                if (lazySigletonPattens == null) {
                    lazySigletonPattens = new LazySigletonPattens();
                }
            }
        }
        return lazySigletonPattens;
    }
}
