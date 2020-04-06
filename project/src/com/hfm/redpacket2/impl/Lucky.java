package com.hfm.redpacket2.impl;

import com.hfm.redpacket2.OpenMode;

import java.util.ArrayList;
import java.util.Random;

/**
 * 本质上，手气红包就是把总金额 totalMoney 随机分成指定的 count 份，所以必须规定每一份金额的取值范围。如果范围太小，可能导致后分配红包金额特别大。反之范围太大，可能导致后分配红包金额为0，不够分。可见，取值范围的定义规则，是手气红包的关键所在。
 * 我们规定：每一份随机金额范围（除最后一份），最小值为1，最大值为当前剩余平均金额的2倍 ，单位为"分"。
 * 计算公式：当前剩余平均金额 = 剩余总金额 / 剩余红包个数
 * 举例：总额为50元，发5个红包
 * 剩余平均金额（取整数） 红包范围 随机金额（假设）
 * 第一个红包 50 / 5 = 10 0.01~20 5
 * 第二个红包 45 / 4 = 11 0.01~22 20
 * 第三个红包 25 / 3. = 8 0.01~16 10
 * 第四个红包 15 / 2 = 7 0.01~14 12
 * 第五个红包（最后一个） 无需计算 剩余金额 3
 * @author hfm
 * @version 1.01 2020-04-02 17:26
 * @date 2020/4/2
 */
public class Lucky implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int count) {
        // 创建保存各个红包金额的集合
        ArrayList<Integer> list = new ArrayList<>();
        // 定义循环次数,总个数‐1次
        int time = count - 1;
        // 创建随机数对象
        Random random = new Random();
        // 循环分配
        for (int i = 0; i < time; i++) {
            /*
             * 每次重新计算,生成随机金额
             * 随机范围: totalMoney / count * 2,totalMoney不断的减少,
             * count也不断的减少,所以这是一个可变化的范围.
             */
            int money = random.nextInt(totalMoney / count * 2) + 1;
            // 金额添加到集合
            list.add(money);
            // 总金额扣除已分配金额
            totalMoney -= money;
            // 红包个数‐1
            count--;
        }
        // 剩余的金额,为最后一个红包
        list.add(totalMoney);
        return list;
    }
}
