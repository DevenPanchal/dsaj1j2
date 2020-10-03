package com.balazsholczer.tries;

import java.util.ArrayList;
import java.util.List;

public class Trie {

	private Node root;
	private int indexOfSingleChild;

	public Trie() {
		this.root = new Node("");
	}

	public void insert(String key) {

		Node tempNode = root;

		for (int i = 0; i < key.length(); ++i) {

			char c = key.charAt(i); // One character at a time, move downwards
			int asciiIndex = c - 'a';

			// insert only if the character does not exist
			if (tempNode.getChild(asciiIndex) == null) {
				Node node = new Node(String.valueOf(c));
				tempNode.setChild(asciiIndex, node);
				tempNode = node;
			} else {
				// else if it is already present then, just go to it i.e that is the tempNode
				tempNode = tempNode.getChild(asciiIndex);
			}
		}
		// if we have managed to insert all characters of the word i.e key,
		// then set that last tempNode at that point to be leaf
		tempNode.setLeaf(true);
	}

	// O(length(key))
	public boolean search(String key) {

		Node trieNode = root;

		for (int i = 0; i < key.length(); ++i) {

			char c = key.charAt(i); // One character at a time, move downwards
			int asciiIndex = c - 'a';

			if (trieNode.getChild(asciiIndex) == null) {
				return false;
			} else {
				trieNode = trieNode.getChild(asciiIndex);
			}
		}
		// if we have managed to iterate through all characters of the word i.e key,
		// then that means
		// that the key or the word is present. Return true.

		// if (!(trieNode.isLeaf())){return false;} / if you want to be able to say
		// whether that exact word was inserted in the Trie, but not its substring ,
		// then add the above snippet in the search function, just before returning true
		return true; // returns true for word match or even substring match.
	}

	// THIS IMPLEMENTS AUTOCOMPLETE!! THIS CAN BE THE CODE TO A SYSTEM DESIGN
	// QUESTION.
	public List<String> allWordsWithPrefix(String prefix) {

		Node trieNode = root;
		List<String> allWords = new ArrayList<>();

		for (int i = 0; i < prefix.length(); ++i) {

			char c = prefix.charAt(i);
			int asciiIndex = c - 'a';
			trieNode = trieNode.getChild(asciiIndex);
		}

		// similar to search/ finish traversing all the characters of the word and then
		// call collect() which collects all the autocompletes

		collect(trieNode, prefix, allWords);

		return allWords;
	}

	public List<String> sort(String prefix) {

		Node trieNode = root;
		List<String> allWords = new ArrayList<>();

		for (int i = 0; i < prefix.length(); ++i) {

			char c = prefix.charAt(i);
			int asciiIndex = c - 'a';
			trieNode = trieNode.getChild(asciiIndex);
		}

		collect(trieNode, prefix, allWords);

		return allWords;
	}

	// takes O(N) * O(N) time = O(N^2) time.
	public String longestCommonPrefix() {

		Node trieNode = root;
		String lcp = "";

		while (countNumOfChildren(trieNode) == 1 && !trieNode.isLeaf()) {
			trieNode = trieNode.getChild(indexOfSingleChild); // indexOfSingleChild is zero first. // this is an
																// optimization. Read it in conjunction with the
																// countNumOfChildren function.
			lcp = lcp + String.valueOf((char) (indexOfSingleChild + 'a')); // adding the index of Single child to the
																			// ASCII value of 'a'. This will give the
																			// correct character.
		}

		return lcp;
	}

	// takes O(N) time
	private int countNumOfChildren(Node trieNode) {

		int numOfChildren = 0;

		for (int i = 0; i < trieNode.getChildren().length; i++) {
			if (trieNode.getChild(i) != null) {
				numOfChildren++;
				indexOfSingleChild = i;
			}
		}

		return numOfChildren;
	}

	private void collect(Node node, String prefix, List<String> allWords) {

		if (node == null)
			return;

		if (node.isLeaf()) {
			allWords.add(prefix);
		}

		// Depth first search
		for (Node childNode : node.getChildren()) {
			if (childNode == null)
				continue;
			String childCharacter = childNode.getCharacter();
			collect(childNode, prefix + childCharacter, allWords);
		}
	}
}
