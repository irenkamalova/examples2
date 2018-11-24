package com.kamalova;

public class StringExample {
    public static void main(String[] args) {
        String s1 = "string1";
        String s2 = "string2";
        String s3 = "string3";
        String s4 = "string4";

        StringBuilder sb = new StringBuilder();
        String result = sb.append(s1).append(' ')
                .append(s2).append(' ').
                        append(s3).append(' ')
                .append(s4).append(' ')
                .toString();
        System.out.println(result);
    }
}
