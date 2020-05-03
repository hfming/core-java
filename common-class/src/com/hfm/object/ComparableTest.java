package com.hfm.object;

import com.hfm.entity.Goods;

import java.util.Arrays;

/**
 * @author hfm
 * @version 1.01 2020-04-08 17:56
 * @date 2020/4/8
 */
public class ComparableTest {
    public static void main(String[] args) {
        Goods[] all = new Goods[4];
        all[0] = new Goods("《红楼梦》", 100);
        all[1] = new Goods("《西游记》", 80);
        all[2] = new Goods("《三国演义》", 140);
        all[3] = new Goods("《水浒传", 120);
        Arrays.sort(all);
        System.out.println(Arrays.toString(all));
    }
}
