package com.hfm.collections;

import java.util.Arrays;
import java.util.List;

/**
 * 数组工具类的使用
 * 
 * @author hfm
 */
public class ArraysTest {

	public static void main(String[] args) {
		int[] arr = new int[] { 21, 32, 3234, 435, 6565, 5675 };
		// binarySearch
		System.out.println(Arrays.binarySearch(arr, 34));
		// sort
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		// copyOf
		System.out.println(Arrays.toString(Arrays.copyOf(arr, 10)));
		System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, 7)));
		// equals
		System.out.println(Arrays.equals(arr, Arrays.copyOfRange(arr, 0, 7)));
		// 转化为集合
		List<int[]> list = Arrays.asList(arr);
		for (int[] a : list) {
			System.out.println(Arrays.toString(a));
		}

	}

}
