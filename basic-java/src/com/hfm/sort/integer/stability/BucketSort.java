package com.hfm.sort.integer.stability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 桶式排序
 *
 * @author shkstart 2018-12-17
 */
public class BucketSort {
    public static void bucketSort(int[] data, int min, int max) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        int[] temp = new int[arrayLength];
        int[] buckets = new int[max - min];
        for (int i = 0; i < arrayLength; i++) {
            buckets[data[i] - min]++;
        }
        System.out.println(Arrays.toString(buckets));
        for (int i = 1; i < max - min; i++) {
            buckets[i] = buckets[i] + buckets[i - 1];
        }
        System.out.println(Arrays.toString(buckets));
        System.arraycopy(data, 0, temp, 0, arrayLength);
        for (int k = arrayLength - 1; k >= 0; k--) {
            data[--buckets[temp[k] - min]] = temp[k];
        }
    }

	public static ArrayList BucketSort(int[] arr) {
		int min = arr[0];
		int max = arr[0];
		// 获取最大与最小值
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		// 桶个数
		int bucketNum = (max - min) / arr.length + 1;
		// 创建桶用于存储元素
		ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
		// 桶初始化
		for (int i = 0; i < bucketNum; i++) {
			bucketArr.add(new ArrayList<Integer>());
		}
		// 将每个元素放入桶中
		for (int i = 0; i < arr.length; i++) {
			int num = (arr[i] - min) / (arr.length);
			bucketArr.get(num).add(arr[i]);
		}
		// 对每个桶进行排序
		for (int i = 0; i < bucketArr.size(); i++) {
			Collections.sort(bucketArr.get(i));
		}
		return bucketArr;
	}

    public static void main(String[] args) {
        int[] data = {9, 5, -1, 8, 5, 7, 3, -3, 1, 3};
        System.out.println("排序之前：\n" + Arrays.toString(data));
        bucketSort(data, -3, 10);
        System.out.println("排序之后：\n" + Arrays.toString(data));
    }
}
