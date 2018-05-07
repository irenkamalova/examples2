package com.kamalova.java8.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;
import java.util.function.Predicate;

public class WorkWithFiles {

    public static void main(String[] args) throws IOException {
        String fileName = "test.txt";

        workWithFile(fileName, BufferedReader::readLine);

        workWithFile(fileName, (BufferedReader br) -> br.readLine() + br.readLine());

        workWithFile(fileName, (BufferedReader br) -> br.lines().reduce(String::concat).orElse("Empty file"));

        Predicate<String> nonEmptyStrings = (String s) -> !s.isEmpty();

        workWithFile(fileName, (BufferedReader br) ->
                "Count of non-empty strings is " + String.valueOf(br.lines().filter(nonEmptyStrings).count()));

        workWithFile(fileName, (BufferedReader br) ->
                "Count of empty strings is " + String.valueOf(br.lines().filter(String::isEmpty).count()));

        workWithFile(fileName, (BufferedReader br) ->
                "Summary count of strings is " + String.valueOf(br.lines().count()));

        Function<BufferedReader, String> func = (BufferedReader br) -> {
            try {
                return br.readLine();
            } catch (IOException e) {
                // never do like this
                throw new RuntimeException();
            }
        };

        workWithFileByFunction(fileName, func);

        com.kamalova.java8.file.Object o = () -> System.out.println("Tricky example");

    }

    private static void workWithFile(String fileName, FileProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String result = p.process(br);
            System.out.println(result);
        }
    }

    private static void workWithFileByFunction(String fileName, Function<BufferedReader, String> function) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String result = function.apply(br);
            System.out.println(result);
        }
    }
}
