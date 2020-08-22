package com.balazsholczer.avl;

public class AvlTree implements Tree {

	private Node root;

	@Override
	public void insert(int data) {
		root = insert(root, data);
	}

	@Override
	public void delete(int data) {
		root = delete(root, data);
	}

	private Node insert(Node node, int data) {

		/* 1. Perform the normal BST insertion */

		/*
		 * Note: Duplicate keys not allowed. To allow duplicate keys, we could have
		 * added equals sign i.e <= or >= when comparing data with the node.
		 */
		if ((node != null) && (data < node.getData())) {
			// go left
			node.setLeftNode(insert(node.getLeftNode(), data));
		}

		else if ((node != null) && (data > node.getData())) {
			// go right
			node.setRightNode(insert(node.getRightNode(), data));
		}

		else {

			// the node is null, so create the node
			Node newNode = new Node(data);
			// and return from here itself with the newly made node.
			System.out.println("Inserting node " + newNode);
			return newNode;
		}

		/*
		 * 2. Update height of this caller node so that settleViolations can detect
		 * violations
		 */
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

		/*
		 * 3. Settle AVL Violations
		 * 
		 * Important Notes-
		 * 
		 * Call settleViolations. Note that, we are starting to settle violations from
		 * the parent and up i.e first call to settleViolation will have the parent of
		 * inserted node going in. Ideally we should have started from grandparent and
		 * up. But its fine.
		 * 
		 * Once inside, settleViolations you will see that the ingoing node assumes
		 * grandfather position in the arrangement in terms of balance checking and
		 * LL/LR/RR/RL case checking.
		 * 
		 * Also, very important - Don't return node. Return what you got after settling
		 * the violations. That is now the correct child of the previous caller node
		 * will be set. We do this by assigning the return value of settleViolations to
		 * the current node, and then returning the current node.
		 */
		node = settleViolations(node);

		// return the node
		return node;

	}

	private Node delete(Node node, int data) {

		if ((node != null) && (data < node.getData())) {
			node.setLeftNode(delete(node.getLeftNode(), data));
		} else if ((node != null) && (data > node.getData())) {
			node.setRightNode(delete(node.getRightNode(), data));
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
				if (node.getLeftNode() == null && node.getRightNode() == null) {
					System.out.println("Removing a leaf node " + node.getData());
					return null;/*
								 * return null so that the calling node can set its child reference to null.
								 * Since the call to delete comes from a setLeftChild/setRightChild method. This
								 * is important because we are taking care of the structure of the tree
								 */
				}

				if (node.getLeftNode() == null) {
					System.out.println("Removing node " + node.getData() + " which has only a right child "
							+ node.getRightNode().getData());
					Node tempNode = node.getRightNode();
					node = null; // removing the node
					return tempNode; // returning its right child
				} else if (node.getRightNode() == null) {
					System.out.println("Removing node " + node.getData() + " which has only a left child "
							+ node.getLeftNode().getData());
					Node tempNode = node.getLeftNode();
					node = null; // removing the node
					return tempNode; // returning its left child
				}

				// this is the node with two children case !!!
				System.out.println("Removing node " + node.getData() + " which has 2 children "
						+ node.getLeftNode().getData() + "and " + node.getRightNode().getData());
				Node tempNode = getPredecessor(node.getLeftNode());
				/*
				 * Argument is left child of current node i.e left subtree. getPredecessor
				 * searches the rightmost node i.e largest node of the left subtree.
				 */

				node.setData(tempNode.getData());
				node.setLeftNode(delete(node.getLeftNode(), tempNode.getData()));
			}
		}

		/*
		 * 2. Update height of this caller node so that settleViolations can detect
		 * violations
		 */
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

		/*
		 * 3. Settle AVL Violations
		 * 
		 * Important Notes-
		 * 
		 * Call settleViolations. Note that, we are starting to settle violations from
		 * the parent and up i.e first call to settleViolation will have the parent of
		 * inserted node going in.
		 * 
		 * Once inside, settleViolations you will see that the ingoing node assumes
		 * grandfather position in the arrangement in terms of balance checking and
		 * LL/LR/RR/RL case checking.
		 * 
		 * Also, very important - Don't return node. Return what you got after settling
		 * the violations. That is now the correct child of the previous caller node
		 * will be set. We do this by assigning the return value of settleViolations to
		 * the current node, and then returning the current node.
		 */
		node = settleViolations(node);
		// return the node
		return node;
	}

	private Node getPredecessor(Node node) {

		Node predecessor = node;

		while (predecessor.getRightNode() != null)
			predecessor = predecessor.getRightNode();

		return predecessor;
	}

	private Node settleViolations(Node node) {

		// Now we will see the current node, as the grandparent of the arrangement.

		// LL or LR case
		if (getBalanceLeftMinusRightSubtree(node) > 1) {

			// if LR case, then correct and convert to LL case
			if (getBalanceLeftMinusRightSubtree(node.getLeftNode()) < 0) {
				/*
				 * middle value node is at the bottom. so bring it in the middle to convert to
				 * LL case. To do this, we will call left Rotation on the current topologically
				 * middle node.
				 */
				node.setLeftNode(leftRotation(node.getLeftNode()));
			}
			// Now correct the LL case (also the LR case which by this time is also LL case)
			return rightRotation(node); // pull toran towards right
		}

		// RR or RL case
		if (getBalanceLeftMinusRightSubtree(node) < -1) {
			// if RL case, then correct and convert to RR case
			if (getBalanceLeftMinusRightSubtree(node.getRightNode()) > 0) {
				node.setRightNode(rightRotation(node.getRightNode()));
			}
			/*
			 * middle value node is at the bottom. so bring it in the middle to convert to
			 * RR case. To do this, we will call right Rotation on the current topologically
			 * middle node.
			 */

			// Now correct the RR case (also the RL case which by this time is also RR case)
			return leftRotation(node); // pull toran towards left
		}

		return node;
	}

	// A utility function to right rotate subtree rooted with node.
	private Node rightRotation(Node node) {

		System.out.println("Rotating to the right on node: " + node);

		// Before rotation, node is the root
		Node tempLeftNode = node.getLeftNode();
		Node t = tempLeftNode.getRightNode();

		// Perform rotation
		tempLeftNode.setRightNode(node); // After rotation, tempLeftNode is the root
		node.setLeftNode(t);

		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
		tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftNode()), height(tempLeftNode.getRightNode())) + 1);

		// Return new root
		return tempLeftNode;
	}

	// A utility function to left rotate subtree rooted with node.
	private Node leftRotation(Node node) {

		System.out.println("Rotating to the left on node:" + node);

		// Before rotation, node is the root
		Node tempRightNode = node.getRightNode();
		Node t = tempRightNode.getLeftNode();

		// Perform rotation
		tempRightNode.setLeftNode(node); // After rotation, tempRightNode is the root
		node.setRightNode(t);

		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
		tempRightNode
				.setHeight(Math.max(height(tempRightNode.getLeftNode()), height(tempRightNode.getRightNode())) + 1);

		// Return new root
		return tempRightNode;
	}

	private int height(Node node) {

		if (node == null) {
			return -1;
		}

		return node.getHeight();
	}

	private int getBalanceLeftMinusRightSubtree(Node node) {

		if (node == null) {
			return 0;
		}

		return height(node.getLeftNode()) - height(node.getRightNode());
	}

	@Override
	public void preOrdertraverse() {

		if (root == null)
			return;

		preOrderTraversal(root);
	}

	@Override
	public void inOrdertraverse() {

		if (root == null)
			return;

		inOrderTraversal(root);
	}

	private void preOrderTraversal(Node node) {

		System.out.print(node + " --> ");

		if (node.getLeftNode() != null)
			preOrderTraversal(node.getLeftNode());

		if (node.getRightNode() != null)
			preOrderTraversal(node.getRightNode());
	}

	private void inOrderTraversal(Node node) {

		if (node.getLeftNode() != null)
			inOrderTraversal(node.getLeftNode());

		System.out.print(node + " --> ");

		if (node.getRightNode() != null)
			inOrderTraversal(node.getRightNode());
	}

}
