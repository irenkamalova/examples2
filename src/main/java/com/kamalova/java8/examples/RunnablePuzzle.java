package com.kamalova.java8.examples;

public class RunnablePuzzle {
    public static final int value = 11;
    void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;
            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }

    public static void main(String[] args) {
        RunnablePuzzle runnablePuzzle = new RunnablePuzzle();
        runnablePuzzle.doIt();
    }

}
