package com.balazsholczer.linkedlist;

// Lets say this is a user defined datatype.
// Our LinkedList must be able to store, remove, compare these user defined datatypes as well.
// This datatype also serves as a good example of how a Person, account etc. are infact some user defined datatypes that become part of complex data structures eg: Graphs for for eg. say Facebook.com or Linkedin.com
// Once the data structure is efficient, then efficient algorithms can be applied to carry out tasks/operations on the data.

public class Person implements Comparable<Person> {

	private int age;
	private String name;

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Person o) {
		return Integer.compare(this.age, o.getAge());
	}

}
