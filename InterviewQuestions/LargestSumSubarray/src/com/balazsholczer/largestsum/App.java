package com.balazsholczer.largestsum;

public class App {

	public static void main(String[] args) {
		
		int[] nums = {1,-2,3,4,-5,8};
		
		KadaneAlgorithm kadaneAlgorithm = new KadaneAlgorithm();
		
		System.out.println(kadaneAlgorithm.solve(nums));
		
	}
}
