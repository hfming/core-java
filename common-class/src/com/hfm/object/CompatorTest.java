package com.hfm.object;

import com.hfm.entity.Goods;

import java.util.Arrays;

/**
 * @author hfm
 * @version 1.01 2020-04-08 17:59
 * @date 2020/4/8
 */
public class CompatorTest {
    public static void main(String[] args) {
        Goods[] all = new Goods[4];
        all[0] = new Goods("War and Peace", 100);
        all[1] = new Goods("Childhood", 80);
        all[2] = new Goods("Scarlet and Black", 140);
        all[3] = new Goods("Notre Dame de Paris", 120);

//         使用自然顺序进行排序
        Arrays.sort(all);
        System.out.println(Arrays.toString(all));

        // 指定比较器进行排序
        Arrays.sort(all, (o1, o2) -> {
            if (o1.getPrice() > o2.getPrice()) {
                return -1;
            } else if (o1.getPrice() == o2.getPrice()) {
                return 0;
            }else{
                return 1;
            }
        });
        System.out.println(Arrays.toString(all));
    }
}
