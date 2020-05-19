package com.hfm.ip;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * 网络编程
 *
 * @author hfm
 */
public class InetAddressTest {

    public static void main(String[] args) throws IOException {
        // 获取本机IP对象
        InetAddress inetAddress = InetAddress.getLocalHost();
        // 格式：主机名/IP HFM/192.168.247.225
        System.out.println(inetAddress.toString());

        // 获取本机IP地址
        String hostAddress = inetAddress.getHostAddress();
        System.out.println(hostAddress);

        // 获取本机名称 // 返回IP地址字符串的表示形式。
        String hostName = inetAddress.getHostName();
        System.out.println(hostName);


        // 根据给定的主机名 获取主机 IP 地址
        InetAddress address = InetAddress.getByName("HFM");

        // 主机名不正确时，会抛出错误
        try {
            System.out.println(InetAddress.getByName("hf"));
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        }

        // 获取 IP 地址
        System.out.println("IP ： " + address.getHostAddress());
        // 获取主机名
        System.out.println("计算机的名字：" + address.getHostName());

        // 返回此对象的原始 IP 地址
        System.out.println(address.getAddress());
        // 获取此 IP 地址的完全限定域名。
        System.out.println(address.getCanonicalHostName());
        // 用于检查 Inet 地址是否为通配符地址的实用程序例程。
        System.out.println(address.isAnyLocalAddress());
        // 实用程序例程，用于检查 Inet 地址是否为链接本地地址
        System.out.println(address.isLinkLocalAddress());
        // 用于检查 Inet 地址是否为回环地址的实用程序例程。
        System.out.println(address.isLoopbackAddress());
        // 用于检查 Inet 地址是否为站点本地地址的实用程序例程。
        System.out.println(address.isSiteLocalAddress());

        // 通过域名 获取集群(返回数组)的IP地址 获取IP 集群
        InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
        System.out.println(Arrays.asList(addresses));
        System.out.println(Arrays.toString(InetAddress.getAllByName("www.baidu.com")));
        // 获取集群(返回数组)的IP地址
        System.out.println(Arrays.toString(InetAddress.getAllByName("www.weibo.com")));
        // 获取集群(返回数组)的IP地址
        System.out.println(Arrays.toString(InetAddress.getAllByName("www.taobao.com")));
        // 获取集群(返回数组)的IP地址
        System.out.println(Arrays.toString(InetAddress.getAllByName("www.bilibili.com")));

        // 建立udp的服务
        DatagramSocket socket = new DatagramSocket();
        // 准备数据，把数据封装到数据包中
        String data = getData("feiQ 你好！");
        DatagramPacket packet = new DatagramPacket(data.getBytes(), data.getBytes().length, InetAddress.getByName("127.1.1.1"), 21);
        // 发送数据
        socket.send(packet);
        // 关闭资源
        socket.close();
    }

    /**
     * 把数据拼接成指定格式的数据
     */
    public static String getData(String content) {
        StringBuilder sb = new StringBuilder();
        sb.append("1.0:");
        sb.append(System.currentTimeMillis() + ":");
        sb.append("习大大:");
        sb.append("127.1.1.1:");
        sb.append("32:");
        sb.append(content);
        return sb.toString();
    }
}
