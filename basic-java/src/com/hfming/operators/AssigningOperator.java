package com.hfming.operators;
/**
 * 赋值运算符
 * @version 1.1 2019-09-17
 * @author hfm
 */
public class AssigningOperator {
	public static void main(String[] args) {
		int aInt = 10;
		// 加等于
		System.out.println(aInt += 10);
		// 减等于
		System.out.println(aInt -= 10);
		// 赋值
		System.out.println(aInt = 10);
		// 除等于
		System.out.println(aInt /= 10);
		// 乘等于
		System.out.println(aInt *= 10);
		// 模等于
		System.out.println(aInt %= 3);
		
		// 比较 == 号与 = 号的不同
		// 基本数据类型 = 传递数值
		System.out.println(aInt = 1);
		// 基本数据类型 == 号比较大小
		System.out.println(aInt == 0);
		
		int[] arr = new int[] {1,2,3,4};
		// 引用数据类型 = 传递内存地址
		System.out.println(arr = new int[]{4,5,6,7});
		// 引用数据类型== 号 比较内存地址
		System.out.println(arr == new int[]{4,5,6,7});
	}
}
