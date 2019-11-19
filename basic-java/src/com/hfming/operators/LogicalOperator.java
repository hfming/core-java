package com.hfming.operators;
/**
 * 逻辑运算符
 * @version 1.1 2019-09-17 
 * @author hfm
 */
public class LogicalOperator {
	public static void main(String[] args) {
		// & 与
	    // true
		System.out.println(true & true);
		// false
		System.out.println(true & false); 
		// false
		System.out.println(false & true); 
		// false
		System.out.println(false & false); 
		
		// | 或
		// true
		System.out.println(true | true); 
		// true
		System.out.println(true | false); 
		// true
		System.out.println(false | true); 
		// false
		System.out.println(false | false); 
		
		// ! 飞
		// false
		System.out.println(! true);
		// true
		System.out.println(! ! true);
		
		// ^ 异或
		// false
		System.out.println(true ^ true); 
		// true
		System.out.println(true ^ false); 
		// true
		System.out.println(false ^ true);
		// false
		System.out.println(false ^ false); 
		
		// && 短路与
		// true
		System.out.println(true && true); 
		// false
		System.out.println(true && false); 
		// false
		System.out.println(false && true); 
		//false
		System.out.println(false && false); 
		
		// || 短路或
		// true
		System.out.println(true || true); 
		// true
		System.out.println(true || false); 
		// true
		System.out.println(false || true); 
		// false
		System.out.println(false || false); 
		
		// 年龄
		int age = 17;
		// 工作经验
		int workAge = 3;
		System.out.println("条件满足吗？"+(age >= 18 && workAge++ >= 2));
		// 4
		System.out.println("工作经验："+ workAge); 
	}
}
