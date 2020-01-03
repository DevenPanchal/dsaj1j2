package com.interview.tree;

/**
 * http://www.geeksforgeeks.org/b-tree-set-1-insert-2/
 * http://www.geeksforgeeks.org/b-tree-set-1-introduction-2/
 */
public class BTree {
	private BTreeNode root = null;
	private static int T = 2;

	public void traverse() {
		traverse(root);
	}

	// Function to traverse all nodes in a subtree rooted with this node
	private void traverse(BTreeNode root) {

		// There are n keys and n+1 children, traverse through n keys
		// and first n children
		for (int i = 0; i < root.n; i++) {

			// If this is not leaf, then before printing key[i],
			// traverse the subtree rooted with child C[i].
			if (!root.isLeaf) {
				traverse(root.child[i]);
			}
			System.out.print(root.keys[i] + " ");
		}
		// Print the subtree rooted with last child i.e (n+1)th child
		if (!root.isLeaf) {
			traverse(root.child[root.n]);
		}
	}

	public boolean search(int data) {
		return search(root, data);
	}

	public boolean search(BTreeNode root, int data) {
		// local variable 'i' will be used to iterate over the keys.
		int i = 0;

		// while i is less than number of keys, and the key is less than data, move to
		// next key in the current node and increment 'i'. This i will be used further
		// down to select the correct child.
		while (i < root.n && root.keys[i] < data) {
			i++;
		}

		// while i is less than number of keys, and the key is equal to the data, return
		// true. Ideally we want to return the block i.e chunk i.e node here.
		if (i < root.n && root.keys[i] == data) {
			return true; // shouldn't this be return root?
		}

		if (root.isLeaf) {
			return false; // if we do not find our data and have reached the last child then return false
							// which signifies that the data was not found. Note: Even the last node was
							// searched for data.
		}

		// if we could not find the data in the root node, then move to the correct
		// child, since 'i' has the correct value
		return search(root.child[i], data);
	}

	public void insert(int data) {
		if (root == null) {
			root = BTreeNode.newNode(data);
			return;
		}
		SplitResult sr = insert(root, data);
		if (sr != null) {
			BTreeNode newRoot = BTreeNode.newNode();
			// new root's/node's number of keys becomes 1 because sr.c will be its key
			newRoot.n = 1;
			newRoot.isLeaf = false; // new root/node is no longer the child
			newRoot.keys[0] = sr.c;
			newRoot.child[0] = sr.r1;// r1 and r2 are now the children of the new root
			newRoot.child[1] = sr.r2;
			root = newRoot; // newRoot is now the root
		}
	}

	private SplitResult insert(BTreeNode root, int data) {

		if (root.isLeaf) {
			// childless node
			if (!root.isFull()) {
				// if not full, insert data and return null
				root.insertKey(data, null, null);
				return null;
			} else {
				// else splitting the node is needed.
				SplitResult sr = splitNode(root, data, null, null);
				return sr;
			}
		} else {
			// nodes with children
			int i = 0;
			// There are n keys and n+1 children, traverse through n keys
			// and first n children
			for (; i < root.n; i++) {
				if (data <= root.keys[i]) {
					SplitResult sr = insert(root.child[i], data);
					if (sr == null) {
						return null;
					} else {
						if (!root.isFull()) {
							// if not full, insert data and return null
							root.insertKey(sr.c, sr.r1, sr.r2);
							return null;
						} else {
							// else splitting the node is needed.
							SplitResult sr1 = splitNode(root, sr.c, sr.r1, sr.r2);
							return sr1;
						}
					}
				}
			}
			// Subtree rooted with last child i.e (n+1)th child
			if (i == root.n) {
				SplitResult sr = insert(root.child[i], data);
				if (sr == null) {
					return null;

				} else {
					if (!root.isFull()) {
						root.insertKey(sr.c, sr.r1, sr.r2);
						return null;
					} else {
						SplitResult sr1 = splitNode(root, sr.c, sr.r1, sr.r2);
						return sr1;
					}
				}
			}
		}
		return null;
	}

	private SplitResult splitNode(BTreeNode node, int data, BTreeNode nr1, BTreeNode nr2) {
		int c = node.keys[node.n / 2];
		BTreeNode r1 = BTreeNode.newNode();
		BTreeNode r2 = BTreeNode.newNode();
		r1.n = node.n / 2;
		r2.n = node.n - node.n / 2 - 1;
		if (!node.isLeaf) {
			// if the node was not a leaf, the 2 new nodes coming out of splitting will also
			// definitely not be leaf nodes
			r1.isLeaf = false;
			r2.isLeaf = false;
		}
		int i = 0;
		for (; i < node.n / 2; i++) {
			r1.keys[i] = node.keys[i];
			r1.child[i] = node.child[i];
		}
		r1.child[i] = node.child[i];
		i = node.n / 2 + 1;
		int j = 0;
		for (; i < node.n; i++, j++) {
			r2.keys[j] = node.keys[i];
			r2.child[j] = node.child[i];
		}
		r2.child[j] = node.child[i];
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
		BTreeNode r1;
		BTreeNode r2;
		int c;
	}

	static class BTreeNode {
		// 2) A B-Tree is defined by the term minimum degree ‘t’. The value of t depends
		// upon disk block size.
		int n; // Current number of keys
		int keys[] = new int[2 * T - 1]; // 4) All nodes (including root) may contain at most 2t – 1 keys.
		BTreeNode[] child = new BTreeNode[2 * T]; // 5) Number of children of a node is equal to the number of keys in
													// it plus 1. i.e (2t-1)+1=2t
		boolean isLeaf; // Is true when node is leaf i.e it has no children. Otherwise false

		// 3) Every node except root must contain at least t-1 keys. Root may contain
		// minimum 1 key.

		public void insertKey(int data, BTreeNode r1, BTreeNode r2) {
			int i = n - 1;
			while (i >= 0 && data < keys[i]) {
				keys[i + 1] = keys[i];
				i--;
			}
			keys[i + 1] = data;
			int j = n;
			while (j > i + 1) {
				child[j + 1] = child[j];
				j--;
			}
			child[j] = r1;
			child[j + 1] = r2;
			n++;
		}

		// returns new BTreeNode node initialized with int data that was passed to
		// create it.
		public static BTreeNode newNode(int data) {
			BTreeNode node = new BTreeNode();
			node.keys[0] = data;
			node.isLeaf = true;
			node.n = 1;
			return node;
		}

		// returns new empty BTreeNode node
		public static BTreeNode newNode() {
			BTreeNode node = new BTreeNode();
			node.isLeaf = true;
			node.n = 0;
			return node;
		}

		public boolean isFull() {
			// returns true if number of current nodes i.e n = 2T-1
			return 2 * T - 1 == n;
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
		bTree.traverse();
		System.out.print(bTree.search(28));
		System.out.print(bTree.search(11));
		System.out.print(bTree.search(5));
		System.out.print(bTree.search(21));
		System.out.print(bTree.search(3));
		System.out.print(bTree.search(4));
		System.out.print(bTree.search(14));
	}
}