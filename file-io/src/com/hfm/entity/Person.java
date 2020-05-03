package com.hfm.entity;

import java.io.Serializable;

/**
 *	实体类的应该添加实现Serializable接口
 * @author hfm
 *
 */
public class Person implements Serializable {
	private static final long serialVersionUID = 6669510898843320241L;
	private int id;
	private String name;
	private String gmsfhm;
	private int age;
	private double weight;
	private double height;
	public Person() {
		super();
	}
	public Person(int id, String name, String gmsfhm) {
		super();
		this.id = id;
		this.name = name;
		this.gmsfhm = gmsfhm;
	}
	public Person(int id, String name, String gmsfhm, int age, double weight, double height) {
		super();
		this.id = id;
		this.name = name;
		this.gmsfhm = gmsfhm;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}
	@Override
	public int hashCode() {
		return this.gmsfhm.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (gmsfhm == null) {
			if (other.gmsfhm != null)
				return false;
		} else if (!gmsfhm.equals(other.gmsfhm))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", gmsfhm=" + gmsfhm + ", age=" + age + ", weight=" + weight
				+ ", height=" + height + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGmsfhm() {
		return gmsfhm;
	}
	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
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
