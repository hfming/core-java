package com.hfming.operators;
/**
 * 位运算符
 * @version 1.1 2019-09-17
 * @author hfm
 */
public class BitwiseOperators {
	public static void main(String[] args) {
	    // 00000000  00000000  00000000  00000110  6
	    // 00000000  00000000  00000000  00000011  3
	    // 00000000  00000000  00000000  00000010  & =2
		System.out.println(6 & 3); 
	    // 00000000  00000000  00000000  00000110  6
	    // 00000000  00000000  00000000  00000011  3
	    // 00000000  00000000  00000000  00000111  | =7
		System.out.println(6 | 3);
	    // 00000000  00000000  00000000  00000110  6
	    // 00000000  00000000  00000000  00000011  3
	    // 00000000  00000000  00000000  00000101  ^ =5
		System.out.println(6 ^ 3);
	    // 00000000  00000000  00000000  00000110  6
	    // 00000000  00000000  00000000  00000011  ^3
	    // 00000000  00000000  00000000  00000101 
	    // 00000000  00000000  00000000  00000011  ^3
	    // 00000000  00000000  00000000  00000110  结果是 6
		
		System.out.println(6 ^ 3 ^ 3);
	    // 00000000  00000000  00000000  00000110  6
	    // 11111111  11111111  11111111  11111001  取反 -7
		System.out.println(~6); 
		
		// 面试题目 1：定义了两个变量 a ,b ，然后交换 a 和 b 的值，不准出现第三方变量。
		// 方法一：中间值法
		int aInt = 3;
		int bInt = 5;
		// temp = 3
		int temp = aInt; 
		// aInt = 5
		aInt = bInt; 
		// bInt = 3
		bInt = temp; 
		System.out.println("a = "+ aInt +" , b=" + bInt);
		// 方式二： 相加法。 缺陷：两个 int 值相加有可能会超出 int 的表示范围。
		// a = 8
		aInt = aInt + bInt; 
		// b = 8-5 = 3
		bInt = aInt - bInt; 
		// a = 8 - 3 = 5
		aInt = aInt - bInt; 
		// 方式三： 使用异或. 缺点： 逻辑不清晰。
		// 该方式虽然效率高，而且避免了超出 int 值，但是可读性较差。
		aInt = 3;
		bInt = 5;
		// a = 3 ^ 5
		aInt = aInt ^ bInt; 
		// b = 3 ^ 5 ^ 5 = 3
		bInt = aInt ^ bInt; 
		// a = 3 ^ 5 ^ 3 = 5
		aInt = aInt ^ bInt; 
		System.out.println("a = "+ aInt +" , b=" + bInt);
		// 三种方式都可以对两个变量的值进行交换，但是推荐使用第二种。(面试除外)
		
		// 面试题目 2：取出下面二进制数据的低 4 四位数据。
		//  00000000 00010000 00110000 11000111
		//& 00000000 00000000 00000000 00001111
		//  00000000 00000000-00000000 00000111
		System.out.println(0b00000000000100000011000011000111&0b00000000000000000000000000001111);
	}
}