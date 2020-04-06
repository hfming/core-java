package com.hfm.inheritance;

import java.util.ArrayList;

public class MainRedPacket {

    public static void main(String[] args) {
        Manager2 manager2 = new Manager2("群主", 100);

        Member2 one = new Member2("成员A", 0);
        Member2 two = new Member2("成员B", 0);
        Member2 three = new Member2("成员C", 0);

        manager2.show(); // 100
        one.show(); // 0
        two.show(); // 0
        three.show(); // 0
        System.out.println("===============");

        // 群主总共发20块钱，分成3个红包
        ArrayList<Integer> redList = manager2.send(20, 3);
        // 三个普通成员收红包
        one.receive(redList);
        two.receive(redList);
        three.receive(redList);

        manager2.show(); // 100-20=80
        // 6、6、8，随机分给三个人
        one.show();
        two.show();
        three.show();
    }
}
