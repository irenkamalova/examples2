package com.kamalova.java8.examples;

import java.util.Arrays;

public class LambdaExamples {
    private int field;
    private static int staticField;

    public static void main(String[] args) {
        int portNumber = 1337;
//        Runnable r = () -> System.out.println(portNumber);
        portNumber = 123;

//        Runnable r0 = () -> System.out.println(this.field);

//        Runnable r1 = () -> System.out.println(staticField);

        String s = "";
//        Runnable r2 = () -> System.out.println(s.isEmpty());

        s = "fj";
//        Runnable r3 = () -> System.out.println(Arrays.toString(s.getBytes()));


    }
}
