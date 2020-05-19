package com.hfm.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP发送端
 * @author hfm
 */
public class UDPSend {

	public static void main(String[] args) throws IOException {
		System.out.println("开始发送数据！");
		// 1.创建UDP通信协议Socket对象
		DatagramSocket datagramSocket = new DatagramSocket();
		// 2.创建数据包类
		// buf:传输数据的字节数组
		// length：字节数组的长度
		// address:发送的IP地址
		// port：发送的端口号
		byte[] buf = "UDP发送测试".getBytes();
		int length = buf.length;
		InetAddress address = InetAddress.getLocalHost();
		int port = 9090;
		DatagramPacket datagramPacket = new DatagramPacket(buf, length, address, port);
		// 3.UDP服务类发送数据
		datagramSocket.send(datagramPacket);
		// 4.关闭通道
		datagramSocket.close();
		System.out.println("发送成功！");
	}
}
