package com.hfming.datatypeconversion;
/**
 * 强制数据类型转化
 * @version 1.1 2019-09-17
 * @author hfm
 */
public class ForceDataTypeConversion {
	/**
	 * 强制数据类型转换要注意精度损失
	 * 大数据类型转化为小数据类型为强制数据类型转化
	 * @param args
	 */
	public static void main(String[] args) {
		// 强制数据类型转化
		byte aByte = 100;
		// b+2 遇到了加法运算，2 默认是 int类型，byte类型 b变量存储的值自动类型提升为了 int类型。执行完加法运算后的结果就是 int类型，想要将 int的类型值放入到 byte类型变量 b中，无法放入，编译报错。
		aByte = (byte) (aByte + 2);
		System.out.println(aByte);
		// 当两种类型彼此不兼容，或者目标类型取值范围小于源类型（目标是byte源是 int）无法自动转换，此时就需要进行强制类型转换。
		int aInt = 128;
		byte bByte = (byte) aInt;
		// -128 此时的强转已经造成了数值的不准确 
		System.out.println(bByte);
	}
}
