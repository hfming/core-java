package com.hfm.udp;

public class ChatTest {
	public static void main(String[] args) {
		ChatSend chatSend = new ChatSend();
		ChatAccept accept = new ChatAccept();
		Thread thread1 = new Thread(chatSend,"发送端");
		Thread thread2 = new Thread(accept,"接收端");
		thread2.start();
		thread1.start();
		//当接收端丢失数据是并不会把所有的数据丢失，而是将部分数据储存在CPU的寄存器中(1Kb左右)
	}
}
