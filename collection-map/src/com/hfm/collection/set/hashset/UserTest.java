package com.hfm.collection.set.hashset;

import com.hfm.entity.User2;

import java.util.HashSet;
import java.util.Scanner;

public class UserTest {
	public static void main(String[] args) {
		// 定义一个集合用于存储用户
		HashSet users = new HashSet();
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("请输入用户名：");
			String userName = scanner.next();
			System.out.println("请输入密码：");
			String password = scanner.next();
			User2 user = new User2(userName, password);
			if(users.add(user)){
				System.out.println("添加用户成功..");
			}else{
				System.out.println("用户名与密码已经存在，请重新注册!!");
			}
			System.out.println("当前的用户："+ users);
		}
	}
}
