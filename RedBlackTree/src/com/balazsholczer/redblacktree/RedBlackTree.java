package com.balazsholczer.redblacktree;

import com.balazsholczer.redblacktree.Node;

public class RedBlackTree {

	private Node root;

	public void traverseGraph() {
		if (this.root != null) {
			traverseInOrder(root);
		}
	}

	public void insert(int data) {

		Node node = new Node(data);

		root = insertIntoTree(root, node);

		System.out.println("Added RED " + data);
		fixViolations(node);
	}

	private Node insertIntoTree(Node root, Node node) {

		if (root == null)
			return node;

		if (node.getData() < root.getData()) {
			root.setLeftChild(insertIntoTree(root.getLeftChild(), node));
			// always set parent too
			root.getLeftChild().setParent(root);

		} else if (node.getData() > root.getData()) {
			root.setRightChild(insertIntoTree(root.getRightChild(), node));
			// always set parent too
			root.getRightChild().setParent(root);
		}

		return root;
	}

	private void fixViolations(Node node) {

		Node parentNode = null;
		Node grandParentNode = null;

		// Traverse N-N line in the pic
		while (node != root && node.getColor() != NodeColor.BLACK && node.getParent().getColor() == NodeColor.RED) {

			parentNode = node.getParent();
			grandParentNode = node.getParent().getParent();

			// we will implement uncle RED, uncle BLACK LR and uncle BLACK LL cases in this
			// if loop
			if (parentNode == grandParentNode.getLeftChild()) {

				Node uncle = grandParentNode.getRightChild();

				// given node x's parent is a left child + uncle is red --> only recoloring
				if (uncle != null && uncle.getColor() == NodeColor.RED) {
					System.out.println("Recolouring " + grandParentNode + " + " + parentNode + " + " + uncle);
					grandParentNode.setColor(NodeColor.RED);
					parentNode.setColor(NodeColor.BLACK);
					uncle.setColor(NodeColor.BLACK);
					node = grandParentNode; // this will be the x after the recoloring because we have to check whether
					// the properties are violated or not
					// Recur for g i.e start checking violation starting from g. So g is the new x
					// to start checking.
					// WITH RECOLORING, ALWAYS CHECK FOR VIOLATIONS IN OTHER PARTS OF THE TREE
				} else {

					// if uncle is BLACK - LR case (with if too) and then LL case(without if)
					if (node == parentNode.getRightChild()) {
						leftRotate(parentNode);
						// the new node to start rechecking is the parent node, which is now at the
						// bottom. And the new parentNode pointer is node's parent.
						node = parentNode;
						parentNode = node.getParent();
					}
					// LR case continues, LL case starts
					rightRotate(grandParentNode);
					System.out.println("Recolouring " + parentNode + " + " + grandParentNode);
					// Swap colors of parent and grandparent
					NodeColor tempColor = parentNode.getColor();
					parentNode.setColor(grandParentNode.getColor());
					grandParentNode.setColor(tempColor);
					node = parentNode;// start rechecking from parent node
					// WITH RECOLORING, ALWAYS CHECK FOR VIOLATIONS IN OTHER PARTS OF THE TREE
				}
			} else {

				// we will implement uncle RED, uncle BLACK RL and uncle BLACK RR cases in this
				// if loop

				Node uncle = grandParentNode.getLeftChild();

				if (uncle != null && uncle.getColor() == NodeColor.RED) {
					System.out.println("Recolouring " + grandParentNode + " + " + parentNode + " + " + uncle);
					grandParentNode.setColor(NodeColor.RED);
					parentNode.setColor(NodeColor.BLACK);
					uncle.setColor(NodeColor.BLACK);
					node = grandParentNode;// this will be the x after the recoloring because we have to check whether
					// the properties are violated or not
					// Recur for g i.e start checking violation starting from g. So g is the new x
					// to start checking.
					// WITH RECOLORING, ALWAYS CHECK FOR VIOLATIONS IN OTHER PARTS OF THE TREE
				} else {

					// if uncle is BLACK - RL case (with if too) and then RR case(without if)
					if (node == parentNode.getLeftChild()) {
						rightRotate(parentNode);
						node = parentNode;
						parentNode = node.getParent();
					}
					// RL case continues, RR case starts
					leftRotate(grandParentNode);
					System.out.println("Recolouring " + parentNode + " + " + grandParentNode);
					// Swap colors of parent and grandparent
					NodeColor tempColor = parentNode.getColor();
					parentNode.setColor(grandParentNode.getColor());
					grandParentNode.setColor(tempColor);
					node = parentNode; // start rechecking from parent node
					// WITH RECOLORING, ALWAYS CHECK FOR VIOLATIONS IN OTHER PARTS OF THE TREE
				}
			}
		}

		// Traverse Y line in the pic
		if (root.getColor() == NodeColor.RED) {
			System.out.println("Recoloring the root " + root + " to BLACK...");
			root.setColor(NodeColor.BLACK);
		}
	}

	// node input will be sometimes parent or sometimes grandparent of x
	private void rightRotate(Node node) { // az input a beszurt node grandparentje
		System.out.println("Rotate right on node " + node);
		Node tempLeftNode = node.getLeftChild();
		Node t = tempLeftNode.getRightChild();

		// **Set 2 way parent child relations between 'node' and t
		node.setLeftChild(t);

		// we will set tempLeftNode as the top node later

		if (node.getLeftChild() != null)
			node.getLeftChild().setParent(node); // set parent for the new incoming left child of 'node'

		// **Set 2 way parent child relations between tempLeftNode and its to-be parent.

		tempLeftNode.setParent(node.getParent()); // set parent of tempNode as the original node's parent

		if (tempLeftNode.getParent() == null) // if now the tempNode has no parent, that means it will be root. i.e
												// original node was root.
			root = tempLeftNode;
		else if (node == node.getParent().getLeftChild())
			node.getParent().setLeftChild(tempLeftNode);
		else
			node.getParent().setRightChild(tempLeftNode);

		// Finally make node as rightChild of tempLeftNode and ** Set Set 2 way parent
		// child relations between tempLeftNode and 'node' that will now become its
		// right child.
		tempLeftNode.setRightChild(node); // After rotation, tempLeftNode is the root
		node.setParent(tempLeftNode);
	}

	// node input will be sometimes parent or sometimes grandparent of x
	// Similar to rightRotate
	private void leftRotate(Node node) { // az input a beszurt node grandparentje
		System.out.println("Rotate left on node " + node);
		Node tempRightNode = node.getRightChild();
		node.setRightChild(tempRightNode.getLeftChild());

		if (node.getRightChild() != null)
			node.getRightChild().setParent(node);

		tempRightNode.setParent(node.getParent());

		if (tempRightNode.getParent() == null)
			root = tempRightNode;
		else if (node == node.getParent().getLeftChild())
			node.getParent().setLeftChild(tempRightNode);
		else
			node.getParent().setRightChild(tempRightNode);

		tempRightNode.setLeftChild(node);
		node.setParent(tempRightNode);
	}

	private void traverseInOrder(Node node) {

		if (node.getLeftChild() != null) {
			traverseInOrder(node.getLeftChild());
		}

		System.out.println(node + " with color: " + node.getColor() + " ->   LeftNode: " + node.getLeftChild()
				+ "   RightNode: " + node.getRightChild());

		if (node.getRightChild() != null) {
			traverseInOrder(node.getRightChild());
		}
	}

	private Node getPredecessor(Node node) {

		Node predecessor = node;

		while (predecessor.getRightChild() != null)
			predecessor = predecessor.getRightChild();

		return predecessor;
	}

	private int height(Node node) {

		if (node == null) {
			return -1;
		}

		return node.getHeight();
	}
}
