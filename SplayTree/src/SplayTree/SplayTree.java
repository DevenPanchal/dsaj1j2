package SplayTree;



public class SplayTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;
	private Node<T> parentNode;

	public Node<T> getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node<T> parentNode) {
		this.parentNode = parentNode;
	}

	public void delete(T data) {
		// DEVEN: The delete method here can be a combination of find, splay for
		// searched item, deleting from a BST- 3 cases of deletion.
		// No balancing required. Since it doesn't matter if the tree is
		// balanced/unbalanced after insertion/deletion. Remember, our aim for a Splay
		// tree is to keep
		// recently searched/ inserted/asked to be deleted item at the root.
	}

	public void recursiveInsert(T data) {

		if (root == null) {
			root = new Node<T>(data);
			System.out.println("Inserting node " + root.getData());
		} else {

			root = recursiveInsert(data, root);

		}
	}

	private Node<T> recursiveInsert(T newData, Node<T> node) {

		/*
		 * Note: Duplicate keys not allowed. To allow duplicate keys, we could have
		 * added equals sign i.e <= or >= when comparing data with the node.
		 */

		if ((node != null) && (newData.compareTo(node.getData()) < 0)) {

			// go left.
			// But before that, add logic to record parent nodes of the next node, because
			// the splaying operation goes upto the top for the inserted node.
			// The going upto the top also happens outside and before this recursion folds
			// up.
			// It happens in the splayNode function

			parentNode = node;

			return recursiveInsert(newData, node.getLeftNode()); // we want to return the most recent/ inserted Node
		}

		else if ((node != null) && (newData.compareTo(node.getData()) > 0)) {
			// go right
			// But before that, add logic to record parent nodes of the next node, because
			// the splaying operation goes upto the top for the inserted node.
			// The going upto the top also happens outside and before this recursion folds
			// up.
			// It happens in the splayNode function
			parentNode = node;

			return recursiveInsert(newData, node.getRightNode()); // we want to return the most recent/ inserted Node
		}

		else {
			// the node is null, so create the node.
			Node<T> newNode = new Node<T>(newData);
			// give the new node its parent
			newNode.setParentNode(parentNode);
			// and return from here itself with the newly made node.
			System.out.println("Inserting node " + newNode.getData());

			// now add the node as left or right child of its parent, depending upon whether
			// it was less or more than its parent. Why? Because, this information is needed
			// in the splayNode function.

			if (parentNode == null) {
				root = newNode;
			} else if (newNode.getData().compareTo(parentNode.getData()) < 0) {
				parentNode.setLeftNode(newNode);
			} else {
				parentNode.setRightNode(newNode);
			}

			splayNode(newNode);
			return newNode;

		}

	}

	void recursiveFind(T data) {

		if (root == null) {
			root = new Node<T>(data);
		} else {
			root = recursiveFind(data, root);
		}
	}

	Node<T> recursiveFind(T newData, Node<T> node) {

		/*
		 * Note: Duplicate keys not allowed. To allow duplicate keys, we could have
		 * added equals sign i.e <= or >= when comparing data with the node.
		 */

		if ((node != null) && (newData.compareTo(node.getData()) < 0)) {
			// go left
			parentNode = node;
			return recursiveFind(newData, node.getLeftNode());
		}

		else if ((node != null) && (newData.compareTo(node.getData()) > 0)) {
			// go right
			parentNode = node;
			return recursiveFind(newData, node.getRightNode());
		}

		else {

			// irrespective of the fact that the node is found, or not found and hence
			// created, we splay the node.

			// if the node is not null, we have found the node!!
			if (node != null) {
				System.out.println("Found node " + node.getData());
				splayNode(node);
				return node;
			}

			// if the node is null, create the node
			else {
				Node<T> newNode = new Node<T>(newData);
				// give the new node its parent
				newNode.setParentNode(parentNode);
				// and return from here itself with the newly made node.
				System.out.println("Inserting node " + newNode.getData());

				if (parentNode == null) {
					root = newNode;
				} else if (newNode.getData().compareTo(parentNode.getData()) < 0) {
					parentNode.setLeftNode(newNode);
				} else {
					parentNode.setRightNode(newNode);
				}

				splayNode(newNode);
				return newNode;
			}

			// return nothing. splayNode has take care of the correct caching

		}

		// return nothing. splayNode has take care of the correct caching

	}

	private void splayNode(Node<T> recentNode) {

		{

			while (recentNode.getParentNode() != null)// i.e repeat until recent node is the root node. i.e its parent
														// is null
			{

				// ZIG SITUATION - So test for L or R case
				if (recentNode.getParentNode().getParentNode() == null) {
					// recent node is the left Node
					if (recentNode.getParentNode().getLeftNode() == recentNode) {
						rightRotation(recentNode.getParentNode());
					} else { // recent node is the right Node
						leftRotation(recentNode.getParentNode());
					}

					// ZIG-ZIG SITUATION - So test for LL or RR cases
				} else if (recentNode.getParentNode().getLeftNode() == recentNode
						&& recentNode.getParentNode().getParentNode().getLeftNode() == recentNode.getParentNode()) {
					// LL case
					rightRotation(recentNode.getParentNode().getParentNode());
					rightRotation(recentNode.getParentNode());
				} else if (recentNode.getParentNode().getRightNode() == recentNode
						&& recentNode.getParentNode().getParentNode().getRightNode() == recentNode.getParentNode()) {
					// RR case
					leftRotation(recentNode.getParentNode().getParentNode());
					leftRotation(recentNode.getParentNode());
				}

				// ZIG-ZAG SITUATION - So test for LR and RL cases
				else if (recentNode.getParentNode().getLeftNode() == recentNode
						&& recentNode.getParentNode().getParentNode().getRightNode() == recentNode.getParentNode()) {
					// LR case
					rightRotation(recentNode.getParentNode());
					leftRotation(recentNode.getParentNode());
				} else {
					// RL case
					leftRotation(recentNode.getParentNode());
					rightRotation(recentNode.getParentNode());
				}
			}
		}

	}

	@Override
	public void inOrderTraversal() {
		if (this.root != null) {
			inOrderTraversal(root);
		}
	}

	private void inOrderTraversal(Node<T> node) {

		if (node.getLeftNode() != null) {
			inOrderTraversal(node.getLeftNode());
		}

		System.out.print(node.getData() + " ");

		if (node.getRightNode() != null) {
			inOrderTraversal(node.getRightNode());
		}
	}

	@Override
	public void preOrderTraversal() {
		if (this.root != null) {
			preOrderTraversal(root);
		}
	}

	private void preOrderTraversal(Node<T> node) {

		System.out.print(node.getData() + " ");

		if (node.getLeftNode() != null) {
			inOrderTraversal(node.getLeftNode());
		}

		if (node.getRightNode() != null) {
			inOrderTraversal(node.getRightNode());
		}
	}

	@Override
	public T getMin() {
		if (this.root != null) {
			return getMin(root);
		}

		return null;
	}

	private T getMin(Node<T> node) {

		if (node.getLeftNode() != null) {
			return getMin(node.getLeftNode());
		} else {
			return node.getData();
		}
	}

	@Override
	public T getMax() {
		if (this.root != null) {
			return getMax(root);
		}

		return null;
	}

	private T getMax(Node<T> node) {

		if (node.getRightNode() != null) {
			return getMax(node.getRightNode());
		} else {
			return node.getData();
		}
	}

	public void printRoot() {
		System.out.println(root);
	}

	public boolean isEmpty() {
		return this.root == null;
	}

	@Override
	public Node<T> iterativeFind(T data) {

		Node<T> node = this.root;

		// find the node
		while (node != null) {
			if (node.getData().compareTo(data) < 0) {
				node = node.getRightNode();
			} else if (node.getData().compareTo(data) > 0) {
				node = node.getLeftNode();
			} else {
				splay(node); // splaying required on every insert or every find. // this is where this
								// differs from AVL tree. We splay even for found/inserted node.
				return node;
			}
		}

		// if search fails i.e you reach null , then still splay with the searched node.
		// But return null.
		splay(node); // splaying required on every insert or every find.

		return null;
	}

	public void iterativeInsert(T data) {

		Node<T> node = this.root;
		Node<T> nodeParent = null;

		// find the node
		while (node != null) {

			nodeParent = node; // on every iteration update the parentNode

			if (node.getData().compareTo(data) < 0) {
				node = node.getRightNode();
			} else {
				node = node.getLeftNode();
			}
		}

		// the moment node is null, we insert data and also add its parent
		node = new Node<T>(data);
		node.setParentNode(nodeParent);

		// make sure, this newly created node's parent is updated with this node too.

		// so our aim with first loop was to find the node, then give it its parent, now
		// with this loop we want to tell its parent whether this node is left child,
		// rghtchild or root.
		// this much info only is enough for the splaynode function which returns the
		// recentnode after repairing the tree according to splaying properties.

		if (nodeParent == null) {
			this.root = node; // the current node is root, if parentNode is null. Else set it appropriately as
								// the left or right child of the parent after comparison.
		} else if (nodeParent.getData().compareTo(node.getData()) < 0) {
			nodeParent.setRightNode(node);
		} else {
			nodeParent.setLeftNode(node);
		}

		splay(node); // splaying required on every insert or every find.

	}

	// A utility function to right rotate subtree rooted with node. See its use in
	// Rotations.jpg
	private Node<T> rightRotation(Node<T> node) {

		System.out.println("Rotating to the right on node: " + node);

		// Before rotation, node is the root
		Node<T> tempLeftNode = node.getLeftNode();
		Node<T> t = tempLeftNode.getRightNode();

		// Perform rotation
		tempLeftNode.setRightNode(node); // After rotation, tempLeftNode is the root
		node.setLeftNode(t);

		// Return new root
		return tempLeftNode;
	}

	// A utility function to left rotate subtree rooted with node. See its use in
	// Rotations.jpg
	private Node<T> leftRotation(Node<T> node) {

		System.out.println("Rotating to the left on node:" + node);

		// Before rotation, node is the root
		Node<T> tempRightNode = node.getRightNode();
		Node<T> t = tempRightNode.getLeftNode();

		// Perform rotation
		tempRightNode.setLeftNode(node); // After rotation, tempRightNode is the root
		node.setRightNode(t);

		// Return new root
		return tempRightNode;
	}

	private void rotateLeft(Node<T> node) {

		Node<T> tempNode = node.getRightNode();

		if (tempNode != null) {

			node.setRightNode(tempNode.getLeftNode());

			if (tempNode.getLeftNode() != null) {
				tempNode.getLeftNode().setParentNode(node);
			}

			tempNode.setParentNode(node.getParentNode());
		}

		if (node.getParentNode() == null) {
			this.root = tempNode;
		} else if (node == node.getParentNode().getLeftNode()) {
			node.getParentNode().setLeftNode(tempNode);
		} else {
			node.getParentNode().setRightNode(tempNode);
		}

		if (tempNode != null) {
			tempNode.setLeftNode(node);
		}

		node.setParentNode(tempNode);
	}

	private void rotateRight(Node<T> node) {

		Node<T> tempNode = node.getLeftNode();

		if (tempNode != null) {
			node.setLeftNode(tempNode.getRightNode());

			if (tempNode.getRightNode() != null) {
				tempNode.getRightNode().setParentNode(node);
			}

			tempNode.setParentNode(node.getParentNode());
		}

		if (node.getParentNode() == null) {
			this.root = tempNode;
		} else if (node == node.getParentNode().getLeftNode()) {
			node.getParentNode().setLeftNode(tempNode);
		} else {
			node.getParentNode().setRightNode(tempNode);
		}

		if (tempNode != null) {
			tempNode.setRightNode(node);
		}

		node.setParentNode(tempNode);
	}

	private void splay(Node<T> node) {

		while (node.getParentNode() != null)// i.e repeat until node is the root node. i.e its parent is null
		{

			// ZIG SITUATION
			if (node.getParentNode().getParentNode() == null) {
				if (node.getParentNode().getLeftNode() == node) {// so node is a left child + grandparent is null
					rotateRight(node.getParentNode());
				} else { // so node is a right child + grandparent is null
					rotateLeft(node.getParentNode());
				}
				// ZIG-ZIG SITUATION
			} else if (node.getParentNode().getLeftNode() == node
					&& node.getParentNode().getParentNode().getLeftNode() == node.getParentNode()) { // so node is left
																										// child and
																										// parent is a
																										// left child
				rotateRight(node.getParentNode().getParentNode());
				rotateRight(node.getParentNode());
			} else if (node.getParentNode().getRightNode() == node // so node is right child and parent is a right child
					&& node.getParentNode().getParentNode().getRightNode() == node.getParentNode()) {
				rotateLeft(node.getParentNode().getParentNode());
				rotateLeft(node.getParentNode());
			}
			// ZIG-ZAG SITUATION
			else if (node.getParentNode().getLeftNode() == node // so node is left child and parent is right child
					&& node.getParentNode().getParentNode().getRightNode() == node.getParentNode()) {
				rotateRight(node.getParentNode());
				rotateLeft(node.getParentNode()); // because the new node is in the middle. so node.getParentNode()
													// means
			} else {// so node is right child and parent is left child
				rotateLeft(node.getParentNode());
				rotateRight(node.getParentNode()); // because the new node is in the middle.
			}
		}
	}
}
