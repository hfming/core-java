package com.hfm.collection;

import java.util.Objects;

public class Person {
	private int id ;
	private String name;
	private String age;

    public Person() {

    }

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Person)) {
			return false;
		}
		Person person = (Person) o;
		return getId() == person.getId() &&
				Objects.equals(getName(), person.getName()) &&
				Objects.equals(getAge(), person.getAge());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getAge());
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
