package com.hfm.collection.list;

import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-25 0:28
 */
public class RandomAccessTest {
    public static void main(String[] args) {
        // 空接口
        RandomAccess randomAccess = new RandomAccess() {
        };

        // 多态
        RandomAccess randomAccess2 = new CopyOnWriteArrayList<>();
        RandomAccess randomAccess3 = new Vector<>();
        RandomAccess randomAccess4 = new ArrayList<>();
        RandomAccess randomAccess5 = new Stack<>();
    }
}
