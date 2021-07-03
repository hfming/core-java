package com.hfm.threadfunction;

/**
 * 加入的线程
 */
public class SonThread extends Thread {
	@Override
	public void run() {
		try {
			System.out.println("儿子下楼梯");
			Thread.sleep(1000);
			System.out.println("儿子一直往前走...");
			System.out.println("儿子买到了酱油...");
			System.out.println("儿子跑回来...");
			Thread.sleep(1000);
			System.out.println("儿子把酱油给老妈..");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
