package com.hfming.sort;

import java.util.Arrays;
/**
 * 8种经典算法
 * @author hfm
 */
public class ClassicalSottingAlgorithms {
	public static void main(String[] args) {
		int [] a = new int[]{43,434,34,32,454,454,56,98,0};
		//System.out.println(Arrays.toString(insertionSort(a)));
		System.out.println(Arrays.toString(bubbleSort(a)));
	}
	/**
	 * 插入排序
	 * @param a
	 * @return
	 */
	public static int[] insertionSort(int[] a){
		for (int i = 0; i < a.length-1; i++) { 	
			// 第i+1个元素插入到前i个已排序数中
			/*
			 *	i=0,j=1,a[0]与a[1]进行对比大小
			 *	i=1,j=2,a[1]与a[2]进行对比大小 
			 */
			for(int j = i + 1; j > 0; j--) {	
				if(a[j] < a[j-1]){
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
		return a;
	}
	/**
	 * 选择排序
	 * @param int [] a
	 * @param int n
	 * @return
	 */
	public static  int[] selectionSort(int[] a,int n) {
		for (int i = 0; i < a.length; i++) {
			int min = a[i]; 		//每次循环默认第i个元素为最小值
			int num = i; 			//num 用来记录未排序元素里面的最小值下标
			/*
			 *  i=0,min=a[0],num=0,j=1,a[1]与a[0]进行对比
			 *  i=0,min=a[0],num=0,j=2,a[2]与a[0]进行对比
			 */
			for(int j = i+1; j < a.length; j++){
				if(a[j] < min){
					min = a[j];
					num = j;
				}
			}
			// num != i，则表示已在无排序元素里选到比a[i]更小的值
			if(num != i){
				a[num] = a[i];
				a[i] = min;
			}
		}
		return a;
	}
	/**
	 * 冒泡排序
	 */
	private static int[] bubbleSort(int[] arg) {
		/*
		 * i=0,j=0,arg[0]与arg[1]比较大小
		 * i=0,j=1,arg[1]与arg[2]比较大小
		 * i=0,j=2,arg[2]与arg[3]比较大小
		 * i=1,j=0,arg[0]与arg[1]
		 */
		for(int i=0;i<arg.length-1;i++){
			for(int j =0;j<arg.length-i-1;j++){
				if(arg[j]>=arg[j+1]){
					int temp = arg[j];
					arg[j] = arg[j+1];
					arg[j+1] = temp;
				}
			}
		}
		return arg;
	}
}
