package com.hfm.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端
 * @author hfm
 */
public class ChatAccept implements Runnable {
	@Override
	public void run() {
		while(true){
			System.out.println("开始接收数据！");
			byte[] buf = new byte[1024];
			// 1.建立服务并且监听服务
			try (
					DatagramSocket datagramSocket= new DatagramSocket(9090)
					){
			// 2.准备一个空的数据包
			DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);

			// 3.接收数据，阻塞型方法，如果没有数据会一直等待
			datagramSocket.receive(datagramPacket);

			// 4.关闭UDP服务
			System.out.println(new String(buf,0,datagramPacket.getLength()));
			// datagramPacket.getLength() ：数据包接收到的字节个数
			System.out.println("接收数据成功！");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
