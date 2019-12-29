package com.balazsholczer.redblacktree;

public class App {

	public static void main(String[] args) {

		RedBlackTree tree1 = new RedBlackTree();

		tree1.insert(10);
		tree1.traverseGraph();
		System.out.println("--------------------");
		tree1.insert(20);
		tree1.traverseGraph();
		System.out.println("--------------------");
		tree1.insert(30);
		tree1.traverseGraph();
		System.out.println("--------------------");
		tree1.insert(15);
		tree1.traverseGraph();
		System.out.println("--------------------");

		System.out.println("*********************************************************");

		RedBlackTree tree2 = new RedBlackTree();

		tree2.insert(3);
		tree2.traverseGraph();
		System.out.println("--------------------");
		tree2.insert(1);
		tree2.traverseGraph();
		System.out.println("--------------------");
		tree2.insert(5);
		tree2.traverseGraph();
		System.out.println("--------------------");
		tree2.insert(7);
		tree2.traverseGraph();
		System.out.println("--------------------");
		tree2.insert(6);
		tree2.traverseGraph();
		System.out.println("--------------------");
		tree2.insert(8);
		tree2.traverseGraph();
		System.out.println("--------------------");
		tree2.insert(9);
		tree2.traverseGraph();
		System.out.println("--------------------");
		tree2.insert(10);
		tree2.traverseGraph();
		System.out.println("--------------------");

		System.out.println("*********************************************************");

	}

}
