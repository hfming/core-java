package com.hfming.decimal;
/**
 * 进制的种类
 * @version 1.1 2019-09-17
 * @author hfm
 */
public class Decimal {
	public static void main(String[] args) {
		// 十进制：都是以0-9这九个数字组成，不能以0开头，已0开头的为八进制。
		int aInt = 10;
		System.out.println(aInt);
		
		// 二进制：由0和1两个数字组成，以以0b开头
		int bInt = 0B10; 
		// 10(2) --> 2(10)
		System.out.println(bInt);
		
		// 八进制: 由0-7数字组成，为了区分与其他进制的数字区别，开头都是以0开始
		int cInt = 010; 
		// 10(8) --> 8(10)
		System.out.println(cInt);
		
		// 十六进制：由0-9和 A-F 组成。为了区分于其他数字的区别，开头都是以 ox开始
		int dInt = 0X10; 
		// 10(16) --> 16(10)
		System.out.println(dInt);
		
		// 进制转换
		// 1.十进制转换为二进制
		System.out.println(Integer.toBinaryString(aInt));
		// 2.十进制转换为八进制
		System.out.println(Integer.toHexString(aInt));
		// 3.十进制转换为十六进制
		System.out.println(Integer.toOctalString(aInt));
	}
	/**
	 * 讲10 进制转化为二进制
	 * @param de ：待转换的十进制
	 * @return ：转换后的二进制（string）
	 */
	public static String decimal2Binary(int de) {
		String numstr = "";
		while (de > 0) {
		    // 除2 取余数作为二进制数
			int res = de % 2; 
			numstr = res + numstr;
			de = de / 2;
		}
		return numstr;
	}
	/**
	 * 将二进制转换为10进制
	 * @param bi ：待转换的二进制
	 * @return
	 */
	public static Integer biannary2Decimal(int bi) {
		String binStr = bi + "";
		Integer sum = 0;
		int len = binStr.length();
		for (int i = 1; i <= len; i++) {
			// 第i位 的数字为：
			int dt = Integer.parseInt(binStr.substring(i - 1, i));
			sum += (int) Math.pow(2, len - i) * dt;
		}
		return sum;
	}
}
