package com.hfm.collection.list.abstractsquentiallist;

import java.util.LinkedList;
import java.util.Random;

public class PokeTest {

	public static void main(String[] args) {
		LinkedList<Poker> pokers = createPoker();
		shufflePoker(pokers);
		showPoker(pokers);
	}
	// 洗牌
	public static void shufflePoker(LinkedList<Poker> pokers){
		Random random = new Random();
		for(int i = 0 ; i<100 ; i++){
			// 随即产生两个索引值
			int index1 = random.nextInt(pokers.size());
			int index2 = random.nextInt(pokers.size());
			// 让两张牌的位置交换
			Poker p1 = (Poker) pokers.get(index1);
			Poker p2 = (Poker) pokers.get(index2);
			pokers.set(index1, p2);
			pokers.set(index2, p1);
		}
	}
	// 显示扑克牌
	public static void showPoker(LinkedList<Poker> pokers){
		for(int i = 0 ; i< pokers.size() ; i++){
			if(i%10==9){
				System.out.println(pokers.get(i));
			}else{
				System.out.print(pokers.get(i)+",");
			}
		}
	}
	// 生成一副扑克牌
	public static LinkedList<Poker> createPoker(){
		// 定义一个集合存储扑克牌
		LinkedList<Poker> list = new LinkedList<Poker>();
		// 定义一个数组存储所有的点数
		String[] nums = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		// 定义一个数组存储所有的花色
		String[] colors = {"方块","梅花","红桃","黑桃"};
		for(int i = 0 ; i< nums.length ; i++){
			for(int j = 0 ; j< colors.length ; j++){
				list.add(new Poker(colors[j], nums[i]));
			}
		}
		return list;
	}
}
