package com.balazsholczer.selection;

public class SelectionSort {

	public static void main(String[] args) {

		int nums[] = { 1, 56, 32, 45, 89, 76 };

		// for loop for element in question
		for (int i = 0; i < nums.length - 1; ++i) {

			int index = i;
			// for loop for find min element
			for (int j = i + 1; j < nums.length; ++j) {
				if (nums[j] > nums[index]) {
					index = j;
				}
			}

			// swap min element with the element in question
			// but only do this if the element in question and min have different values.
			if (index != i) {
				int temp = nums[i];
				nums[i] = nums[index];
				nums[index] = temp;
			}
		}

		showArray(nums);
	}

	public static void showArray(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "  ");
		}
	}
}
