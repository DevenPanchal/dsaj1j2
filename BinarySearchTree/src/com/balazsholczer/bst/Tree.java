package com.balazsholczer.bst;

public interface Tree<T> {
	
	public void insert(T data);
	public void delete(T data);
	public T getMaxValue();
	public T getMinValue();
	void traversal(String type);
}
