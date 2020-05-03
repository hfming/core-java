package com.hfm.collections;

import com.hfm.entity.Person3;
import com.hfm.entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 集合工具类是使用
 *
 * @author hfm
 */
public class CollectionsTest {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(65);
        list.add(23);
        System.out.println(list.toString());
        //sort排序
        Collections.sort(list);
        Collections.sort(list, (Comparator<Student>) (o1, o2) -> {
			// 年龄降序
			int result = o2.getAge() - o1.getAge();//年龄降序
			if (result == 0) {//第一个规则判断完了 下一个规则 姓名的首字母 升序
				result = o1.getName().charAt(0) - o2.getName().charAt(0);
			}
			return result;
		});
        System.out.println(list.toString());
        ArrayList list2 = new ArrayList<Person3>();
        list2.add(new Person3(1, "sd"));
        list2.add(new Person3(2, "s4d"));
        list2.add(new Person3(4, "sd43"));
        list2.add(new Person3(3, "sd645"));
        Collections.sort(list2, new IdComparator());
        System.out.println(list2);
        //binarySearch
        //有序
        System.out.println(Collections.binarySearch(list, 2));
        System.out.println(Collections.binarySearch(list2, new Person3(4, "sd43"), new IdComparator()));
        //max与min
        System.out.println(Collections.min(list));
        System.out.println(Collections.min(list2, new IdComparator()));
        System.out.println(Collections.max(list));
        System.out.println(Collections.max(list2, new IdComparator()));
        //reverse翻转
        Collections.reverse(list);
        System.out.println(list.toString());
        Collections.reverse(list2);
        System.out.println(list2.toString());
        //对 list 集合中的元素进行位置的置换。swap(list,x,y);
        Collections.swap(list, 0, 3);
        System.out.println(list.toString());
        //返回同步集合
        List snyList = Collections.synchronizedList(list);
        //转化为数组
        Object[] arr = list.toArray();
        //替黄list集合中的元素
        Collections.replaceAll(list, 1, "Str");
        System.out.println(list.toString());
    }
}
