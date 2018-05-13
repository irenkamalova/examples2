package com.kamalova.java8.simpliestExamples;

public class Example {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Message");
            }
        };

        Runnable r = () -> {
            System.out.println(5 + 5);
            System.out.println("Hello!");
            System.out.println("Message");
        };
//        r.run();
        Thread t = new Thread(r);
        t.start();

    }
}
