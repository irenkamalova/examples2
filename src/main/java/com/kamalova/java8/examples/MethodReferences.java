package com.kamalova.java8.examples;

import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.function.Function;

public class MethodReferences {

    public static void main(String[] args) {
        String s = "Hello";
//        int a = String::length;
//        - only for lambda
        Predicate<String> p = String::isEmpty;

        // очень смущает, что вы не указываете передающийся аргумент String
        Function<String, Integer> stringParseToInt = Integer::parseInt;


    }
}
