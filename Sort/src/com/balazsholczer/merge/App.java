package com.balazsholczer.merge;

public class App {

    public static void main(String[] args) {

        int[] nums = { 1,2,3,1,2,3 };

        MergeSort mergeSort = new MergeSort(nums);
        mergeSort.mergeSort(0, nums.length - 1);
        mergeSort.showResult();
    }
}
