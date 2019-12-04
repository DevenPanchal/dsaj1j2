package com.balazsholczer.largestsum;

public class KadaneAlgorithm {

	public int solve(int[] nums) {
		
		//initialize the algorithm with the first item in the array
		int max_global = nums[0];
		int max_current = nums[0];
		
		//it has an O(N) linear running time complexity
		for(int i=1;i<nums.length;i++) {
			
			max_current = Math.max(nums[i],max_current+nums[i]);
			
			if(max_current>max_global)
				max_global = max_current;
		}

		
		return max_global;
	}
}
