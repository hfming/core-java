package com.hfm.threadfunction;

import com.hfm.comunication.producerconsumer.Producer;
import com.hfm.comunication.producerconsumer.Product;

/**
 * 线程中断
 */
public class InterruptTest {
	public static void main(String[] args) {
		Product p = new Product();
		// 创建线程对象
		Producer producer = new Producer(p);
		producer.start();
		// 强制清除一个线程的wait、 sleep状态。可以指定清除那个线程。
		producer.interrupt();
	}
}
