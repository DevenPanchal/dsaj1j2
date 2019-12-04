package com.balazsholczer.bst;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;

	@Override
	public T getMaxValue() {

		if (root == null)
			return null;

		return getMax(root);
	}

	@Override
	public T getMinValue() {

		if (root == null)
			return null;

		return getMin(root);
	}

	private T getMax(Node<T> node) {

		if (node.getRightChild() != null) {
			return getMax(node.getRightChild());
		}
		// the moment we find that the node has not child, return its data
		return node.getData();
	}

	private T getMin(Node<T> node) {

		if (node.getLeftChild() != null) {
			return getMin(node.getLeftChild());
		}
		// the moment we find that the node has not child, return its data
		return node.getData();
	}

	@Override
	public void insert(T data) {

		if (root == null) {
			root = new Node<T>(data);
		} else {
			insertNode(data, root);
		}
	}

	private void insertNode(T newData, Node<T> node) {

		// At a particular juncture,
		// if less(<) then left

		if (newData.compareTo(node.getData()) < 0) {
			// if no child then insert as left child
			if (node.getLeftChild() != null) {
				insertNode(newData, node.getLeftChild());
			} else {
				// else continue
				Node<T> newNode = new Node<T>(newData);
				node.setLeftChild(newNode);
			}
		}
		// else(>,=) right
		else {
			// if no child then insert as right child
			if (node.getRightChild() != null) {
				insertNode(newData, node.getRightChild());
			} else {
				// else continue
				Node<T> newNode = new Node<T>(newData);
				node.setRightChild(newNode);
			}
		}
	}

	@Override
	public void traversal(String type) {
		if (root != null) {
			switch (type) {
			case "pre": {
				preOrderTraversal(root);
				break;
			}
			case "in": {
				inOrderTraversal(root);
				break;
			}
			case "out": {
				outOfOrderTraversal(root);
				break;
			}
			case "post": {
				postOrderTraversal(root);
				break;
			}

			}
		}
	}

	private void preOrderTraversal(Node<T> node) {

		/*
		 * Instead of checking leftChild and rightChild !=null later you could also do
		 * if (node == null) return;
		 * 
		 * here.
		 */

		System.out.print(node + "  -->  ");

		if (node.getLeftChild() != null)
			preOrderTraversal(node.getLeftChild());

		if (node.getRightChild() != null)
			preOrderTraversal(node.getRightChild());

	}

	private void inOrderTraversal(Node<T> node) {

		/*
		 * Instead of checking leftChild and rightChild !=null later you could also do
		 * if (node == null) return;
		 * 
		 * here.
		 */

		// 1. at any particular point i.e node, what should you do? First try to go to
		// its left child.
		if (node.getLeftChild() != null)
			inOrderTraversal(node.getLeftChild());

		// 2. if node has no left child, then print the node
		System.out.print(node + "  -->  ");

		// 3. then go to the node's right child
		if (node.getRightChild() != null)
			inOrderTraversal(node.getRightChild());

		// the same process (1,2,3) repeats with any node that is called
	}

	private void outOfOrderTraversal(Node<T> node) {

		/*
		 * Instead of checking leftChild and rightChild !=null later you could also do
		 * if (node == null) return;
		 * 
		 * here.
		 */

		if (node.getRightChild() != null)
			outOfOrderTraversal(node.getRightChild());

		System.out.print(node + "  -->  ");

		if (node.getLeftChild() != null)
			outOfOrderTraversal(node.getLeftChild());

	}

	private void postOrderTraversal(Node<T> node) {

		/*
		 * Instead of checking leftChild and rightChild !=null later you could also do
		 * if (node == null) return;
		 * 
		 * here.
		 */

		if (node.getLeftChild() != null)
			postOrderTraversal(node.getLeftChild());

		if (node.getRightChild() != null)
			postOrderTraversal(node.getRightChild());

		System.out.print(node + "  -->  ");

	}

	private Node<T> delete(Node<T> node, T data) {

		if (node == null)
			return node;

		if (data.compareTo(node.getData()) < 0) {
			// look how we use setLeftChild method here + keep moving left
			node.setLeftChild(delete(node.getLeftChild(), data));
		} else if (data.compareTo(node.getData()) > 0) {
			// look how we use setRightChild method here + keep moving right
			node.setRightChild(delete(node.getRightChild(), data));
		} else

		// we have found the node we want to remove !!!
		{

			// if the current node has no children, you can remove it right away.
			if (node.getLeftChild() == null && node.getRightChild() == null) {
				System.out.println("Removing a leaf node...");
				return null; // return null so that the calling node can set its child reference
								// to null. Since the call to delete comes from a
								// setLeftChild/setRightChild method. This is important because we are taking
								// care of the structure of the
								// tree
			}

			// if the current node has 1 child
			if (node.getLeftChild() == null) {
				System.out.println("Removing the right child...");
				Node<T> tempNode = node.getRightChild();
				node = null; // delete current Node
				return tempNode; // return the remaining right child node so the grandparent (of tempNode) node
									// can set its child
									// reference to it.Since the call to delete comes from a
									// setLeftChild/setRightChild method

				// if the current node has 1 child
			} else if (node.getRightChild() == null) {
				System.out.println("Removing the left child...");
				Node<T> tempNode = node.getLeftChild();
				node = null; // delete current Node
				return tempNode; // return the remaining left child node so the grandparent (of tempNode) node
									// can set its child
				// reference to it.Since the call to delete comes from a
				// setLeftChild/setRightChild method
			}

			// this is the node with two children case !!!
			// swap the matching node with its (Inorder i.e Sorted Data) predecessor i.e
			// tempNode
			// then delete the current node in the new position treating it as 1 child case
			System.out.println("Removing item with two children...");

			Node<T> tempNode = getPredecessor(node.getLeftChild()); // Argument is left child of current node i.e left
																	// subtree. getPredecessor searches the rightmost
																	// node i.e largest node of the left subtree.

			node.setData(tempNode.getData()); // at this point we have overwritten the data of predecessor into the
												// current node.
			// no actual copying of data required from node to tempNode because that
			// placeholder itself is going to be deleted in the next step. So doesn't matter
			// what data it has.node's or tempNode's.
			// The important step was that we could copy the predecessor's data into the
			// node. That is important for the structure of the tree.
			
			/*  i.e we should I have ideally done this-
			 * Node<T>tempNode2.setData(node.getData());
			 * Node<T> tempNode = getPredecessor(node.getLeftChild());
			 * node.setData(tempNode.getData());   //node gets predecessor's data
			 * tempNode.setData(tempNode2.getData());  // predecessor gets node's data
			 * node.setLeftChild(delete(node.getLeftChild(), tempNode.getData()));
			 * 
			 * */

			node.setLeftChild(delete(node.getLeftChild(), tempNode.getData()));

		}

		return node; //returns new root when recursion folds back (if it has changed), it will not be used. Other returns from inside are useful. //here, in this case we return the current node in the loop. //return type was needed for the recursive calls. hence the return requirement.
	}

	// searches rightmost node i.e largest node.
	private Node<T> getPredecessor(Node<T> node) {

		if (node.getRightChild() != null)
			return getPredecessor(node.getRightChild());

		System.out.println("Predecessor is: " + node);
		return node;
	}

	@Override
	public void delete(T data) {

		if (root != null) 
			root = delete(root, data);
	}

}
