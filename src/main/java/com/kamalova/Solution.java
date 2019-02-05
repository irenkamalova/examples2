//package com.kamalova;
//
//import java.io.*;
//import java.util.*;
//
//class Solution {
//
//    static boolean isMatch(String text, String pattern) {
//
//        Stack<Character> s1 = new Stack<>();
//        Stack<Character> s2 = new Stack<>();
//
//        for (int i = 0; i < pattern.length(); i++) {
//            s1.push(pattern.charAt(i));
//        }
//        for (int i = 0; i < text.length(); i++) {
//            s2.push(text.charAt(i));
//        }
//
//        if (s1.empty()) return false;
//
//        while (!s1.empty()) {
//            Character c1 = s1.pop();
//            if (c1.equals('.')) {
//                if (s2.empty()) return false;
//                else s2.pop();
//            } else {
//                Character c2 = s1.pop();
//                if (c2.equals('*')) {
//                    Character c3 = s2.pop();
//                    if (c3.equals(c1)) {
//                        while (c3.equals(c1)) c3 = s2.pop();
//                    }
//                } else {
//                    Character c3 = s2.pop();
//                    if (!c2.equals(c3)) return false;
//                }
//            }
//        }
//        return true;
//        // your code goes here
//    }
//
//    public static void main(String[] args) {
//        System.out.println(isMatch("4", "."));
////        System.out.println(isMatch("4", "*"));
//        System.out.println(isMatch("abc", "a*c"));
//        System.out.println(isMatch("ab23c", "a*c"));
//        System.out.println(isMatch("abbc", "abc*"));
////        System.out.println(isMatch("bc", "*bc"));
//
////        System.out.println(isMatch("bc", "*b*"));
//
//        System.out.println(isMatch("bx", "a*b."));
//        System.out.println(isMatch("bxx", "a*b."));
//        System.out.println(isMatch("bx", "a*b.*"));
//        System.out.println(isMatch("bxx", "a*b.*"));
//
//        System.out.println();
//
//        System.out.println(isMatch("aa", "a"));
//        System.out.println(isMatch("aa", "aa"));
//        System.out.println(isMatch("abc", "a.c"));
//        System.out.println(isMatch("abbb", "ab*"));
//        System.out.println(isMatch("acd", "ab*c."));
//
//    }
//
////    static boolean isMatchStack(String text, String pattern) {
////        Stack<Character> s1 = new Stack<>();
////        Stack<Character> s2 = new Stack<>();
////
////        for (int i = 0; i < pattern.length(); i++) {
////            s1.push(pattern.charAt(i));
////        }
////        for (int i = 0; i < text.length(); i++) {
////            s2.push(text.charAt(i));
////        }
////
////        if (s1.empty()) return false;
////
////        while (!s1.empty()) {
////            Character c1 = s1.pop();
////            if (c1.equals('.')) {
////                if (s2.empty()) return false;
////                else s2.pop();
////            } else {
////                Character c2 = s1.pop();
////                if (c2.equals('*')) {
////                    Character c3 = s2.pop();
////                    if (c3.equals(c1)) {
////                        while (c3.equals(c1)) c3 = s2.pop();
////                    }
////                } else {
////                    Character c3 = s2.pop();
////                    if (!c2.equals(c3)) return false;
////                }
////            }
////        }
////        return true;
//
////    }
//
////    static boolean isMineMatch(String text, String pattern) {
////
////        int i = 0;
////        int j = 0;
////        char nextAllowedSymbol;
////        if (pattern.length() > 0) {
////            nextAllowedSymbol = pattern.charAt(0);
////        } else {
////            return text.length() == 0;
////        }
////
////        if (pattern.length() == 1 && nextAllowedSymbol == '*') return true; // pattern "*" is always true
////        if (pattern.length() == 1 && nextAllowedSymbol == '.')
////            return text.length() == 1; // pattern "." allowed any one symbol
////
////        while (i < pattern.length()) {
////            if (pattern.charAt(i) == '*') {
////                i++;
////                if (i == pattern.length()) return true; // if the last expr in pattern * we finish with OK
////                nextAllowedSymbol = pattern.charAt(i);
////                while (text.charAt(j) != nextAllowedSymbol) {
////                    j++;
////                    if (j == text.length()) {
////                        return false; // reached the end of the string and did't found allowed symbol
////                    }
////                }
////                // found allowed symbol
////                i++;
////                j++;
////            } else if (pattern.charAt(i) == '.') {
////                // in text must be next symbol
////                if (j < text.length()) {
////                    i++;
////                    j++;
////                } else {
////                    return false;
////                }
////            } else if (pattern.charAt(i) == text.charAt(j)) {
////                i++;
////                j++;
////            } else return false;
////        }
////        return !(j < text.length() && pattern.charAt(pattern.length() - 1) != '*');
////        // your code goes here
////    }
//}
//
//import java.io.*;
//        import java.util.*;
//
//class Solution {
//
//    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
//        // your code goes here
//        // arr = [0, -1, -2, 2, 1], k = 1
//        // -1 - (-2) = k = 1;
//        Set<Integer> set = new HashSet<>();
//        int diff = a[0] - k; // {-1}
//        // int[][] result = new int[arr.length * arr.length][2];
//        List<Pair<Integer, Integer>> list = new ArrayList<>();
//        set.add(a[0]);
//        set.add(diff);
//        for (int i = 1; i < arr.lenght(); i++) { // 4 a[3] = 1
//            if (set.containt(a[i])) {
//                int[] arrayInt = new int[] {k + a[i], a[i]}; // [2 , 1]
//                Pair<Integer, Integer> pair = new Pair<>(k + a[i], a[i]);
//                list.add(pair);
//                // result[j] = arrayInt; // res[0]
//                // j++;
//            }
//            // -1 set.add(2 - 1) = add (1)
//            set.add(a[i] - k); // {-1, -2, -3, }
//            // x - y = k => y = x - k
//        }
//        int[][] res = new res[list.size()][2];
//        return result;
//    }
//
//    public static void main(String[] args) {
//        // arr = [0, -1, -2, 2, 1], k = 1
//
//        // 0
//        // -1
//        // 0 - (-1) = k ?
//
//        // 0 = x (x - y) = k = 1 -> -1
//        // ? -1
//
//
//
//    }
//
//}