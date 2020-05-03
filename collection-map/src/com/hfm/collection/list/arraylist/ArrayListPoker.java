package com.hfm.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 按照斗地主的规则，完成洗牌发牌的动作。具体规则：使用54张牌打乱顺序,三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。
 * @date 2020-04-23 18:20
 */
public class ArrayListPoker {
    public static void main(String[] args) {
        /**
         * 1.准备牌
         */
        String[] flower = {"♠", "♥", "♦", "♣"};
        String[] num = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String bigKing = "大" + "\uD83C\uDCCF";
        String smallKing = "小" + "\uD83C\uDCCF";

        /**
         *2.组牌
         */
        ArrayList<String> pork = new ArrayList<>();
        for (int i = 0; i < flower.length; i++) {
            for (int i1 = 0; i1 < num.length; i1++) {
                pork.add(flower[i] + num[i1]);
            }
        }
        pork.add(bigKing);
        pork.add(smallKing);
        //System.out.println(pork);

        /**
         * 3.洗牌
         */
        Collections.shuffle(pork);

        ArrayList<String> play1 = new ArrayList<>();
        ArrayList<String> play2 = new ArrayList<>();
        ArrayList<String> play3 = new ArrayList<>();
        ArrayList<String> remaining = new ArrayList<>();

        /**
         * 4.分牌
         */
        for (int i = 0; i < pork.size(); i++) {
            if (i < 51) {
                if (i % 3 == 0) {
                    play2.add(pork.get(i));
                } else if (i % 3 == 1) {
                    play3.add(pork.get(i));
                } else {
                    play1.add(pork.get(i));
                }
            } else {
                remaining.add(pork.get(i));
            }
        }
        /**
         * 5.打印输出
         */
        System.out.println(play1);
        System.out.println(play2);
        System.out.println(play3);
        System.out.println(remaining);
    }
}