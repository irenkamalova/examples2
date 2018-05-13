package com.kamalova.algorithms;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class QSort {
    private static int[] a;

    private static IntConsumer printArray = (i) -> System.out.print(i + " ");

    public static void main(String[] args) {
        a = new int[]{6, 1, 7, 9, 3, 8, 2, 2, 5, 5, 5, 4, 0, -1};
        sortByMedian(0, a.length - 1);
        Arrays.stream(a).forEach(printArray);
    }


    private static void sortByMedian(int firstIndex, int lastIndex) {

        arrayToPrint(firstIndex, lastIndex);

        if (lastIndex - firstIndex == 0)
            return;

        if (lastIndex - firstIndex == 1) {
            if (a[firstIndex] > a[lastIndex])
                swapByIndex(firstIndex, lastIndex);
            return;
        }
        int medianIndex = firstIndex + (lastIndex - firstIndex) / 2;
        int median = a[medianIndex];
        System.out.println("median=" + median);

        int i = firstIndex;
        int j = lastIndex;
        while (i < j) {
            if ((a[i] > median) && (a[j] <= median)) {
                swapByIndex(i, j);
                if (i < j)
                    i++;
                if (i < j)
                    j--;
            }
            if (a[i] <= median && i < j)
                i++;
            if (a[j] > median && i < j)
                j--;
        }

        arrayToPrint(firstIndex, lastIndex);

        if (j == lastIndex && a[j] < median) {
            swapByIndex(medianIndex, j);
        }

        if (i == j) {
            if (a[i] > median) {
                i--;
            } else if (a[j] <= median && j < lastIndex) {
                j++;
            } else {
                i--;
            }
        }
        
        sortByMedian(firstIndex, i);
        sortByMedian(j, lastIndex);
    }

    private static void swapByIndex(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void arrayToPrint(int f, int l) {
        for (int i = f; i <= l; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
