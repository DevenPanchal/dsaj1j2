package com.interview.tree;

/**
 * http://www.geeksforgeeks.org/b-tree-set-1-insert-2/
 * http://www.geeksforgeeks.org/b-tree-set-1-introduction-2/
 */

public class BTree {
	private Node root = null;
	private static int T = 2;// we can change the degree to something else also.

	public void traversal() {

		if (root == null) {
			System.out.println("There is no tree!");
		} else {
			traversal(root);
		}
	}

	private void traversal(Node node) {

		// For loop because we have n+1 children here, and n keys here - this was not
		// required when traversing a normal BST
		// the for loop will help us traverse n+1 children and also print n keys.
		// But this for loop is common and so we decided it should go uptil n.
		// So since there are n+1 children, the last child is taken care of outside the
		// loop.
		for (int i = 0; i < node.currentSizeOfNode; i++) {

			// LN traversal like in LNR traversal
			// if the node is not a leaf, traverse its children nodes
			if (!node.isLeaf) {
				traversal(node.childrenNodes[i]); // child node becomes the new root.
			}

			// if the node is a leaf then, print its elements in order.
			System.out.print(node.dataArray[i] + " ");
		}

		if (!node.isLeaf) {
			traversal(node.childrenNodes[node.currentSizeOfNode]);
		}
	}

	public boolean search(int data) {
		return search(root, data);
	}

	public boolean search(Node root, int incomingData) {
		// local variable 'i' will be used to iterate over the keys.
		int i = 0;

		// CAN YOU REWRITE THIS WITH FOR LOOP ?????? Yes we can. call pass in another
		// argument into traverse function to compare with every element.
		// while i is less than number of keys, and the key is less than data, move to
		// next key in the current node and increment 'i'. This i will be used further
		// down to select the correct child.
		while (i < root.currentSizeOfNode && root.dataArray[i] < incomingData) {
			i++;
		}

		// while i is less than number of keys, and the key is equal to the data, return
		// true. Ideally we want to return the block i.e chunk i.e node here.
		if (i < root.currentSizeOfNode && root.dataArray[i] == incomingData) {
			return true;
		}

		if (root.isLeaf) {
			return false; // if we do not find our data and have reached the last child then return false
							// which signifies that the data was not found. Note: Even the last node was
							// searched for data.
		}

		// if we could not find the data in the root node, then move to the correct
		// child, since 'i' has the correct value
		return search(root.childrenNodes[i], incomingData);
	}

	public void insert(int incomingData) {
		if (root == null) {
			root = Node.newNode(incomingData);
			return;
		}
		// else call a sophisticated insert that always is supposed to return
		// SplitResult - irrespective of whether there is a split or not.

		SplitResult sr = insert(root, incomingData);

		// if the Splitresult was null, then there was a normal insertion. Else handle
		// the SplitResult below
		if (sr != null) {
			Node newRoot = Node.newNode();
			// new root's/node's number of keys becomes 1 because sr.c will be its key
			newRoot.currentSizeOfNode = 1;
			newRoot.isLeaf = false; // new root/node is no longer the child
			newRoot.dataArray[0] = sr.c;
			newRoot.childrenNodes[0] = sr.r1;// r1 and r2 are now the children of the new root
			newRoot.childrenNodes[1] = sr.r2;
			root = newRoot; // newRoot is now the root
		}
	}

	private SplitResult insert(Node root, int data) {

		if (root.isLeaf) {
			// childless node
			if (!root.isFull()) {
				// if not full, insert data and return null
				root.insertKey(data, null, null);
				return null; // we could insert without any split etc. so return SplitResult as null.
			} else {
				// else splitting the node is needed.
				SplitResult sr = splitNode(root, data, null, null);
				return sr;
			}
		} else {
			// if it is node with children that is going to get split, then the splitting
			// will have to handle its children also- in the sense that they will also be
			// splitly assigned to its new parent.
			int i = 0;
			// There are n keys and n+1 children, traverse through n keys
			// and first n children
			for (; i < root.currentSizeOfNode; i++) {
				if (data <= root.dataArray[i]) {
					// if data is less than the key, go to that numbered corresponding child, and
					// recurse on insert
					SplitResult sr = insert(root.childrenNodes[i], data);
					if (sr == null) { // SplitResult can be null here, when it hits a childless node on the next
										// iteration above which is not full. See the first 'if condition.'
						return null; // return null in that case
					} else { // if we get back a SplitResult, then make insertKey call
						if (!root.isFull()) {
							// if not full, insert data and return null
							root.insertKey(sr.c, sr.r1, sr.r2);
							return null;
						} else {
							// else splitting the node is needed again.
							SplitResult sr1 = splitNode(root, sr.c, sr.r1, sr.r2);
							return sr1;
						}
					}
				}
			}
			// Subtree rooted with last child i.e (n+1)th child
			if (i == root.currentSizeOfNode) {
				SplitResult sr = insert(root.childrenNodes[i], data);
				if (sr == null) { // SplitResult can be null here, when it hits a childless node on the next
					// iteration above which is not full. See the first 'if condition.'
					return null; // return null in that case

				} else { // if we get back a SplitResult, then make insertKey call
					if (!root.isFull()) {
						// if not full, insert data and return null
						root.insertKey(sr.c, sr.r1, sr.r2);
						return null;
					} else {
						// else splitting the node is needed again.
						SplitResult sr1 = splitNode(root, sr.c, sr.r1, sr.r2);
						return sr1;
					}
				}
			}
		}
		return null; // return null in other cases
	}

	// returns SplitResult which contains centerNode which will be promoted i.e c,
	// and 2 children that come out of splitting i.e r1,r2
	private SplitResult splitNode(Node node, int data, Node nr1, Node nr2) {
		int c = node.dataArray[node.currentSizeOfNode / 2]; // c becomes the centermost element of the current node
															// without adding anything.

		// Then 2 new nodes are created
		Node r1 = Node.newNode();
		Node r2 = Node.newNode();

		// Initializing current sizes of the new nodes. Note: Max size of node will be
		// standard depending on 'T'
		r1.currentSizeOfNode = node.currentSizeOfNode / 2; // half goes here
		r2.currentSizeOfNode = node.currentSizeOfNode - node.currentSizeOfNode / 2 - 1; // remaining half minus the 1 c
																						// goes here
		if (!node.isLeaf) {
			// if the node was not a leaf, the 2 new nodes coming out of splitting will also
			// definitely not be leaf nodes
			r1.isLeaf = false;
			r2.isLeaf = false;
		}

		int i = 0;

		// copy over half data and half its child nodes from the current node to r1.
		for (; i < node.currentSizeOfNode / 2; i++) {
			r1.dataArray[i] = node.dataArray[i];
			r1.childrenNodes[i] = node.childrenNodes[i];
		}
		r1.childrenNodes[i] = node.childrenNodes[i]; // copy over even the (n+1)th child of the half.

		// now increment i
		// we will now copy over the remaining half of the data from current node into
		// r2
		i = node.currentSizeOfNode / 2 + 1;
		int j = 0;
		for (; i < node.currentSizeOfNode; i++, j++) {
			r2.dataArray[j] = node.dataArray[i];
			r2.childrenNodes[j] = node.childrenNodes[i];
		}
		r2.childrenNodes[j] = node.childrenNodes[i]; // copy over even the (n+1)th child of the half.

		// This was proactive splitting. Hence the data cannot ever become c. The
		// initial median already became c.
		// The data will have to go into r1 or r2.
		if (data < c) {
			r1.insertKey(data, nr1, nr2);
		} else {
			r2.insertKey(data, nr1, nr2);
		}
		SplitResult sr = new SplitResult();
		sr.c = c;
		sr.r1 = r1;
		sr.r2 = r2;
		return sr;
	}

	class SplitResult {
		Node r1;
		Node r2;
		int c;
	}

	static class Node {
		// 2) A B-Tree is defined by the term minimum degree ‘t’. The value of t depends
		// upon disk block size.
		int currentSizeOfNode; // Current number of keys in the node. How full is the dataArray.
		int maxSizeOfNode = 2 * T - 1;
		// maxSizeOfNode = 2*T -1
		// M= maxSizeOfNode = maxSizeOfNode+1= 2*T-1+1= 2*T
		// i.e maximum number of child nodes = M
		// and max number of keys in a node = M-1
		int dataArray[] = new int[maxSizeOfNode]; // 4) All nodes (including root) may contain at most 2t – 1 keys.
		Node[] childrenNodes = new Node[maxSizeOfNode + 1]; // 5) Number of children of a node is equal to the
															// number of keys in it plus 1. i.e (2t-1)+1=2t
		boolean isLeaf; // Is true when node is leaf i.e it has no children. Otherwise false

		// 3) Every node except root must contain at least t-1 keys. Root may contain
		// minimum 1 key.

		// Finally the function that actually inserts data And Handles children Nodes
		// reconnections
		public void insertKey(int incomingData, Node r1, Node r2) {
			int i = currentSizeOfNode - 1;
			while (i >= 0 && incomingData < dataArray[i]) {
				dataArray[i + 1] = dataArray[i];
				i--;
			}
			dataArray[i + 1] = incomingData;

			int j = currentSizeOfNode;
			while (j > i + 1) {
				childrenNodes[j + 1] = childrenNodes[j];
				j--;
			}
			childrenNodes[j] = r1;
			childrenNodes[j + 1] = r2;
			currentSizeOfNode++;
		}

		// returns new BTreeNode node initialized with int data that was passed to
		// create it.
		public static Node newNode(int data) {
			Node node = new Node();
			node.dataArray[0] = data;
			node.isLeaf = true;
			node.currentSizeOfNode = 1;
			return node;
		}

		// returns new empty BTreeNode node
		public static Node newNode() {
			Node node = new Node();
			node.isLeaf = true;
			node.currentSizeOfNode = 0;
			return node;
		}

		public boolean isFull() {
			// returns true if number of current nodes i.e n = 2T-1
			return 2 * T - 1 == currentSizeOfNode;
		}
	}

	public static void main(String args[]) {
		BTree bTree = new BTree();
		bTree.insert(5);
		bTree.insert(4);
		bTree.insert(3);
		bTree.insert(2);
		bTree.insert(1);
		bTree.insert(6);
		bTree.insert(11);
		bTree.insert(13);
		bTree.insert(8);
		bTree.insert(7);
		bTree.insert(10);
		bTree.insert(9);
		bTree.insert(28);
		bTree.insert(22);
		bTree.insert(12);
		bTree.insert(18);
		bTree.insert(16);
		bTree.traversal();
		System.out.print(bTree.search(28));
		System.out.print(bTree.search(11));
		System.out.print(bTree.search(5));
		System.out.print(bTree.search(21));
		System.out.print(bTree.search(3));
		System.out.print(bTree.search(4));
		System.out.print(bTree.search(14));
	}
}