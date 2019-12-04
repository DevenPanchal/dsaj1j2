package com.balazsholczer.twosum;

public class App {

	/*
	 *    The two sum problem is a common interview question
	 * 	   (it is very similar to the subset sum problem)
	 * 
	 * 			THE PROBLEM: find all the pairs of two integers in an unsorted array
	 * 							   of integers that sum up to a given S
	 * 
	 * 					[1,2,3,4] is the array and S=5 --> [1,4] and [2,3] are the solutions
	 * 
	 * 	       - the naive solution has O(N^2) running time
	 * 		   - we can use dynamic programming to reduce the running time to O(N) linear running time
	 */
	
	public static void main(String[] args) {
		
		int[] nums = {3,5,2,-4,8,11};
		int S = 7;
		
		DynamicProgramminTwoSum naiveSolution = new DynamicProgramminTwoSum(nums, S);
		naiveSolution.solve();
		
	}
}
