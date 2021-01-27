package com.balazsholczer.counting;

public class App {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,9,4,55,6,55};
		CountingSort countingSort = new CountingSort(nums);
		countingSort.countingSort(1, 55);// pass min and max to the counting sort function.
		countingSort.showArray();
		
		
	}
}
