package com.kamalova.java8.examples;

public class LambdaRunnableExample {

    public static void process(Runnable r) {
        r.run();
    }

    public static void main(String[] args) {
        // Default
        Runnable r0 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello 0");
            }
        };

        // Lambda inline
        Runnable r1 = () -> System.out.println("Hello 1");

        process(r0);
        process(r1);
        process(() -> System.out.println("Hello 2"));

    }
}
