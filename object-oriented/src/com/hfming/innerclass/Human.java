package com.hfming.innerclass;
/**
 * 内部类
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class Human extends Animal {
	private String name;
	private int age;

	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * 成员内部类
	 * @author hfm
	 */
	class heart{
		/**
		 * 
		 */
		private int heartbeatRete;

		public int getHeartbeatRete() {
			return heartbeatRete;
		}

		public void setHeartbeatRete(int heartbeatRete) {
			this.heartbeatRete = heartbeatRete;
		}
		public void beat(){
			System.out.println("跳动");
		}
	}
	static class heart2{
		/**
		 * 如果一个内部类中定义了一个静态变量，该内部类必须使用static进行修饰
		 * 静态的成员变量是不依赖对象而存在的
		 */
		private static int heartbeatRete;

		public int getHeartbeatRete() {
			return heartbeatRete;
		}

		public void setHeartbeatRete(int heartbeatRete) {
			this.heartbeatRete = heartbeatRete;
		}
		public void beat(){
			System.out.println("跳动");
		}
	}
	public heart  getHeart(){
		return new  Human("32",54).new  heart();
	}
	/**
	 * 局部内部类
	 */
	public void eat(){
		final int  x = 10;// x的生命周期：执行到该语句的时候存在内存中， 方法执行完毕之后消失。
		class Mouse{
			public void mousEat(){
				System.out.println("内部类方法");	
				System.out.println("这个是一个局部内部类的 show 方法.."+x); //问题：给人感觉 y 的生命周期被延长了。
				/*
				解决办法：让局部内部类访问局部变量的复制品。
				 */
			}
		}
		Mouse mouse = new Mouse();// Inner 对象的生命周期比 y 的生命周期要长
		mouse.mousEat();
	}
	/**
	 * 匿名内部类
	 */
	public void show(){
		//这里创建的不是 Dao 接口的对象，创建的是 Dao 接口实现类的对象。
		new Human("34",34){
			public void add(){
				System.out.println("添加成功..");
			}
		}.add();
	}
	Animal f = new Animal(){ //这里创建的并不是Animal的对象，创建的是Animal的子类对象，只不过其子类目前没有类名借用了ANimal名字而已。
		//匿名内部类 的成员 
		public Animal run(){
			System.out.println("鱼在游...");
			return this;
		}
		@Override
		public void sleep(){
			System.out.println("鱼睁开眼睛睡觉...");
		}
		@Override
		public void eat() {

		}
	}.run();

	@Override
	public void sleep() {

	}
}
