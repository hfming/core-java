package com.hfm.genericity;

import com.hfm.entity.Book;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 泛型使用格式
 * @date 2020-04-30 17:56
 */
public class GenericFormat {
    @Test
    public void genericFormat() {
        // true  两边都加入泛型格式，并且泛型的数据类型一致
        ArrayList<Book> list1 = new ArrayList<Book>();
        // true 单边定义泛型格式也可以，为了新老系统的兼用性
        ArrayList list4 = new ArrayList<Book>();
        // true
        ArrayList<Book> list5 = new ArrayList();
        // false	泛型没有多态
        // ArrayList<Object> list2 = new ArrayList<Book>();
        // False
        // ArrayList<Book> list3 = new ArrayList<Object>();
    }
}
