package com.hfm.object;

import com.hfm.entity.Goods;

import java.util.Arrays;
import java.util.Comparator;

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
        Arrays.sort(all, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Goods g1 = (Goods) o1;
                Goods g2 = (Goods) o2;
                return g1.getName().compareTo(g2.getName());
            }
        });
        System.out.println(Arrays.toString(all));
    }
}
