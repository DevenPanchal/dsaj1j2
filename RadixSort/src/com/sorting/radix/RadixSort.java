package com.sorting.radix;

import java.util.Arrays;

public class RadixSort {

	private int[] nums;
	private int[] output;
	
	public RadixSort(int[] nums) {
		this.nums = nums;
		this.output = new int[nums.length];
	}
	
	public void radixsort() {
			
		//simple linear search for the max item
		int m = Arrays.stream(nums).max().getAsInt();
		
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(exp);
	}

	public void countSort(int exp) {
			
		int count[] = new int[10];
		
		// Store count of occurrences in count[]
		for (int i = 0; i < nums.length; i++)
			count[(nums[i] / exp) % 10]++;
		
		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (int i = 1; i < count.length; i++)
			count[i] += count[i - 1];
		
		// Build the output array
		for (int i = nums.length - 1; i >= 0; i--) {
			output[count[(nums[i] / exp) % 10] - 1] = nums[i];
			count[(nums[i] / exp) % 10]--;
		}
		
		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to current digit
		for (int i = 0; i < nums.length; i++)
			nums[i] = output[i];
	}
	
	public void showArray() {
		for(int i=0;i<output.length;i++)
			System.out.print(output[i]+" ");
	}
}
