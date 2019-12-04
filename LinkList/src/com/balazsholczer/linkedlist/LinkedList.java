package com.balazsholczer.linkedlist;

import java.util.HashMap;

public class LinkedList<T extends Comparable<T>> implements List<T> {

	private Node<T> root;
	private int sizeCounter;

	@Override
	public int size() {
		return this.sizeCounter;
	}

	@Override
	public void traverseList() {

		if (this.root == null) {
			return;
		}

		Node<T> node = this.root;

		while (node != null) {
			System.out.print(node + " -> ");
			node = node.getNextNode();
		}

		System.out.println("null");
		System.out.println();
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

	// O(1) constant time complexity, update the references
	private void insertDataBeginning(T data) {

		Node<T> newNode = new Node<>(data);
		newNode.setNextNode(root);
		this.root = newNode;
	}

	// O(N) inserting at the end
	// NOT used generally.
	// can be used like so- insertDataEnd(10, rootofList)
	// Notice how this function is written in a recursive fashion.
	private void insertDataEnd(T data, Node<T> node) {

		if (node.getNextNode() != null) {
			insertDataEnd(data, node.getNextNode());
		} else {
			++this.sizeCounter;
			Node<T> newNode = new Node<>(data);
			node.setNextNode(newNode);
		}
	}

	// Notice how this function is written in a recursive fashion.
	@Override
	public void remove(T data) {

		// Check if the linkedlist is empty. If empty, then nothing to remove. Return
		// immediately.
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

	private void remove(T dataToRemove, Node<T> previousNode, Node<T> actualNode) {

		while (actualNode != null) {

			if (actualNode.getData().compareTo(dataToRemove) == 0) {
				// once the actual node matches, connect previous node to next node
				// and set actual node to null so that it can be collected by the garbage
				// collector.
				previousNode.setNextNode(actualNode.getNextNode());
				actualNode = null;
				return;
			}

			// if the actual node has not matched, keep hopping/traversing.
			previousNode = actualNode;
			actualNode = actualNode.getNextNode();
			remove(dataToRemove, previousNode, actualNode);
		}

	}

	// Helper traversetoNode method added by Deven
	@Override
	public HashMap<String, Node<T>> deventraversetoNode(T stoppingNodeData) {

		Node<T> previousNodefromTraversal = null;
		Node<T> currentNodefromTraversal = null;
		Node<T> nextNodefromTraversal = null;

		// if the linkedlist is empty, just return all previousNodefromTraversal,
		// currentNodefromTraversal , nextNodefromTraversal to be null
		if (this.root == null) {

			HashMap<String, Node<T>> nodes = new HashMap<String, Node<T>>();
			nodes.put("previousNodefromTraversal", null);
			nodes.put("currentNodefromTraversal", null);
			nodes.put("nextNodefromTraversal", null);

			return nodes;
		}

		Node<T> node = this.root;

		while (node.getData() != stoppingNodeData) {
			previousNodefromTraversal = node;
			node = node.getNextNode();
		}

		currentNodefromTraversal = node;
		nextNodefromTraversal = node.getNextNode();

		HashMap<String, Node<T>> nodes = new HashMap<String, Node<T>>();
		nodes.put("previousNodefromTraversal", previousNodefromTraversal);
		nodes.put("currentNodefromTraversal", currentNodefromTraversal);
		nodes.put("nextNodefromTraversal", nextNodefromTraversal);

		return nodes;

	}

	// inserts are usually always at the beginning.. So I have not written a helper
	// deveninsertAtBeginning or deveninsertAtEnd function.
	public void deveninsert(T data) {
		++this.sizeCounter;
		Node<T> newNode = new Node<T>(data);
		newNode.setNextNode(root);
		this.root = newNode;

	}

	public void devenremove(T data) {
		if (this.root == null) {
			System.out.println("The list does not exist. So nothing can be removed.");
			return;
		}

		--this.sizeCounter;

		HashMap<String, Node<T>> resultsHashMap = deventraversetoNode(data);

		if (resultsHashMap.get("previousNodefromTraversal") == null) {

			/*
			 * meaning the actual node was the first node in the linkedlist. In this case
			 * simply set the root to be nextNodefromTraversal thus deleting the current
			 * Node
			 */
			this.root = resultsHashMap.get("nextNodefromTraversal");
		} else if (resultsHashMap.get("nextNodefromTraversal") == null) {

			/*
			 * meaning the actual node was the last node in the linkedlist. In this case,
			 * set chain the previousNodefromTraversal to null, thus deleting the current
			 * node.
			 */
			resultsHashMap.get("previousNodefromTraversal").setNextNode(null);
		}

		/* if actual node was a middle node, connecting previous node to next node thus deleting the current Node */
		else {
			resultsHashMap.get("previousNodefromTraversal").setNextNode(resultsHashMap.get("nextNodefromTraversal"));
		}
	}

	public void devenprintList() {

		if (this.root == null) {
			return;
		}

		
		Node<T> node = this.root;

		while (node != null) {
			System.out.print(node + " -> ");
			node = node.getNextNode();
		}

		System.out.println("null");
		System.out.println();
	}

}
