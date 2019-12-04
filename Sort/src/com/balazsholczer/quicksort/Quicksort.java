package com.balazsholczer.quicksort;

public class Quicksort {

    private int[] nums;

    public Quicksort(int[] nums) {
        this.nums = nums;
    }
    
    public void sort() {
        quicksort(0, nums.length - 1);
    }
    
    public void showArray() {
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + "  ");
        }
    } 

    private int partition(int low, int high) {

        int pivotIndex = (low + high) / 2; // random index maybe better
        swap(pivotIndex, high);  // set the pivot to the end of list 

        int i = low;

        for (int j = low; j < high; ++j) {
            if (nums[j] <= nums[high]) {
                swap(i, j);
                i++;
            }
        }

        swap(i, high); // swap back the pivot

        return i;
    }

    private void quicksort(int low, int high) {

        if (low >= high) {
            return;
        }

        int pivotIndex = partition(low, high);
        quicksort(low, pivotIndex - 1);
        quicksort(pivotIndex + 1, high);

    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
