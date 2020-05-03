package com.hfm.collection.set.enumset;

import com.hfm.entity.Season;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumSet;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-20 16:28
 */
public class EnumSetTest {
    @Test
    public void enumSetTest() {
        // 使用指定元素类型创建空枚举集。
        EnumSet enumSet = EnumSet.noneOf(Season.class);
        System.out.println(enumSet);

        // 创建一个枚举集，其中包含指定元素类型中的所有元素。
        EnumSet<Season> seasons = EnumSet.allOf(Season.class);
        System.out.println(seasons);

        // 创建最初包含指定元素的枚举集。
        EnumSet<Season> spring = EnumSet.of(Season.SPRING, Season.WINTER);
        System.out.println(spring);

        // 创建与指定枚举集具有相同元素类型的枚举集，最初包含相同的元素（如果有）。
        EnumSet<Season> seasons1 = EnumSet.copyOf(spring);
        System.out.println(seasons1);

        // range创建指定范围队列
        EnumSet<Season> range = EnumSet.range(Season.SPRING, Season.AUTUMN);
        System.out.println(range);

        // complementOf补集创建队列
        EnumSet<Season> seasons2 = EnumSet.complementOf(spring);
        System.out.println(seasons2);

        // 创建与指定枚举集具有相同元素类型的枚举集，最初包含相同的元素（如果有）。
        // ArrayList内放置的元素可以重复，而EnumSet内放置的元素不重复.
        // 当复制Collection集合中所有元素来创建新的EnumSet集合时，要求Collection集合中的所有元素必须是同一个枚举类的枚举值
        ArrayList<Season> users = new ArrayList<>();
        EnumSet<Season> seasons3 = EnumSet.copyOf(users);
        System.out.println(seasons);
    }
}
