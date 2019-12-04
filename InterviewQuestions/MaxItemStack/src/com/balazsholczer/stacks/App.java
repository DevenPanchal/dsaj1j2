package com.balazsholczer.stacks;

public class App {

	public static void main(String[] args) {

		MaxItemStack maxItemStack = new MaxItemStack();

		maxItemStack.push(10);
		maxItemStack.push(5);
		maxItemStack.push(1);
		maxItemStack.push(12);
		maxItemStack.push(11);

		System.out.println(maxItemStack.getMaxItem());

		System.out.println("Now running a similar program with deven's implementation." + "\n"
				+ "Note this implementation has Time complexity O(1) AND Memory complexity O(1)");

		DevenMaxItemStack devenMaxItemStack = new DevenMaxItemStack();

		devenMaxItemStack.push(10);
		devenMaxItemStack.push(5);
		devenMaxItemStack.push(1);
		devenMaxItemStack.push(12);
		devenMaxItemStack.push(11);

		System.out.println(devenMaxItemStack.getMaxItem());

	}
}
