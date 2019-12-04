package com.balazsholczer.bst;

public class App {

	public static void main(String[] args) {

		// O(N) OR O(logN)
		Tree<Person> bst = new BinarySearchTree<>();
		bst.insert(new Person("Adam", 27));
		bst.insert(new Person("Kevin", 13));
		bst.insert(new Person("Joe", 67));
		bst.insert(new Person("Michael", 2));
		bst.insert(new Person("Smith", 11));

		System.out.println();
		System.out.println("The Max is " + bst.getMaxValue());
		System.out.println();
		System.out.println("The Min is " + bst.getMinValue());
		System.out.println();

		System.out.println("The Pre order traversal which gives the topologically sorted tree is ");
		bst.traversal("pre");
		System.out.println();

		System.out.println("The In order traversal which retrieves data in sorted order is ");
		bst.traversal("in");
		System.out.println();

		System.out.println("The Out of order traversal which retrieves data in reverse sorted order is ");
		bst.traversal("out");
		System.out.println();

		System.out.println("The Post order traversal is ");
		bst.traversal("post");
		System.out.println();

		Person data = new Person("whoever", 13);// since the compareTo method in Person takes only age into
												// consideration, it doesn't matter what the name of the person is. Kind
												// of weird but..will change this when I can thing of something better
		bst.delete(data);
		System.out.println("The In order traversal which retrieves data in sorted order is ");
		bst.traversal("in");
		System.out.println();

		System.out.println("The Pre order traversal which gives the topologically sorted tree is ");
		bst.traversal("pre");
		System.out.println();

		
		bst.insert(new Person("Sam", 38));
		bst.insert(new Person("Pete", 45));
		bst.insert(new Person("John", 76));
		bst.insert(new Person("Sanjay", 29));
		
		System.out.println("The In order traversal which retrieves data in sorted order is ");
		bst.traversal("in");
		System.out.println();

		System.out.println("The Pre order traversal which gives the topologically sorted tree is ");
		bst.traversal("pre");
		System.out.println();
	
		Person data2 = new Person("someone", 67);
		bst.delete(data2);
		
		System.out.println("The In order traversal which retrieves data in sorted order is ");
		bst.traversal("in");
		System.out.println();

		System.out.println("The Pre order traversal which gives the topologically sorted tree is ");
		bst.traversal("pre");
		System.out.println();
		
		// @formatting:off

		/*
		 * Tree traversal https://en.wikipedia.org/wiki/Tree_traversal Pre-order
		 * (NLR)[edit] ===================== Check if the current node is empty or null.
		 * Display the data part of the root (or current node). Traverse the left
		 * subtree by recursively calling the pre-order function. Traverse the right
		 * subtree by recursively calling the pre-order function.
		 * 
		 * The pre-order traversal is a topologically sorted one, because a parent node
		 * is processed before any of its child nodes is done.
		 * 
		 * 
		 * In-order (LNR)[edit] ==================== Check if the current node is empty
		 * or null. Traverse the left subtree by recursively calling the in-order
		 * function. Display the data part of the root (or current node). Traverse the
		 * right subtree by recursively calling the in-order function.
		 * 
		 * In a binary search tree, in-order traversal retrieves data in sorted
		 * order.[4]
		 * 
		 * 
		 * Out-order (RNL)[edit] ===================== Check if the current node is
		 * empty or null. Traverse the right subtree by recursively calling the
		 * out-order function. Display the data part of the root (or current node).
		 * Traverse the left subtree by recursively calling the out-order function.
		 * 
		 * In a binary search tree, out-order traversal retrieves data in reverse sorted
		 * order.
		 * 
		 * 
		 * 
		 * Post-order (LRN)[edit] ====================== Check if the current node is
		 * empty or null. Traverse the left subtree by recursively calling the
		 * post-order function. Traverse the right subtree by recursively calling the
		 * post-order function. Display the data part of the root (or current node).
		 * 
		 * The trace of a traversal is called a sequentialisation of the tree. The
		 * traversal trace is a list of each visited root. No one sequentialisation
		 * according to pre-, in- or post-order describes the underlying tree uniquely.
		 * Given a tree with distinct elements, either pre-order or post-order paired
		 * with in-order is sufficient to describe the tree uniquely. However, pre-order
		 * with post-order leaves some ambiguity in the tree structure.[5]
		 */

		// @formatting:on

	}
}
