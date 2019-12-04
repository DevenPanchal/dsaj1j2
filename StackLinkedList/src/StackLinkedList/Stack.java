package StackLinkedList;

public class Stack<T extends Comparable<T>> {

	// We have implemented Stack using LinkedList style
	// Implementation using linkedlist makes it faster computationally because linkedlist is faster with insert/delete at start operations.
	// But it will have more memory complexity because of pointers etc. associated with linkedin implementation
	// In another stack implemetation, we will implement the Stack abstract datatype i.e interface using arrays.
	// Here see how push always inserts at beginning of the linkedlist. And pop deletes from the beginning of the linkedlist.
	
	// Stack<T extends Comparable<T>> can be just Stack<T> here.
	// Since we do not have compareTo method in any method of class Stack<T>

	private Node<T> root;
	private int count;

	// O(1) constant time
	public void push(T newData) {

		this.count++;

		if (this.root == null) {
			this.root = new Node<>(newData);
		} else {
			Node<T> oldRoot = this.root;
			this.root = new Node<>(newData);
			this.root.setNextNode(oldRoot);
		}
	}

	// O(1)
	public int size() {
		return this.count;
	}

	// O(1)
	public T pop() {
		T itemToPop = this.root.getData();
		this.root = this.root.getNextNode();
		this.count--;
		return itemToPop;
	}

	// O(1) // implemented by deven
	public T peek() {
		T itemToPeek = this.root.getData();
		return itemToPeek;
	}

	// O(1) constant time
	public boolean isEmpty() {
		return this.root == null;
	}
}
