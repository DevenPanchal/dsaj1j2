package com.sorting.radix;

public class App {

	public static void main(String[] args) {
		
		int[] nums = { 170, 45, 75, 90, 802, 24, 2, 66 };
		
		RadixSort radixSort = new RadixSort(nums);

		radixSort.radixsort();
		radixSort.showArray();
	}
}
