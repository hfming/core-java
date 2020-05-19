package com.hfm.originalproject.redpacket2.impl;

import com.hfm.originalproject.redpacket2.OpenMode;

import java.util.ArrayList;

/**
 * @author hfm
 * @version 1.01 2020-04-02 17:24
 * @date 2020/4/2
 */
public class Common implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int count) {
        // 创建保存各个红包金额的集合
        ArrayList<Integer> list = new ArrayList<>();
        // 定义循环次数,总个数‐1次
        int time = count - 1;
        // 一次计算,生成平均金额
        int money = totalMoney / count;
        // 循环分配
        for (int i = 0; i < time; i++) {
            // 添加到集合中
            list.add(money);
            // 总金额扣除已分配金额
            totalMoney -= money;
        }
        // 剩余的金额,为最后一个红包
        list.add(totalMoney);
        System.out.println("普通红包金额:" + list);
        // 返回集合
        return list;
    }
}
