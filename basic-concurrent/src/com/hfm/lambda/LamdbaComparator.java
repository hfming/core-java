package com.hfm.lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-07 16:19
 */
public class LamdbaComparator {
    public static void main(String[] args) {
        Person[] array = {
                new Person("古力娜扎", 19),
                new Person("迪丽热巴", 18),
                new Person("马尔扎哈", 20)};
        Arrays.sort(array, (Person a, Person b) -> {
            return a.getAge() - b.getAge();
        });
        for (Person person : array) {
            System.out.println(person);
        }
        Arrays.sort(array, Comparator.comparingInt(Person::getAge));
    }
}
