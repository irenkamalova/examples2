package com.kamalova.algorithms;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{6, 1, 7, 9, 3, 8, 2, 2, 5, 5, 5, 4, 0, -1};
        Arrays.stream(a).forEach(ArrayUtils.printArray);
        System.out.println();
        System.out.println();
        mergeSort(a, 0, a.length - 1);
        Arrays.stream(a).forEach(ArrayUtils.printArray);
    }

    static void mergeSort(int[] a, int firstIndex, int lastIndex) {
        int[] b = new int[a.length];

        if (lastIndex - firstIndex == 0) {
            return;
        }
        if (lastIndex - firstIndex == 1) {
            if (a[firstIndex] > a[lastIndex])
                ArrayUtils.swap(a, firstIndex, lastIndex);
            return;
        }

        int m = firstIndex + (lastIndex - firstIndex) / 2;
        int bound1;
        int bound2;
        if ((lastIndex - firstIndex) % 2 == 1) {
            bound1 = m;
            bound2 = m + 1;
        } else {
            bound1 = m - 1;
            bound2 = m;
        }
        System.out.println();
        ArrayUtils.arrayToPrint(a, firstIndex, bound1);
        ArrayUtils.arrayToPrint(a, bound2, lastIndex);

        mergeSort(a, firstIndex, bound1);
        mergeSort(a, bound2, lastIndex);

        merge(a, firstIndex, bound1, bound2, lastIndex);

    }

    private static void merge(int[] a, int firstIndexOfFirstArray,
                              int lastIndexOfFirstArray,
                              int firstIndexOfSecondArray,
                              int lastOfIndexOfSecondArray) {

        int[] b = new int[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        // - хотя тут неоптимально: копируем весь массив, а хотим лишь кусочек

        int i = firstIndexOfFirstArray;
        int j = firstIndexOfSecondArray;
        int k = firstIndexOfFirstArray;

        while (i <= lastIndexOfFirstArray && j <= lastOfIndexOfSecondArray) {
            if (b[i] < b[j]) {
                a[k] = b[i];
                i++;
            } else {
                a[k] = b[j];
                j++;
            }
            k++;
        }

        // ! нам достаточно скопировать элементы из левой части, если мы её
        // полностью не прошли. т.к. элементы правой части и так уже в массиве а! :)
        int r = lastIndexOfFirstArray - i;
        // при таком подходе здесь - самая жесткая часть с индексами :(
        for (int index = 0; index <= r; index++) {
            a[k + index] = b[i + index];
        }

        System.out.println("Result is:");
        ArrayUtils.arrayToPrint(a, firstIndexOfFirstArray, lastOfIndexOfSecondArray);

//        replace(a, b, firstOfFirst, lastOfSecond);


    }

    private static void replace(int[] a, int[] b,
                                int firstOfFirst, int lastOfSecond) {
        for (int i = 0, j = firstOfFirst; i < b.length; i++, j++) {
            a[j] = b[i];
        }
    }


}
