package com.hfm.entity;

public class Person {
	private int id ;
	private String name;
	private String age;
	
	@Override
	public int hashCode() {
		return this.id;
	}
	/**
	 * 需要重写equals方法，id相同即可
	 */
	@Override
	public boolean equals(Object obj) {
		Person person = null;
		if(obj instanceof Person){
			person = (Person) obj;
		}
		return this.id == person.getId();
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}
