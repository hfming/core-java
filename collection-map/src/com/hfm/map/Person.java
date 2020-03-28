package com.hfm.map;
/**
 * 实体类人
 *
 * @author hfm
 */
public class Person {
	private String  gmsfhm;
	private int gmsfhm_dm ;
	private String name ;
	private int age;
	private double weight;
	private double height;

	/**
	 * 无参构造函数
	 */
	public Person() {
		super();
	}

	/**
	 * 全参构造函数
	 * @param gmsfhm
	 * @param gmsfhm_dm
	 * @param name
	 * @param age
	 * @param weight
	 * @param height
	 */
	public Person(String gmsfhm, int gmsfhm_dm, String name, int age, double weight, double height) {
		this.gmsfhm = gmsfhm;
		this.gmsfhm_dm = gmsfhm_dm;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}

	public Person(String gmsfhm) {
		super();
		this.gmsfhm = gmsfhm;
		this.gmsfhm_dm = gmsfhm.hashCode();
	}

	@Override
	public int hashCode() {
		return this.gmsfhm_dm;
	}
	@Override
	public boolean equals(Object obj) {
		Person p = null;
		if(obj instanceof Person){
			p = (Person) obj;
		}
		return p.gmsfhm_dm ==this.gmsfhm_dm;
	}
	@Override
	public String toString() {
		return "Person [gmsfhm=" + gmsfhm + ", gmsfhm_dm=" + gmsfhm_dm + ", name=" + name + ", age=" + age + ", weight="
				+ weight + ", height=" + height + "]";
	}
	public String getGmsfhm() {
		return gmsfhm;
	}
	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}
	public int getGmsfhm_dm() {
		return gmsfhm_dm;
	}
	public void setGmsfhm_dm(int gmsfhm_dm) {
		this.gmsfhm_dm = gmsfhm_dm;
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
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
}
