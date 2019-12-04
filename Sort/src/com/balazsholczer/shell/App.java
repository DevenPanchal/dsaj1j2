package com.balazsholczer.shell;

public class App {

    public static void main(String[] args) {

        int[] nums = { 4,3,2,1 };
        ShellSort shellSort = new ShellSort(nums);
        shellSort.shellSort();
        shellSort.showArray();

    }
}
