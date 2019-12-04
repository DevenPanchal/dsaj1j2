package com.balazsholczer.avl;

public interface Tree {
	public void insert(int data);
	public void delete(int data);
	void preOrdertraverse();
	void inOrdertraverse();
}
