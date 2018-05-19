package com.kamalova.algorithms;

public class SortUtils {

    public static void swapByIndex(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void arrayToPrint(int[] a, int f, int l) {
        for (int i = f; i <= l; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
