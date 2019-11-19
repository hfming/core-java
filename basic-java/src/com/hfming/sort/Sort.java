package com.hfming.sort;

import java.util.Arrays;
/**
 * 数组常用算法
 * @author hfm
 */
public class Sort {
	public static void main(String[] args) {
		int [] a = new int[]{43,434,34,32,454,454,56,98,0};
		System.out.println(Arrays.toString(reverseArray(a)));
		//数组工具类的使用
		System.out.println(Arrays.toString(reverseArray(a)));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.binarySearch(a, 34));
		int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5,0,0,0,0,0,0,0,0,0,0,0,0} ;
		System.out.println(Arrays.toString(clearZero(oldArr)));
		
		int[] arr = {1,4,4,1,1,7};
		System.out.println(Arrays.toString(clearRepetition(arr)));
		int [][] arg = {{2,2},{3,3},{5,45,65,5}};
		toStringTwoDimensionalArray(arg);
		System.out.println();
		System.out.println(getSumTwoDimensionalArray(arg));
		System.out.println(getTwoDimensionalArrayNum(arg));
	}
	/**
	 * 冒泡排序
	 * @param arr
	 */
	public static void bubbleSort(int[] arr){
		for(int x=0; x<arr.length-1; x++){
			for(int y=0; y<arr.length-x-1; y++){//-x:让每次参与比较的元减。//-1:避免角标越界。
				if(arr[y]>arr[y+1]){
					int temp = arr[y];
					arr[y] = arr[y+1];
					arr[y+1] = temp;
				}
			}
		}
	}
	/**
	 * 选择排序（快速排序）
	 * @param arr
	 */
	public static void selectSort(int[] arr){
		for(int x=0; x<arr.length-1; x++){
			for(int y=x+1; y<arr.length; y++){ //为什么y的初始化值是 x+1？  因为每一次比较，
				//都用x角标上的元素和下一个元素进  行比较。
				if(arr[x]>arr[y]){
					int temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;
				}
			}
		}
	}
	/**
	 * 二分法
	 * @param arr
	 * @param key
	 * @return
	 */
	public static int halfSeach(int[] arr,int key){
		int min,mid,max;
		min = 0;
		max = arr.length-1;
		mid = (max+min)/2;
		while(arr[mid]!=key){
			if(key>arr[mid])
				min = mid + 1;
			else if(key<arr[mid])
				max = mid - 1;
			if(min>max)
				return -1;
			mid = (max+min)/2;
		}
		return mid;
	}
	/**
	 * 数组翻转
	 */
	private static int[] reverseArray(int [] arg) {
		for(int start=0,end=arg.length-1;start<end;start++,end--){
			int temp = arg[start];
			arg[start] = arg[end];
			arg[end] = temp;
		}
		//System.out.println(Arrays.toString(arg));
		return arg;
	}
	//二维数组
	private static void twoDimensionalArray(int [][] arg) {
		System.out.println(arg.length);	
		System.out.println(arg[0].length);
	}
	//遍历二维数组
	private static void toStringTwoDimensionalArray(int [][] arg) {
		for(int i=0;i<arg.length;i++){
			for(int j=0;j<arg[i].length;j++){
				if(j==0){
					System.out.print("["+arg[i][j]+",");
				}else if(j==arg[i].length-1){
					System.out.print(arg[i][j]+"]");
				}else{
					System.out.print(arg[i][j]+",");
				}
			}
		}
	}
	//对二维数组求和
	private static int getSumTwoDimensionalArray(int [][] arg) {
		int sum =0;
		for(int i=0;i<arg.length;i++){
			for(int j=0;j<arg[i].length;j++){
				sum +=arg[i][j];
			}
		}
		return sum;
	}
	//统计二维数组中元素的个数
	private static int getTwoDimensionalArrayNum(int [][] arg) {
		int count =0;
		for(int i=0;i<arg.length;i++){
			for(int j=0;j<arg[i].length;j++){
				count ++;
			}
		}
		return count;
	}
	//现在有如下的一个数组：int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5} ，
	private static int[]  clearZero(int [] arg) {
		//统计0的个数
		int count = 0;
		for(int i =0;i<arg.length;i++){
			if(arg[i] == 0){
				count ++;
			}
		}

		int [] result = new int[arg.length-count];
		int num = 0;
		for(int i =0;i<arg.length;i++){
			if(arg[i] != 0){
				result[num] = arg[i];
				num++;
			}
		}
		return result;
	}
	//清除重复元素。 int[] oldArr = {1,4，9,4,1,1,7}； 把非重复元素存储到一个新的数组中返回，而且也是不能浪费长度
	private static int[] clearRepetition(int [] arg) {
		int count = 0;
		for(int i=0;i<arg.length-1;i++){
			for(int j=i+1;j<arg.length;j++){
				if(arg[i]==arg[j]){
					count++;
					break;//重复的只统计一次
				}
			}
		}
		int [] result = new int[arg.length-count];
		System.out.println(result.length);
		int num =0 ;
		boolean flag ;
		for(int i=0;i<arg.length;i++){
			flag = false;
			for(int j=0;j<result.length;j++){
				if(result[j]==arg[i]){
					flag =true;
				}
			}
			if(flag ==false){
				result[num]=arg[i];
				num ++;
			}
		}
		return result;
	}
}
