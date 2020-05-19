package com.hfm.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP接收端，先调用接收端的程序，监听发送端
 * 多次运行会报错(端口绑定异常)
 * @author hfm
 */
public class UDPAccept {
	/**
	 *  IP地址：广播IP地址，三个网络号与一个主机号，主机号为255的为广播号，同一网段的可以接收消息。
	 *  群聊使用过广播IP地址
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("开始接收数据！");
		// 1.建立服务并且监听服务
		DatagramSocket datagramSocket = new DatagramSocket(9090);
		// 2.准备一个空的数据包
		byte[] buf = new byte[1024];
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
		// 3.接收数据，阻塞型方法，如果没有数据会一直等待
		datagramSocket.receive(datagramPacket);
		// 4.关闭UDP服务
		datagramSocket.close();
		System.out.println(new String(buf,0,datagramPacket.getLength()));
		//datagramPacket.getLength() ：数据包接收到的字节个数
		System.out.println("接收数据成功！");
	}
}
