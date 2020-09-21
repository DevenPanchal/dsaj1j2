package com.interview.tree;

import com.interview.tree.BTree.Node;

class Node {
	// 2) A B-Tree is defined by the term minimum degree ‘t’. The value of t depends
	// upon disk block size.
	int n; // Current number of keys or the Size of Btree.
	int dataArray[] = new int[2 * T - 1]; // 4) All nodes (including root) may contain at most 2t – 1 keys.
	Node[] childrenNodeArray = new Node[2 * T]; // 5) Number of children of a node is equal to the number of keys in
												// it plus 1. i.e (2t-1)+1=2t
	boolean isLeaf; // Is true when node is leaf i.e it has no children. Otherwise false

	// 3) Every node except root must contain at least t-1 keys. Root may contain
	// minimum 1 key.

	// Finally the function that actually inserts data
	public void insertKey(int data, Node r1, Node r2) {
		int i = n - 1;
		while (i >= 0 && data < dataArray[i]) {
			dataArray[i + 1] = dataArray[i];
			i--;
		}
		dataArray[i + 1] = data;
		int j = n;
		while (j > i + 1) {
			childrenNodeArray[j + 1] = childrenNodeArray[j];
			j--;
		}
		childrenNodeArray[j] = r1;
		childrenNodeArray[j + 1] = r2;
		n++;
	}

	// returns new BTreeNode node initialized with int data that was passed to
	// create it.
	public static Node newNode(int data) {
		Node node = new Node();
		node.dataArray[0] = data;
		node.isLeaf = true;
		node.n = 1;
		return node;
	}

	// returns new empty BTreeNode node
	public static Node newNode() {
		Node node = new Node();
		node.isLeaf = true;
		node.n = 0;
		return node;
	}

	public boolean isFull() {
		// returns true if number of current nodes i.e n = 2T-1
		return 2 * T - 1 == n;
	}
}