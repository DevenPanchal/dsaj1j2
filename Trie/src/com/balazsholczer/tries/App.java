package com.balazsholczer.tries;

import java.util.List;

public class App {

	public static void main(String[] args) {
		
		
		Trie trie = new Trie();
		
		trie.insert("she");
		trie.insert("shell");
		trie.insert("sheshore");
		
//		List<String> list = trie.allWordsWithPrefix("");
//		
//		for(String s : list)
//			System.out.println(s);
			
		System.out.println(trie.longestCommonPrefix());
		
	}
}
