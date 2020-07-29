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
			root = insertNode2(data, root);
		}
	}

	@Override
	public void delete(T data) {

		if (root != null)
			root = delete(root, data);
	}

	public Integer getHeight() {
		if (root == null) {
			return -1;
		}

		else {
			int heightOfTree = getHeight(root);
			return heightOfTree;
		}
	}

	Node<T> insertNode2(T newData, Node<T> node) {

		/*
		 * Note: Duplicate keys not allowed. To allow duplicate keys, we could have
		 * added equals sign i.e <= or >= when comparing data with the node.
		 */

		if ((node != null) && (newData.compareTo(node.getData()) < 0)) {
			// go left
			node.setLeftChild(insertNode2(newData, node.getLeftChild()));
		}

		else if ((node != null) && (newData.compareTo(node.getData()) > 0)) {
			// go right
			node.setRightChild(insertNode2(newData, node.getRightChild()));
		}

		else {
			// the node is null, so create the node
			Node<T> newNode = new Node<T>(newData);
			// and return from here itself with the newly made node.
			System.out.println("Inserting node " + newNode);
			return newNode;

		}

		// return the node
		return node;
	}

	private Node<T> delete(Node<T> node, T data) {

		if ((node != null) && (data.compareTo(node.getData()) < 0)) {

			node.setLeftChild(delete(node.getLeftChild(), data));
		} else if ((node != null) && (data.compareTo(node.getData()) > 0)) {

			node.setRightChild(delete(node.getRightChild(), data));
		} else {

			// no matching node found, and reached a leaf null node.In this case just return
			// this node i.e null
			if (node == null) {
				System.out.println("Sorry, no matching node");
				return node;
			}

			// else we found the node we were looking for! Check for 3 deletion cases
			else {

				// we have found the node we want to remove !!!
				// if the current node has no children, you can remove it right away.
				if (node.getLeftChild() == null && node.getRightChild() == null) {
					System.out.println("Removing a leaf node " + node.getData());
					return null;
					/*
					 * return null so that the calling node can set its child reference to null.
					 * Since the call to delete comes from a setLeftChild/setRightChild method. This
					 * is important because we are taking care of the structure of the tree
					 */
				}

				// if the current node has 1 child
				if (node.getLeftChild() == null) {
					System.out.println("Removing node " + node.getData() + " which has only a right child "
							+ node.getRightChild().getData());
					Node<T> tempNode = node.getRightChild();
					node = null; // delete current Node
					return tempNode;
					/*
					 * return the remaining right child node so the grandparent (of tempNode) node
					 * can set its child reference to it.Since the call to delete comes from a
					 * setLeftChild/setRightChild method
					 */

					// if the current node has 1 child
				} else if (node.getRightChild() == null) {
					System.out.println("Removing node " + node.getData() + " which has only a left child "
							+ node.getLeftChild().getData());
					Node<T> tempNode = node.getLeftChild();
					node = null; // delete current Node
					return tempNode;
					/*
					 * return the remaining left child node so the grandparent (of tempNode) node
					 * can set its child reference to it.Since the call to delete comes from a
					 * setLeftChild/setRightChild method
					 */
				}

				/*
				 * this is the node with two children case !!! swap the matching node with its
				 * (Inorder i.e Sorted Data) predecessor i.e tempNode, then delete the current
				 * node in the new position treating it as 1 child case
				 */
				System.out.println("Removing node " + node.getData() + " which has 2 children "
						+ node.getLeftChild().getData() + "and " + node.getRightChild().getData());

				Node<T> tempNode = getPredecessor(node.getLeftChild());
				/*
				 * Argument is left child of current node i.e left subtree. getPredecessor
				 * searches the rightmost node i.e largest node of the left subtree.
				 */

				node.setData(tempNode.getData());

			// @formatter:off
			/*
			 * At this point we have overwritten the data of predecessor into the current
			 * node. no actual copying of data required from node to tempNode because that
			 * placeholder itself is going to be deleted in the next step. So doesn't matter
			 * what data it has.node's or tempNode's. The important step was that we could
			 * copy the predecessor's data into the node. That is important for the
			 * structure of the tree.
			 * 
			 * 
			 * i.e we should have ideally done this-
			 * Node<T>tempNode2.setData(node.getData()); 
			 * Node<T> tempNode = getPredecessor(node.getLeftChild()); 
			 * node.setData(tempNode.getData()); //node gets predecessor's data 
			 * tempNode.setData(tempNode2.getData()); // predecessor gets node's data 
			 * node.setLeftChild(delete(node.getLeftChild(),tempNode.getData()));
			 * 
			 */

			// @formatter:on

				node.setLeftChild(delete(node.getLeftChild(), tempNode.getData()));

			}
		}

		return node; // returns the current node at each stage (except the last stage where it
						// returns custom things acc. to case. Also returns the root node outside this
						// function at the end. Also returns null in case node was not found. Thats why
						// we commented out the node==null case above.)
	}

	// searches rightmost node i.e largest node.
	private Node<T> getPredecessor(Node<T> node) {

		if (node.getRightChild() != null)
			return getPredecessor(node.getRightChild());

		System.out.println("Predecessor is: " + node);
		return node;
	}

	public Integer getHeight(Node node) {

		// node has 2 children
		if (node.getLeftChild() != null && node.getRightChild() != null) {
			node.setLargestLengthPathinSubtreeRootedAtThisNode(

					Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())) + 1);

		}
		// node has 1 child

		if (node.getLeftChild() != null && node.getRightChild() == null) {
			node.setLargestLengthPathinSubtreeRootedAtThisNode(getHeight(node.getLeftChild()) + 1);

		} else if (node.getLeftChild() == null && node.getRightChild() != null) {
			node.setLargestLengthPathinSubtreeRootedAtThisNode(getHeight(node.getRightChild()) + 1);

		}

		// node has no children i.e Leaf node
		if (node.getLeftChild() == null && node.getRightChild() == null) {

			node.setLargestLengthPathinSubtreeRootedAtThisNode(1); // we have decided to return 1 as the LLPS of leaf
																	// nodes.
		}

		return node.getLargestLengthPathinSubtreeRootedAtThisNode();

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

	// this is another insertNode that you can use, this retuns void.
	void insertNode(T newData, Node<T> node) {

		// At a particular juncture,
		// if less(<) then left

		if (newData.compareTo(node.getData()) < 0) {

			if (node.getLeftChild() != null) {
				insertNode(newData, node.getLeftChild());
			} else {

				Node<T> newNode = new Node<T>(newData);
				node.setLeftChild(newNode);
			}
		}
		// else(>,=) right
		else {

			if (node.getRightChild() != null) {
				insertNode(newData, node.getRightChild());
			} else {

				Node<T> newNode = new Node<T>(newData);
				node.setRightChild(newNode);
			}
		}
	}

}
