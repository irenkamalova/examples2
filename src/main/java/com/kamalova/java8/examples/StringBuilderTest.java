package com.kamalova.java8.examples;

public class StringBuilderTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int j = 0; j < 1000l; j++) {
            app();
        }

        long end = System.currentTimeMillis();

        System.out.println("Worked for: " +
                (end - start) / 1000 + " seconds " +
                (end - start) % 1000 + " milliseconds");
    }

    private static void app() {
        StringBuilder sb = new StringBuilder(1000_000_000);
        sb.append("123");
        for (long i = 0; i < 1_000_000_000L; i++) {
            sb.delete(1, 2);
            sb.append('i');
        }
        System.out.println(sb.length());
    }
}
