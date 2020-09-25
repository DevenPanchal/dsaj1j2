package com.balazsholczer.twosum;

public class App {

	/*
	 * The two sum problem is a common interview question (it is very similar to the
	 * subset sum problem)
	 * 
	 * THE PROBLEM: find all the pairs of two integers in an unsorted array of
	 * integers that sum up to a given S
	 * 
	 * [1,2,3,4] is the array and S=5 --> [1,4] and [2,3] are the solutions
	 * 
	 * - the naive solution has O(N^2) running time - we can use dynamic programming
	 * to reduce the running time to O(N) linear running time. This solution uses
	 * the first loop. O(N) time. But discards the second loop in favor of a
	 * Hashtable which is queried with the question whether it contains (sum S-
	 * number in first loop)? This will give the second pairing number that adds to
	 * S, if it is present. This take O(1) time. So the operation on the whole takes
	 * O(N)* O(1)= O(N) time
	 */

	public static void main(String[] args) {

		int[] nums = { 3, 5, 2, -4, 8, 11 };
		int S = 7;

		System.out.println("The Naive solution takes O(N^2) --");
		NaiveSolution ns = new NaiveSolution(nums, S);
		ns.solve();
		
		

		System.out.println("The DynamicProgramming solution takes O(N) --");
		DynamicProgramminTwoSum ds = new DynamicProgramminTwoSum(nums, S);
		ds.solve();

	}
}
