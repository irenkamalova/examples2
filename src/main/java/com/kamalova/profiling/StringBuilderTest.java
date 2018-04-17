package com.kamalova.profiling;

public class StringBuilderTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("0");
        for (int i = 0; i < 1_000_000; i++) {
            sb.append(i);
            sb.delete(0, 1);
        }
        System.out.println(sb.length());
        long end = System.currentTimeMillis();

        System.out.println("Worked for: " +
                 (end - start) / 1000 + " seconds " +
                (end - start) % 1000 + " milliseconds");
    }
}
