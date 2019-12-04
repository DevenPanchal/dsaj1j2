package com.balazsholczer.stacks;

import java.util.Stack;

public class DevenMaxItemStack {

	// This implementation has time complexity O(1) AND Memory complexity O(1)

	// this is the original stack
	private Stack<Integer> mainStack;
	private int maxValue;

	public DevenMaxItemStack() {

		this.mainStack = new Stack<>();

	}

	public void push(int item) {

		// push the new item onto the stack
		mainStack.push(item);

		// if first item then set the value of maxValue
		if (mainStack.size() == 1) {
			maxValue = item;
			return;
		}

		// if the item is the largest one so far, update maxValue
		if (item > maxValue) {
			maxValue = item;
		}
	}

	// max item is the last item we have inserted into the maxStack O(1)
	public int getMaxItem() {
		return maxValue;
	}
}
