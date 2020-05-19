package com.hfm.genericity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-30 10:36
 */
public class WithOutGenericity {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        coll.add("abc");
        coll.add("itcast");
        // 由于集合没有做任何限定，任何类型都可以给其中存放
        coll.add(5);
        Iterator it = coll.iterator();
        while (it.hasNext()) {
            // 需要打印每个字符串的长度,就要把迭代出来的对象转成String类型
            // java.lang.ClassCastException
            String str = (String) it.next();
            System.out.println(str.length());
        }
    }
}
