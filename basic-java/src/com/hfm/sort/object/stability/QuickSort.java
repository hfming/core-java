package com.hfm.sort.object.stability;

/**
 * 快速排序
 * @author shkstart
 * 2018-12-17
 */
public class QuickSort {


	private static void subSort(DataWrap[] data, int start, int end) {
		if (start < end) {
			DataWrap base = data[start];
			int i = start;
			int j = end + 1;
			while (true) {
				while (i < end && data[++i].compareTo(base) <= 0) {

				}
				while (j > start && data[--j].compareTo(base) >= 0) {

				}
				if (i < j) {
					swap(data, i, j);
				} else {
					break;
				}
			}
			swap(data, start, j);
			subSort(data, start, j - 1);
			subSort(data, j + 1, end);
		}
	}

	private static void swap(DataWrap[] data, int i, int j) {
		DataWrap temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	public static void quickSort(DataWrap[] data){
		quickSort(data,0,data.length-1);
	}

	/**
	 * @param arr
	 * @param left
	 * @param right
	 */
	public static void quickSort(DataWrap[] arr, int left, int right) {
		// 判断输入的数组长度不为1
		if (left < right) {
			// 选取数组最左边的数作为基准数
			DataWrap base = arr[left];
			// 将数组left 与right赋值给变量
			int low = left;
			int high = right;

			// 到 low == high  结束
			while (low < high) {
				// 从右边开始寻找比基准数小的值, 找到了就进行交换
				while (arr[high].compareTo(base) >=0  && low < high) {
					high--;
				}
				if (low < high && arr[high].compareTo(base) <= 0) {
					swap(arr, low, high);
				}

				// 从左边开始找比基准数大的值, 找到了就进行交换
				while (arr[low].compareTo(base) <= 0 && low < high) {
					low++;
				}
				if (low < high && arr[low].compareTo(base) >= 0) {
					swap(arr, low, high);
				}
			}
			// 递归调用，分治
			quickSort(arr, left, low - 1);
			quickSort(arr, low + 1, right);
		}
	}

	public static void main(String[] args) {
		DataWrap[] data = { new DataWrap(9, ""), new DataWrap(-16, ""),
				new DataWrap(21, "*"), new DataWrap(23, ""),
				new DataWrap(-30, ""), new DataWrap(-49, ""),
				new DataWrap(21, ""), new DataWrap(30, "*"),
				new DataWrap(30, "") };
		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
		quickSort(data);
		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
	}
}
