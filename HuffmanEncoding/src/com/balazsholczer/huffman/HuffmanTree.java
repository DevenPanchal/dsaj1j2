package com.balazsholczer.huffman;

public class HuffmanTree implements Comparable<HuffmanTree> {

	private int frequency;

	public HuffmanTree(int frequency) {
		this.frequency = frequency;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public int compareTo(HuffmanTree anotherTree) {
		return Integer.compare(this.frequency, anotherTree.getFrequency());
	}
}
