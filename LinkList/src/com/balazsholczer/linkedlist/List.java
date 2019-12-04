package com.balazsholczer.linkedlist;

import java.util.HashMap;

// This is an interface for actual LinkedList implementation. It gives a good idea of different functions we expect from the LinkedList.
// to use Node<T> here, we had to make T in the list extend the comparable interface.
public interface List<T extends Comparable<T>> {
	public void insert(T data);

	public void remove(T data);

	public void traverseList();

	public int size();

	// Helper methods added by Deven
	public HashMap<String, Node<T>> deventraversetoNode(T stoppingNodeData);

	public void deveninsert(T data);

	public void devenremove(T data);

	public void devenprintList();

}
