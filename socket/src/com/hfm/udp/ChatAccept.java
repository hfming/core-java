package com.hfm.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端
 * @author hfm
 */
public class ChatAccept implements Runnable {
	private static DatagramSocket datagramSocket = null;
	@Override
	public void run() {
		while(true){
			System.out.println("开始接收数据！");
			// 1.建立服务并且监听服务
			try {
				datagramSocket = new DatagramSocket(9090);
			// 2.准备一个空的数据包
			byte[] buf = new byte[1024];
			DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
			// 3.接收数据，阻塞型方法，如果没有数据会一直等待
			datagramSocket.receive(datagramPacket);
			// 4.关闭UDP服务
			System.out.println(new String(buf,0,datagramPacket.getLength()));
			// datagramPacket.getLength() ：数据包接收到的字节个数
			System.out.println("接收数据成功！");
			} catch (SocketException e) {
				throw new RuntimeException(e);
			} catch (IOException e){
				throw new RuntimeException(e);
			} finally{
				datagramSocket.close();	
			}
		}
	}
}
