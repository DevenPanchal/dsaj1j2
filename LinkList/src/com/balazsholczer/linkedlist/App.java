package com.balazsholczer.linkedlist;

public class App {

	public static void main(String[] args) {

		List<Integer> myLinkedList = new LinkedList<>();

		myLinkedList.insert(1);
		myLinkedList.insert(2);
		myLinkedList.insert(3);
		myLinkedList.insert(4);
		myLinkedList.traverseList();
		myLinkedList.remove(1);
		myLinkedList.traverseList();

		myLinkedList.deveninsert(19);
		myLinkedList.deveninsert(59);
		myLinkedList.deveninsert(49);
		myLinkedList.deveninsert(29);
		myLinkedList.deveninsert(39);
		myLinkedList.deveninsert(69);
		myLinkedList.devenprintList();

		myLinkedList.devenremove(39);
		myLinkedList.devenremove(49);
		myLinkedList.devenremove(69);
		myLinkedList.devenprintList();

		System.out.println();

		System.out.println(
				"Lets now use String data. Remember we are using Generics. You can change datatype on a per object/instance level");
		System.out.println(
				"If you see the line of code in App.java- this illustrates Interface-Implementation pluggability, Power of Generics v/s just Function Overriding  and sort of Dynamic Polymorphism in Java");
		List<String> secondLinkedList = new LinkedList<>();

		System.out.println();

		secondLinkedList.insert("hi");
		secondLinkedList.insert("how");
		secondLinkedList.insert("you");
		secondLinkedList.insert("?");
		secondLinkedList.traverseList();
		secondLinkedList.remove("how");
		secondLinkedList.remove("?");
		secondLinkedList.traverseList();

		secondLinkedList.deveninsert(".");
		secondLinkedList.deveninsert("where");
		secondLinkedList.deveninsert("are");
		secondLinkedList.deveninsert("you");
		secondLinkedList.devenprintList();
		secondLinkedList.devenremove("where");
		secondLinkedList.devenremove("hi");
		secondLinkedList.devenprintList();

		System.out.println();
		System.out.println(
				"We can also use user defined variables like Classes with Java Generics. Here we instantiate the linked list to be of type <Person>. So all its methods which accept generics will work on Person objects and give a resonable response as defined in their implementation to Person objects");
		System.out.println();

		List<Person> thirdLinkedList = new LinkedList<Person>();

		Person ram = new Person(29, "Ram");
		Person sundar = new Person(25, "Sundar");
		Person mike = new Person(62, "Mike");
		Person adam = new Person(25, "Adam");
		Person john = new Person(57, "John");
		Person eve = new Person(19, "Eve");
		Person peter = new Person(33, "Peter");

		thirdLinkedList.insert(ram);
		thirdLinkedList.insert(sundar);
		thirdLinkedList.insert(mike);
		thirdLinkedList.insert(adam);
		thirdLinkedList.traverseList();
		thirdLinkedList.remove(adam);
		thirdLinkedList.traverseList();

		thirdLinkedList.deveninsert(john);
		thirdLinkedList.deveninsert(eve);
		thirdLinkedList.deveninsert(peter);
		thirdLinkedList.devenprintList();
		thirdLinkedList.devenremove(peter);
		thirdLinkedList.devenremove(sundar);
		thirdLinkedList.devenprintList();
	}
}
