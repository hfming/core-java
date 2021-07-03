package com.hfm.genericity;

import com.hfm.entity.Citizen;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 泛型使用 demo
 * @date 2020-04-30 9:31
 */
public class GenericityTest {
    /**
     * 没有使用泛型时出现的问题
     */
    @Test
    public void withOutGenericity() {
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

    /**
     * 使用泛型
     */
    @Test
    public void withGenericity() {
        Collection<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("itcast");
        // list.add(5);//当集合明确类型后，存放类型不一致就会编译报错
        // 集合已经明确具体存放的元素类型，那么在使用迭代器的时候，迭代器也同样会知道具体遍历元素类型
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next();
            //当使用Iterator<String>控制元素类型后，就不需要强转了。获取到的元素直接就是String类型
            System.out.println(str.length());
        }
    }

    /**
     * 泛型的嵌套
     * 泛型可以嵌套使用
     */
    @Test
    public void generictityUse() {
        HashMap<String, ArrayList<Citizen>> map = new HashMap<String, ArrayList<Citizen>>();
        ArrayList<Citizen> list = new ArrayList<Citizen>();
        list.add(new Citizen("刘恺威"));
        list.add(new Citizen("杨幂"));
        list.add(new Citizen("小糯米"));
        map.put("刘恺威", list);
        Set<Map.Entry<String, ArrayList<Citizen>>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, ArrayList<Citizen>>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<Citizen>> entry = iterator.next();
            String key = entry.getKey();
            ArrayList<Citizen> value = entry.getValue();
            System.out.println("户主：" + key);
            System.out.println("家庭成员：" + value);
        }
    }
}
