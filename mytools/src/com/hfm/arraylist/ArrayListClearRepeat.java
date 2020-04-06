package com.hfm.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 集合工具类
 * 功能： 去除ArrayList 集合中重复的元素
 * @author hfm
 * @version 1.01 2019-10-18
 */
public class ArrayListClearRepeat {
    /**
     * clearRepeat
     * @param OldList
     * @return
     */
    public static ArrayList<Object> clearRepeat(ArrayList<Object> OldList) {
        // 创建一个新的集合对象
        ArrayList<Object> newList = new ArrayList<Object>();
        // 遍历旧集合的元素
        // 获取迭代器对象
        Iterator it = OldList.iterator();
        while (it.hasNext()) {
            // 从旧集合中取出的元素 , 判断新集合中是否存在该元素
            Object object =  it.next();
            // contains 底层是依赖 euqals 方法，equals 默认比较的是内存地址。
            if (!newList.contains(object)) {
                // 如果不包含该本书籍，则应该添加到新集合中
                newList.add(object);
            }
        }
        return newList;
    }
}
