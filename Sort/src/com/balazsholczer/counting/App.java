package com.balazsholczer.counting;

public class App {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,100000,4,5,6,1000000};
		CountingSort countingSort = new CountingSort(nums);
		countingSort.countingSort(1, 7);
		countingSort.showArray();
		
		
	}
}
