package com.hfming.inherit;
/**
 * 球队类
 * 整体与部分中的整体类
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class Team {
	//球队的名字
	String name;
	//球员 1
	Player p1;
	//球员 1
	Player p2;
	//球员 1
	Player p3;
	//整体类包含多个部分类对象
	public Team(String name,Player p1,Player  p2,Player  p3){
		this.name = name;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	//开赛
	public void startPlay(){
		System.out.println(name+"开赛了...");
	}
}
