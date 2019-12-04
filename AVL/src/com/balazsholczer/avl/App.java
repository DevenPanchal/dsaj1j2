package com.balazsholczer.avl;

public class App {

	/* Create more trees and verify results at
	https://www.cs.usfca.edu/~galles/visualization/AVLtree.html
	
	and https://visualgo.net/bn/bst
	
	*/
	public static void main(String[] args) {

		Tree avl = new AvlTree();

		avl.insert(10);
		avl.insert(15);
		avl.insert(5);
		avl.insert(6);

		avl.delete(15);

		System.out.println("-----------Pre Order Traversal------------");
		avl.preOrdertraverse();
		System.out.println("-----------In Order Traversal-------------");
		avl.inOrdertraverse();

		System.out.println("-----------------Constructing Second Tree---------------------------------------------");

		Tree avl2 = new AvlTree();

		avl2.insert(10);
		avl2.insert(20);
		avl2.insert(30);
		avl2.insert(40);
		avl2.insert(50);
		avl2.insert(25);

		// @formatter:off
		
		 /* The constructed AVL Tree would be 
        30 
       /  \ 
     20   40 
    /  \     \ 
   10  25    50 
   */
		// @formatter:on
		
		System.out.println("-----------Pre Order Traversal------------");
		avl2.preOrdertraverse();
		System.out.println("-----------In Order Traversal-------------");
		avl2.inOrdertraverse();
		
		
		avl2.insert(28);
		avl2.insert(27);
		
		System.out.println("-----------Pre Order Traversal------------");
		avl2.preOrdertraverse();
		System.out.println("-----------In Order Traversal-------------");
		avl2.inOrdertraverse();
		
		avl2.delete(40);
		System.out.println("-----------Pre Order Traversal------------");
		avl2.preOrdertraverse();
		System.out.println("-----------In Order Traversal-------------");
		avl2.inOrdertraverse();
		
		
	}

}
