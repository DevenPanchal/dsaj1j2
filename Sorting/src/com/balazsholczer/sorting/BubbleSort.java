package com.balazsholczer.sorting;

public class BubbleSort {

	public static void main(String[] args) {

		int[] nums = { 12, 7, -5, -77, 102 };

		showArray(nums);
		
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - 1 - i; j++) {
				if (nums[j] > nums[j + 1]) {
					swap(nums,j,j+1);
				}
			}
		}

		showArray(nums);
	}
	
	public static void showArray(int[] nums){
		System.out.println();
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+"  ");
		}
	}
	
	public static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
