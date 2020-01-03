package SplayTree;

public class SplayTree<T extends Comparable<T>> implements Tree<T> {

	private int size;
	private Node<T> rootNode;

	public void delete(T data) {
		// DEVEN: The delete method here can be a combination of find, splay for
		// searched item, deleting from a BST- 3 cases of deletion.
		// No balancing required. Since it doesn't matter if the tree is
		// balanced/unbalanced after insertion/deletion. Remember, our aim for a Splay
		// tree is to keep
		// recently searched/ inserted/asked to be deleted item at the root.
	}

	public void insert(T data) {

		Node<T> tempNode = this.rootNode;
		Node<T> parentNode = null;

		while (tempNode != null) {

			parentNode = tempNode; // on every iteration update the parentNode

			if (tempNode.getData().compareTo(data) < 0) {
				tempNode = tempNode.getRightNode();
			} else {
				tempNode = tempNode.getLeftNode();
			}
		}

		tempNode = new Node<T>(data);
		tempNode.setParentNode(parentNode);

		if (parentNode == null) {
			this.rootNode = tempNode; // the current node is root, if parentNode is null. Else set it appropriately as
										// the left or right child of the parent after comparison.
		} else if (parentNode.getData().compareTo(tempNode.getData()) < 0) {
			parentNode.setRightNode(tempNode);
		} else {
			parentNode.setLeftNode(tempNode);
		}

		splay(tempNode); // splaying required on every insert or every find.
		this.size++;
	}

	@Override
	public void inOrderTraversal() {
		if (this.rootNode != null) {
			inOrderTraversal(rootNode);
		}
	}

	private void inOrderTraversal(Node<T> node) {

		if (node.getLeftNode() != null) {
			inOrderTraversal(node.getLeftNode());
		}

		System.out.print(node + " ");

		if (node.getRightNode() != null) {
			inOrderTraversal(node.getRightNode());
		}
	}

	@Override
	public T getMin() {
		if (this.rootNode != null) {
			return getMin(rootNode);
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
		if (this.rootNode != null) {
			return getMax(rootNode);
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
		System.out.println(rootNode);
	}

	public boolean isEmpty() {
		return this.rootNode == null;
	}

	public int size() {
		return this.size;
	}

	@Override
	public Node<T> find(T data) {

		Node<T> tempNode = this.rootNode;

		while (tempNode != null) {
			if (tempNode.getData().compareTo(data) < 0) {
				tempNode = tempNode.getRightNode();
			} else if (tempNode.getData().compareTo(data) > 0) {
				tempNode = tempNode.getLeftNode();
			} else {
				splay(tempNode); // splaying required on every insert or every find.
				return tempNode;
			}
		}

		// if search fails, then still splay with the searched node. But return null.
		splay(tempNode); // splaying required on every insert or every find.

		return null;
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
			this.rootNode = tempNode;
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
			this.rootNode = tempNode;
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

		while (node.getParentNode() != null)// i.e repeat until node is the root node. i.e its parent is null {

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
			} // ZIG-ZAG SITUATION
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
