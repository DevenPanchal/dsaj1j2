package com.balazsholczer.sorting;

public class InsertionSort {

	public static void main(String[] args) {

        int[] nums = { -4,-66,0,4,2,2,1, 55, 66 };

        for (int i = 0; i < nums.length; ++i) {

            int j = i;

            while ((j > 0) && (nums[j - 1] > nums[j])) {
                swap(nums, j, j - 1);
                --j;
            }
        }

        showArray(nums);
    }

    private static void showArray(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + "  ");
        }
    }

    private static void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
