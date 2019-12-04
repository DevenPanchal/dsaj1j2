package com.balazsholczer.huffman;

public class HuffmanNode extends HuffmanTree {

	private HuffmanTree rightTree;
	private HuffmanTree leftTree;

	public HuffmanNode(HuffmanTree rightTree, HuffmanTree leftTree) {
		super(rightTree.getFrequency() + leftTree.getFrequency());
		this.rightTree = rightTree;
		this.leftTree = leftTree;
	}

	public HuffmanTree getRightTree() {
		return rightTree;
	}

	public void setRightTree(HuffmanTree rightTree) {
		this.rightTree = rightTree;
	}

	public HuffmanTree getLeftTree() {
		return leftTree;
	}

	public void setLeftTree(HuffmanTree leftTree) {
		this.leftTree = leftTree;
	}
}
