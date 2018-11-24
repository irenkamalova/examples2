package com.kamalova;

import java.io.*;
import java.util.*;

class Solution {

    static boolean isMatch(String text, String pattern) {

        int i = 0;
        int j = 0;
        char nextAllowedSymbol;
        if (pattern.length() > 0) {
            nextAllowedSymbol = pattern.charAt(0);
        } else {
            return text.length() == 0;
        }

        if (pattern.length() == 1 && nextAllowedSymbol == '*') return true; // pattern "*" is always true
        if (pattern.length() == 1 && nextAllowedSymbol == '.') return text.length() == 1; // pattern "." allowed any one symbol

        while (i < pattern.length()) {
            if (pattern.charAt(i) == '*') {
                i++;
                if (i == pattern.length()) return true; // if the last expr in pattern * we finish with OK
                nextAllowedSymbol = pattern.charAt(i);
                while (text.charAt(j) != nextAllowedSymbol) {
                    j++;
                    if (j == text.length()) {
                        return false; // reached the end of the string and did't found allowed symbol
                    }
                }
                // found allowed symbol
                i++; j++;
            }
            else if (pattern.charAt(i) == '.') {
                // in text must be next symbol
                if (j < text.length()) {
                    i++; j++;
                } else {
                    return false;
                }
            }
            else if (pattern.charAt(i) == text.charAt(j)) {
                i++; j++;
            } else return false;
        }
        return !(j < text.length() && pattern.charAt(pattern.length() - 1) != '*');
        // your code goes here
    }

    public static void main(String[] args) {
        System.out.println(isMatch("4", "."));
        System.out.println(isMatch("4", "*"));
        System.out.println(isMatch("abc", "a*c"));
        System.out.println(isMatch("ab23c", "a*c"));
        System.out.println(isMatch("abbc", "abc*"));
        System.out.println(isMatch("bc", "*bc"));

        System.out.println(isMatch("bc", "*b*"));

        System.out.println(isMatch("bx", "*b."));
        System.out.println(isMatch("bxx", "*b."));
        System.out.println(isMatch("bx", "*b.*"));
        System.out.println(isMatch("bxx", "*b.*"));

        System.out.println();

        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("abc", "a.c"));
        System.out.println(isMatch("abbb", "ab*"));
        System.out.println(isMatch("acd", "ab*c."));

    }

}