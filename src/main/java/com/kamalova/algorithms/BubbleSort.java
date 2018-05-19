package com.kamalova.algorithms;

public class BubbleSort {

    public static void main(String[] args) {
        int a[] = new int[]{5, 8, 2, 4, 8, 2, 0, 9};
        bubbleSort(a);
        int firstIndex = 0;
        int lastIndex = a.length - 1;
        SortUtils.arrayToPrint(a, firstIndex, lastIndex);

    }

    private static void bubbleSort(int[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 2 - i; j++) {
                if (a[j] > a[j + 1]) {
                    SortUtils.swapByIndex(a, j, j + 1);
                }
            }
        }
    }


}
