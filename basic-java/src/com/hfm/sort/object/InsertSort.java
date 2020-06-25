package com.hfm.sort.object;

/**
 * 直接插入排序
 *
 * @author shkstart
 * 2018-12-17
 */
public class InsertSort {
    public static void insertSort(DataWrap[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        for (int i = 1; i < arrayLength; i++) {
            DataWrap temp = data[i];
            if (data[i].compareTo(data[i - 1]) < 0) {
                int j = i - 1;
                for (; j >= 0 && data[j].compareTo(temp) > 0; j--) {
                    data[j + 1] = data[j];
                }
                data[j + 1] = temp;
            }
            System.out.println(java.util.Arrays.toString(data));
        }
    }

    /**
     * @param data
     */
    public static void insertSort2(DataWrap[] data) {
        System.out.println("开始排序");
        // 插入排序将数组第一个元素当作有序数组, 其他的元素依次插入到数组中, 所以插入排序是从数组第二个元素 arr[1]开始, 到最后一个结束
        for (int i = 1; i < data.length; i++) {
            // 记录待插入的值
            DataWrap value = data[i];
            // 记入插入的序列
            int num = i;
            while (num >= 1 && data[num - 1].compareTo(value) >= 0) {
                data[num] = data[num - 1];
                num--;
            }
            data[num] = value;
        }
    }

    public static void main(String[] args) {
        DataWrap[] data = {new DataWrap(9, ""), new DataWrap(-16, ""),
                new DataWrap(21, "*"), new DataWrap(23, ""),
                new DataWrap(-30, ""), new DataWrap(-49, ""),
                new DataWrap(21, ""), new DataWrap(30, "*"),
                new DataWrap(30, "")};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        insertSort(data);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }
}
