package com.balazsholczer.middlenode;

public class LinkedList<T extends Comparable<T>> implements List<T> {

	// HEAD IS ROOT. ROOT IS HEAD
	private Node<T> root;
	private int sizeCounter;

	@Override
	public void reverse() {

		// If the root node is null i.e uninitialized,return immediately.
		if (root == null) {
			return;
		}

		// setup the pointers
		Node<T> currentNode = this.root;
		Node<T> previousNode = null;
		Node<T> nextNode = null;

		// actual work
		while (currentNode != null) {
			nextNode = currentNode.getNextNode();
			currentNode.setNextNode(previousNode);
			previousNode = currentNode;
			currentNode = nextNode;
		}

		// the new root is the last node. i.e the node indicated by previousNode
		this.root = previousNode;
	}

	@Override
	public void insert(T data) {
		++this.sizeCounter;

		if (root == null) {
			root = new Node<>(data);
		} else {
			insertDataBeginning(data);
		}
	}

	@Override
	public void remove(T data) {

		if (this.root == null) {
			return;
		}

		--this.sizeCounter;

		if (this.root.getData().compareTo(data) == 0) {
			this.root = this.root.getNextNode();
		} else {
			remove(data, root, root.getNextNode());
		}
	}

	@Override
	public void traverseList() {

		if (this.root == null) {
			return;
		}

		Node<T> node = this.root;

		while (node != null) {
			System.out.print(node + " ");
			node = node.getNextNode();
		}
	}

	// O(1) constant time complexity, update the references
	private void insertDataBeginning(T data) {

		Node<T> newNode = new Node<>(data);
		newNode.setNextNode(root);
		this.root = newNode;
	}

	// O(N) inserting at the end
	private void insertDataEnd(T data, Node<T> node) {

		if (node.getNextNode() != null) {
			insertDataEnd(data, node.getNextNode());
		} else {
			Node<T> newNode = new Node<>(data);
			node.setNextNode(newNode);
		}
	}

	private void remove(T dataToRemove, Node<T> previousNode, Node<T> actualNode) {

		while (actualNode != null) {

			if (actualNode.getData().compareTo(dataToRemove) == 0) {
				previousNode.setNextNode(actualNode.getNextNode());
				actualNode = null;
				return;
			}

			previousNode = actualNode;
			actualNode = actualNode.getNextNode();
		}
	}

	@Override
	public int size() {
		return this.sizeCounter;
	}
}
