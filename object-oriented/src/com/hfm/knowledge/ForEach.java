package com.hfm.knowledge;

/**
 * @author hfm
 * @version 1.01 2020-03-27 19:49
 * @date 2020/3/27
 */
public class ForEach {
    public static void main(String[] args) {
        int[] arr = new int[]{23, 4343, 545, 656};
        /**
         * 增强 for 循环的主要作用是： 简化迭代器的书写格式。 增强 for 循环的格式： for(元素的数据类型 变量名 : 遍历的目标){}
         * 使用增强for循环的前提： 只有实现了Iterable接口的对象或者是数组对象才能使用。 增强for循环要注意的细节： 1.增强for循环
         * 的底层还是通过获取迭代器的方式进行遍历的，只不过不需要我们手动获取迭代器而已，所以在使用增强for循环的遍历元素的过程中
         * 不准使用集合对象改变集合对象中的元素个数。 2.增强for循环与迭代器遍历的区别： 增强for循环只能用于遍历集合的元素，不能增删元素 。
         * 而迭代器的遍历方式可以使用迭代器的方法增删元素。 3.增强for循环使用的时候必须要存在一个遍历的目标对象，
         * 而普通的for循环可以不存在遍历的目标对象。
         */
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
