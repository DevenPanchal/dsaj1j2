package com.balazsholczer.tries;

import java.util.List;

public class App {

	public static void main(String[] args) {

		Trie trie = new Trie();

		// NOTE:WHILE TESTING ALL SHOULD BE SMALL LETTERS. BECAUSE THAT IS HOW OUR CODE
		// IS WRITTEN. ONLY FOR SMALL LETTERS
		trie.insert("she");
		trie.insert("shell");
		trie.insert("sheshore");
		trie.insert("shoe");
		trie.insert("soap");
		trie.insert("sam");
		trie.insert("same");

		System.out.println("AUTOCOMPLETE---------------");
		List<String> list = trie.allWordsWithPrefix("sh");

		for (String s : list)
			System.out.println(s);

		System.out.println("SORT---------------");
		List<String> list2 = trie.sort("");

		for (String s : list2)
			System.out.println(s);

		System.out.println("LONGEST COMMON PREFIX-------------");
		System.out.println(trie.longestCommonPrefix());

	}
}
