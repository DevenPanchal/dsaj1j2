package com.balazsholczer.counting;

public class CountingSort {

	private int[] nums;

	public CountingSort(int[] nums) {
		this.nums = nums;
	}

	public void countingSort(int min, int max) {

		// allocate memory for the counter array O(k) memory complexity
		int[] countArray = new int[max - min + 1]; // count array will hold the count of each number, at the
													// position/index given by the number in the unsorted array.
													// (unsorted number-min)

		// O(N) consider all items in the original array
		for (int i : this.nums) {
			// when you encounter i'th element, increment the (i-min)'th number in the
			// countArray.
			countArray[i - min] = countArray[i - min] + 1;
		}

		int z = 0;

		// count the occurrences in O(k) time
		for (int i = min; i <= max; i++) {
			while (countArray[i - min] > 0) {
				// for countArray[i-min]th position, transfer elements to the final array that
				// will be sorted.
				this.nums[z] = i;
				z++;
				countArray[i - min] = countArray[i - min] - 1;
			}
		}
	}

	public void showArray() {
		for (int i = 0; i < this.nums.length; ++i) {
			System.out.print(nums[i] + "  ");
		}
	}
}
