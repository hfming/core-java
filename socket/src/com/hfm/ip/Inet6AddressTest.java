package com.hfm.ip;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-10 2:46
 */
public class Inet6AddressTest {
    public static void main(String[] args) throws UnknownHostException {
        //  java.lang.ClassCastException 转化成 Inet6Address 失败
        // 只能输出 HFM/192.168.247.225 IP 4 格式
        InetAddress localHost = Inet6Address.getLocalHost();
        System.out.println(localHost);

        System.out.println(localHost.getAddress().getClass());
        // 通过 主机名获取 IP 地址
        InetAddress address = Inet6Address.getByName("HFM");

        // 通过网址获取IP 集群
        InetAddress[] hfms = Inet6Address.getAllByName("www.bilibili.com");
        System.out.println(Arrays.asList(hfms));

        // 获取主机名
        System.out.println(address.getHostName());
        // 获取 IP地址
        System.out.println(address.getHostAddress());
        // 获取 IP 对象
        System.out.println(address.getAddress());
        // 获取此 IP 地址的完全限定域名。
        System.out.println(address.getCanonicalHostName());
    }
}
