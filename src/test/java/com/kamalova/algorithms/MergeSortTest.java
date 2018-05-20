package com.kamalova.algorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortTest {
    @Test
    public void test1() {
        int[] a = new int[]{10, 9, 8, 7, 6, 4, 3, 2, 1};
        testA(a);
    }
    @Test
    public void test2() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        testA(a);
    }
    @Test
    public void test1_1() {
        int[] a = new int[]{11, 10, 9, 8, 7, 6, 4, 3, 2, 1};
        testA(a);
    }
    @Test
    public void test3() {
        int[] a = new int[]{6, 1, 7, 9, 9, 9, 3, 20, 5, 5, 5, 4, 0, -1, 11};
        testA(a);
    }
    @Test
    public void test4() {
        int[] a = new int[]{6, 1, 7, 9, 9, 9, 3, -20, 5, 5, 5, 4, 0, -1, 11};
        testA(a);
    }
    @Test
    public void test5() {
        int[] a = new int[]{6, 6, 6, 6};
        testA(a);
    }

    @Test
    public void test6() {
        int[] a = new int[]{6, 6, 6, 6, 6};
        testA(a);
    }

    private void testA(int[] a) {
        int[] testedArray = new int[a.length];
        System.arraycopy(a, 0, testedArray, 0, a.length);
        MergeSort.mergeSort(testedArray,0, a.length - 1);
        a = Arrays.stream(a).sorted().toArray();
        Assert.assertArrayEquals(a, testedArray);
    }


}