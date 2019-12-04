package com.balazsholczer.shell;

public class ShellSort {

    private int[] array;

    public ShellSort(int[] array) {
        this.array = array;
    }

    public void shellSort() {

        for (int gap = array.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < array.length; i++) {

                int val = array[i];
                int j = i;

                while ((j >= gap) && (array[j - gap] > val)) {
                    array[j] = array[j - gap];
                    j = j - gap;
                }

                array[j] = val;
            }
        }
    }

    public void showArray() {
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
    }
}
