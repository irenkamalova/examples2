package com.kamalova.java8.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FlatMapExample {
    public static void main(String[] args) {
        exampleThree();
    }

    private static void exampleThree() {
        Integer[] numbers1 = {1, 2, 3};
        Integer[] numbers2 = {3, 4};

        // result: { [1,3], [1,4], [2,3], [2,4], [3,3], [3,4] }
        List<List<Integer>> res = new ArrayList<>();
        for (Integer n1 : numbers1) {
            for (Integer n2 : numbers2) {
                List<Integer> intermediateList = new ArrayList<>();
                intermediateList.add(n1);
                intermediateList.add(n2);
                res.add(intermediateList);
            }
        }
        res.forEach(System.out::println);
        System.out.println();
        Arrays.stream(numbers1).map(n1 -> Arrays.stream(numbers2).map(n2 -> {
            List<Integer> intermediateList = new ArrayList<>();
            intermediateList.add(n1);
            intermediateList.add(n2);
            return intermediateList;
        }).collect(toList())).collect(toList()).forEach(System.out::println);
        System.out.println();
        Arrays.stream(numbers1).map(n1 -> Arrays.stream(numbers2).map(n2 -> {
            List<Integer> intermediateList = new ArrayList<>();
            intermediateList.add(n1);
            intermediateList.add(n2);
            return intermediateList;
        }).flatMap(p -> Arrays.stream(p.toArray())).collect(toList())).collect(toList()).forEach(System.out::println);

        System.out.println();
        Arrays.stream(numbers1)
                .map(n1 -> Arrays.stream(numbers2).map(n2 -> {
            List<Integer> intermediateList = new ArrayList<>();
            intermediateList.add(n1);
            intermediateList.add(n2);
            return intermediateList;
        }).collect(toList())).flatMap(p -> Arrays.stream(p.toArray())).collect(toList()).forEach(System.out::println);
        System.out.println();
        Arrays.stream(numbers1)
                .flatMap(n1 -> Arrays.stream(numbers2).map(n2 -> new int[]{n1, n2}))
                .forEach(System.out::println);
        System.out.println();

        List<Integer> numbers01 = Arrays.asList(1, 2, 3);
        List<Integer> numbers02 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers01.stream()
                .flatMap(i -> numbers02.stream().map(j -> new int[]{i, j}))
                .collect(toList());

        for (int[] in : pairs) {
            System.out.println("[" + in[0] + ", " + in[1] + "]");
        }
        System.out.println();
        pairs.forEach(in -> System.out.println("[" + in[0] + ", " + in[1] + "]"));

        System.out.println();
        pairs.forEach(in -> Arrays.stream(in).forEach(System.out::println));

        // filter pairs that divisible by 3:
        // (2, 4), (3, 3)

        // quite right
        Arrays.stream(numbers1)
                .flatMap(n1 -> Arrays.stream(numbers2).map(n2 -> new int[]{n1, n2}))
                .filter(n3 -> (n3[0] + n3[1]) % 3 == 0)
                .forEach(in -> System.out.println("[" + in[0] + ", " + in[1] + "]"));
        System.out.println();

        // from book
        Arrays.stream(numbers1)
                .flatMap(n1 -> Arrays.stream(numbers2)
                        .filter(n2 -> (n1 + n2) % 3 == 0)
                        .map(n2 -> new int[]{n1, n2}))
                .forEach(in -> System.out.println("[" + in[0] + ", " + in[1] + "]"));
        System.out.println();


        Stream<Stream<int[]>> streamStream = Arrays.stream(numbers1)
                .map(n1 -> Arrays.stream(numbers2)
                        .filter(n2 -> (n1 + n2) % 3 == 0)
                        .map(n2 -> new int[]{n1, n2}));


    }

    private static void exampleTwo() {
        Integer[] numbers = {1, 2, 3, 4, 5};
        // 1 - useless
        Arrays.stream(numbers).peek(p -> p = p + p).collect(toList())
                .forEach(System.out::println);

        Arrays.stream(numbers).map(p -> Math.pow(p, 2)).forEach(System.out::println);
        Arrays.stream(numbers).map(p -> p * p).forEach(System.out::println);
    }

    private static void exampleOne() {
        String[] strings = {"Thanks","for", "fish!"};
        Stream<String[]> stream = Arrays.stream(strings).map(word -> word.split(""));
        Arrays.stream(strings).map(word -> word.split("")).forEach(System.out::println);
        // Stream<String[]> :(

        // ! от Stream как такового нельзя вызвать метод forEach ...
        stream.collect(toList()).forEach(System.out::println);

        Stream<Stream<String>> streamStream = Arrays
                .stream(strings)
                .map(word -> word.split(""))
                .map(Arrays::stream);

        // всё ещё не то!
        streamStream.collect(toList()).forEach(System.out::println);

        Stream<String> stringStream = Arrays
                .stream(strings)
                .map(word -> word.split(""))
                .distinct() // здесь бесполезен!
                .flatMap(Arrays::stream)
                .distinct();
        // Bingo! :)

        stringStream.collect(toList()).forEach(System.out::print);
    }
}
