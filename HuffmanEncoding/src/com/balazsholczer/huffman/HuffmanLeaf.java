package com.balazsholczer.huffman;

public class HuffmanLeaf extends HuffmanTree {

	private char value;

	public HuffmanLeaf(int frequency) {
		super(frequency);
	}

	public HuffmanLeaf(int frequency, char value) {
		super(frequency);
		this.value = value;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}
}
