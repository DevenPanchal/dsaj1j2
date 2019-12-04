package com.balazsholczer.huffman;

import java.util.PriorityQueue;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class HuffmanCode {

	public HuffmanTree buildTree(int[] charFrequencies){
		
		PriorityQueue<HuffmanTree> queue = new PriorityQueue<>();
		
		for(int i=0;i<charFrequencies.length;i++){
			if( charFrequencies[i] > 0 ){
				queue.add(new HuffmanLeaf(charFrequencies[i], (char) i));
			}
		}
		
		while( queue.size() > 1 ){
			
			HuffmanTree tree1 = queue.poll();
			HuffmanTree tree2 = queue.poll();
			
			queue.add(new HuffmanNode(tree1,tree2));
			
		}
		
		return queue.poll();
	}
	
	public void printCodes(HuffmanTree tree, StringBuilder prefix){
		
		if( tree instanceof HuffmanLeaf ){
			HuffmanLeaf leaf = (HuffmanLeaf) tree;
			System.out.println(leaf.getValue()+"\t" +leaf.getFrequency()+"\t"+prefix);
		}else if( tree instanceof HuffmanNode ){
			
			HuffmanNode node = (HuffmanNode) tree;
			
			// travel left
			prefix.append("0");
			printCodes(node.getLeftTree(),prefix);
			prefix.deleteCharAt(prefix.length()-1);
			
			//travel right
			prefix.append("1");
			printCodes(node.getRightTree(),prefix);
			prefix.deleteCharAt(prefix.length()-1);		
			
		}		
	}
}
