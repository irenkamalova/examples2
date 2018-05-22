package com.kamalova.algorithms;

public class RadixSort {

    public static void main(String[] args) {
//        int[] array = new int[]{207, 437, 32, 9, 47, 2, 115};
        int[] array = new int[]{207, 45, 1};
        radixSort(array);

    }

    private static void radixSort(int[] a) {
        // ищем количество разрядов
        int rank = getRank(a);
        for (int index = rank - 1; index >= 0; index--) {
            int[] b = countDigits(a, index);
            ArrayUtils.arrayToPrint(b, 0, b.length - 1);
            int[] c = preparePlacesForDigits(b);
            ArrayUtils.arrayToPrint(c, 0, c.length - 1);
            int[] d = replaceNumberInArray(c, a, index);
            ArrayUtils.arrayToPrint(d, 0, d.length - 1);
            System.arraycopy(d, 0, a, 0, a.length);
            ArrayUtils.arrayToPrint(a, 0, a.length - 1);
        }

    }

    private static int[] replaceNumberInArray(int[] c, int[] a, int index) {
        int[] d = new int[a.length];
        for (int i = 0; i < d.length; i++) {
            int digit = getDigit(a[i], index);
            d[c[digit]] = a[i];
            c[digit]++;
        }
        return d;
    }

    private static int[] preparePlacesForDigits(int[] b) {
        //мы знаем, сколько у нас 0, 1, 2, ...
        //мы должны подготовить индексы для массива,
        //в котором будет содержать подситанное количество цифр
        int[] c = new int[10];
        c[0] = 0;
        int j = 0;
        for (int i = 1; i < b.length; i++) {
            if (b[i] != 0) {
                c[j] = c[i - 1] + b[i - 1];
            }
        }
        return b;
    }

    private static int[] countDigits(int[] a, int index) {
        int[] b = new int[10];
        // b[0] содержит количество элементов, заканчивающих на 0 и т.д.
        for (int i = 0; i < a.length; i++) {
            int digit = getDigit(a[i], index);
            b[digit]++;
        }
        return b;
    }

    private static int getDigit(int number, int index) {
        StringBuilder s = new StringBuilder(String.valueOf(number));
        while (s.length() < index + 1) {
            s.insert(0, '0');
        }
        char c = s.toString().charAt(index);
        return Integer.parseInt(String.valueOf(c));
    }

    private static int getRank(int[] a) {
        int max = getMaxElement(a);
        String s = String.valueOf(max);
        int rank = s.length();
        System.out.println("Rank is: " + rank);
        return rank;
    }

    private static int getMaxElement(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];

        }
        System.out.println("Max element is: " + max);
        return max;
    }
}
