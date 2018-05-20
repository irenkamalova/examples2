package com.kamalova.algorithms;

import java.util.function.IntConsumer;

class ArrayUtils {

    static IntConsumer printArray = (i) -> System.out.print(i + " ");

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void arrayToPrint(int[] a, int f, int l) {
        for (int i = f; i <= l; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}
