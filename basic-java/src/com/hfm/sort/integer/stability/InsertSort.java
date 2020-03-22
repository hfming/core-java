package com.hfm.sort.integer.stability;

/**
 * 直接插入排序
 *
 * @author shkstart 2018-12-17
 */
public class InsertSort {
    public static void insertSort(int[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        for (int i = 1; i < arrayLength; i++) {
            int temp = data[i];
            if (data[i] - data[i - 1] < 0) {
                int j = i - 1;
                for (; j >= 0 && data[j] - temp > 0; j--) {
                    data[j + 1] = data[j];
                }
                data[j + 1] = temp;
            }
            System.out.println(java.util.Arrays.toString(data));
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort2(int[] arr) {
        // 总共 arr.length -1 次插入, 从数组第二位即 arr[1] 开始插入
        for (int i = 1; i < arr.length; i++) {
            // 待插入的数
            int value = arr[i];
            // 待插入的序列
            int num = i;
            // 如果arr[i]比前一位要低要将前一位的值赋值给后一位，直到arr[i]的值与前一位相同或大于时
            while (num >= 1 && value <= arr[num - 1]) {
                arr[num] = arr[num - 1];
                num--;
            }
            // 最后将arr[i]的值赋值给最前的位
            arr[num] = value;
        }
        // System.out.println(Arrays.toString(arr));
    }

    /**
     * 成对插入算法
     * 具体执行过程：上面的do-while循环已经排好的最前面的数据
     * *（1）将要插入的数据，第一个值赋值a1,第二个值赋值a2,
     * * (2)然后判断a1与a2的大小，使a1要大于a2
     * * (3)接下来，首先是插入大的数值a1，将a1与k之前的数字一一比较，直到数值小于a1为止，把a1插入到合适的位置，注意：这里的相隔距离为2
     * * (4)接下来，插入小的数值a2,将a2与此时k之前的数字一一比较，直到数值小于a2为止，将a2插入到合适的位置，注意：这里的相隔距离为1
     * * (5)最后把最后一个没有遍历到的数据插入到合适位置
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void insertSort3(int[] arr, int left, int right) {
        do {
            if (left >= right) {
                return;
            }
        } while (arr[++left] >= arr[left - 1]);
        for (int k = left; ++left <= right; k = ++left) {
            int a1 = arr[k], a2 = arr[left];
            if (a1 < a2) {
                a2 = a1;
                a1 = arr[left];
            }
            while (a1 < arr[--k]) {
                arr[k + 2] = arr[k];
            }
            arr[++k + 1] = a1;

            while (a2 < arr[--k]) {
                arr[k + 1] = arr[k];
            }
            arr[k + 1] = a2;
        }
        int last = arr[right];

        while (last < arr[--right]) {
            arr[right + 1] = arr[right];
        }
        arr[right + 1] = last;
    }

    public static void main(String[] args) {
        int[] data = {9, -16, 21, 23, -30, -49, 21, 30, 30};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        insertSort2(data);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));


    }
}
