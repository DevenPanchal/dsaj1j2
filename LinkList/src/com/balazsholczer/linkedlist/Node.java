package com.balazsholczer.linkedlist;

// We will make Node as generic as possible meaning accepting generic types
// But what it can accept i.e T is bounded by the comparable<T> interface i.e int, strings etc. anything that can be compared.
// So Node can store anything that extends comparable interface.
public class Node<T extends Comparable<T>> {

	private T data;
	private Node<T> nextNode;

	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		return this.data.toString();
	}
}
