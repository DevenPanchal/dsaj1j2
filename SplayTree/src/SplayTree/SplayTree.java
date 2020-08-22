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
		// Refer to README
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

	@Override
	public void iterativeFind(T data) {

		Node<T> node = this.root;
		Node<T> nodeParent = null;

		// find the node
		while (node != null) {

			nodeParent = node; // on every iteration update the parentNode

			if (node.getData().compareTo(data) < 0) {
				node = node.getRightNode();
			} else if (node.getData().compareTo(data) > 0) {
				node = node.getLeftNode();
			} else {
				splayNode(node); // splaying required on every insert or every find. // this is where this
									// differs from AVL tree. We splay even for found/inserted node.
				return;
			}
		}

		// if search fails i.e you reach null node, then still splay with the searched node.
		// the null node now becomes a real node i.e search failed node.
		
		node = new Node<T>(data);
		node.setParentNode(nodeParent);

		// make sure, this newly created node's parent is updated with this node too.

		// so our aim with first loop was to find the node, then give it its parent, now
		// with this loop we want to tell its parent whether this node is left child,
		// rightchild or root.
		// this much info only is enough for the splaynode function which repairs the
		// tree according to splaying properties.Its return value i.e recently splayed
		// node - then may or may not be used by the caller.

		if (nodeParent == null) {
			this.root = node; // the current node is root, if parentNode is null. Else set it appropriately as
								// the left or right child of the parent after comparison.
		} else if (nodeParent.getData().compareTo(node.getData()) < 0) {
			nodeParent.setRightNode(node);
		} else {
			nodeParent.setLeftNode(node);
		}

		splayNode(node); // splaying on the failed node which was created.
		return;
	}

	@Override
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
		// rightchild or root.
		// this much info only is enough for the splaynode function which repairs the
		// tree according to splaying properties.Its return value i.e recently splayed
		// node - then may or may not be used by the caller.

		if (nodeParent == null) {
			this.root = node; // the current node is root, if parentNode is null. Else set it appropriately as
								// the left or right child of the parent after comparison.
		} else if (nodeParent.getData().compareTo(node.getData()) < 0) {
			nodeParent.setRightNode(node);
		} else {
			nodeParent.setLeftNode(node);
		}

		splayNode(node); // splaying required on every insert or every find.

	}

	@Override
	public void anotherIterativeInsert(T data) {
		Node<T> node = this.root;
		Node<T> nodeParent = null;

		// find the node
		while (node != null) {

			nodeParent = node; // on every iteration update the parentNode

			if (node.getData().compareTo(data) < 0) {
				node = node.getRightNode();
			} else if (node.getData().compareTo(data) > 0) {
				node = node.getLeftNode();
			} else {

				// the moment node is null, we insert data and also add its parent
				Node<T> newNode = new Node<T>(data);
				newNode.setParentNode(nodeParent);

				// make sure, this newly created node's parent is updated with this node too.

				// so now
				// with this loop we want to tell its parent whether this node is left child,
				// rightchild or root.
				// this much info only is enough for the splaynode function which repairs the
				// tree according to splaying properties.Its return value i.e recently splayed
				// node - then may or may not be used by the caller.

				if (nodeParent == null) {
					this.root = newNode; // the current node is root, if parentNode is null. Else set it appropriately
											// as
											// the left or right child of the parent after comparison.
				} else if (nodeParent.getData().compareTo(newNode.getData()) < 0) {
					nodeParent.setRightNode(newNode);
				} else {
					nodeParent.setLeftNode(newNode);
				}

				splayNode(newNode); // splaying required on every insert or every find.

			}
		}

	}

	// A utility function to right rotate subtree rooted with
	// nodeOnWhichRotationIsDemanded.
	private Node<T> rotateRight(Node<T> nodeOnWhichRotationIsDemanded) {

		// Before rotation, nodeOnWhichRotationIsDemanded is the root
		Node<T> tempLeftNode = nodeOnWhichRotationIsDemanded.getLeftNode();

		// exactly same as the AVL rotation - except we need to check for null i.e
		// object exists or not before setting its parent, right and left children.
		// This is required because the splay function is not interested in doing these
		// adjustments
		if (tempLeftNode != null) {

			Node<T> t = tempLeftNode.getRightNode();
			nodeOnWhichRotationIsDemanded.setLeftNode(t);
			if (t != null) {
				t.setParentNode(nodeOnWhichRotationIsDemanded);
			}

			// give the new root, its parent
			tempLeftNode.setParentNode(nodeOnWhichRotationIsDemanded.getParentNode());
		}
		// After rotation, tempLeftNode is the root

		if (nodeOnWhichRotationIsDemanded.getParentNode() == null) {
			this.root = tempLeftNode;
		} else if (nodeOnWhichRotationIsDemanded == nodeOnWhichRotationIsDemanded.getParentNode().getLeftNode()) {
			nodeOnWhichRotationIsDemanded.getParentNode().setLeftNode(tempLeftNode);
		} else {
			nodeOnWhichRotationIsDemanded.getParentNode().setRightNode(tempLeftNode);
		}

		if (tempLeftNode != null) {
			tempLeftNode.setRightNode(nodeOnWhichRotationIsDemanded);
		}

		// set the new root as parent of nodeOnWhichRotationIsDemanded
		nodeOnWhichRotationIsDemanded.setParentNode(tempLeftNode);

		// return new root of the group
		return tempLeftNode;
	}

	// A utility function to left rotate subtree rooted with
	// nodeOnWhichRotationIsDemanded
	private Node<T> rotateLeft(Node<T> nodeOnWhichRotationIsDemanded) {

		// Before rotation, nodeOnWhichRotationIsDemanded is the root
		Node<T> tempRightNode = nodeOnWhichRotationIsDemanded.getRightNode();

		// exactly same as the AVL rotation - except we need to check for null i.e
		// object exists or not before setting its parent, right and left children.
		// This is required because the splay function is not interested in doing these
		// adjustments.
		if (tempRightNode != null) {

			Node<T> t = tempRightNode.getLeftNode();
			nodeOnWhichRotationIsDemanded.setRightNode(t);
			if (t != null) {
				t.setParentNode(nodeOnWhichRotationIsDemanded);
			}

			// give the new root, its parent
			tempRightNode.setParentNode(nodeOnWhichRotationIsDemanded.getParentNode());
		}
		// After rotation, tempRightNode is the root

		if (nodeOnWhichRotationIsDemanded.getParentNode() == null) {
			this.root = tempRightNode;
		} else if (nodeOnWhichRotationIsDemanded == nodeOnWhichRotationIsDemanded.getParentNode().getLeftNode()) {
			nodeOnWhichRotationIsDemanded.getParentNode().setLeftNode(tempRightNode);
		} else {
			nodeOnWhichRotationIsDemanded.getParentNode().setRightNode(tempRightNode);
		}

		if (tempRightNode != null) {
			tempRightNode.setLeftNode(nodeOnWhichRotationIsDemanded);
		}

		// set the new root as parent of nodeOnWhichRotationIsDemanded
		nodeOnWhichRotationIsDemanded.setParentNode(tempRightNode);

		// return new root of the group
		return tempRightNode;
	}

	private void splayNode(Node<T> node) {

		while (node.getParentNode() != null)// i.e repeat until node is the root node. i.e its parent is null
		{

			// ZIG SITUATION - So test for L or R case
			if (node.getParentNode().getParentNode() == null) {
				if (node.getParentNode().getLeftNode() == node) { // L case
					rotateRight(node.getParentNode());
				} else { // R case
					rotateLeft(node.getParentNode());
				}
				// ZIG-ZIG SITUATION - So test for LL or RR cases
			} else if (node.getParentNode().getLeftNode() == node
					&& node.getParentNode().getParentNode().getLeftNode() == node.getParentNode()) {
				// LL case
				rotateRight(node.getParentNode().getParentNode());
				rotateRight(node.getParentNode());
			} else if (node.getParentNode().getRightNode() == node
					&& node.getParentNode().getParentNode().getRightNode() == node.getParentNode()) {
				// RR case
				rotateLeft(node.getParentNode().getParentNode());
				rotateLeft(node.getParentNode());
			}

			// ZIG-ZAG SITUATION - So test for LR and RL cases
			else if (node.getParentNode().getLeftNode() == node
					&& node.getParentNode().getParentNode().getRightNode() == node.getParentNode()) {
				// RL case
				rotateRight(node.getParentNode());
				rotateLeft(node.getParentNode());
			} else {
				// LR case
				rotateLeft(node.getParentNode());
				rotateRight(node.getParentNode());
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
			preOrderTraversal(node.getLeftNode());
		}

		if (node.getRightNode() != null) {
			preOrderTraversal(node.getRightNode());
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

}
