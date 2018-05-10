package com.kamalova.java8.examples;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class StreamsComparator {

    public static void main(String[] args) {
        testThree();
    }

    private static void testThree() {

        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("pork", 200, Boolean.FALSE, "meat"));
        menu.add(new Dish("chicken", 100, Boolean.FALSE, "meat"));
        menu.add(new Dish("salmon", 100, Boolean.FALSE, "fish"));
        menu.add(new Dish("salad", 50, Boolean.TRUE, "other"));
        List<String> dishNames = menu.parallelStream().filter(d -> {
            System.out.println("filter: " + d);
            return !d.getVegan();
        }).map(d -> {
            System.out.println("mapped: " + d);
            return d.getName();
        }).collect(Collectors.toList());

        dishNames.forEach(System.out::println);
        /*
        filter: pork
        mapped: pork
        filter: chicken
        mapped: chicken
        filter: salmon
        mapped: salmon
        filter: salad
         */
    }

    private static void testTwo() {
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("pork", 200, Boolean.FALSE, "meat"));
        menu.add(new Dish("chicken", 100, Boolean.FALSE, "meat"));
        menu.add(new Dish("salmon", 100, Boolean.FALSE, "fish"));
        menu.add(new Dish("salad", 50, Boolean.TRUE, "other"));
        // ToMAP!
        Map<String, List<Dish>> map = menu.stream().collect(groupingBy(Dish::getType));
        map.entrySet().forEach(System.out::println);
        /*
        other=[salad]
        fish=[salmon]
        meat=[pork, chicken]
        */
    }

    private static void testOne() {

        List<Dish> menu = new ArrayList<>();
        init(menu);

        long start0 = System.currentTimeMillis();
        List<Dish> dishList0 = menu.stream()
                .sorted(Comparator.comparing(Dish::getCalories).reversed()
                        .thenComparing(Dish::getName).reversed())
//                .filter(Dish::getVegan)
                .collect(Collectors.toList());
        long finish0 = System.currentTimeMillis();
        System.out.println(dishList0.size());
        System.out.println("Stream time: " + String.valueOf(finish0 - start0));

        long start1 = System.currentTimeMillis();
        List<Dish> dishList1 = menu.parallelStream()
                .sorted(Comparator.comparing(Dish::getCalories).reversed()
                        .thenComparing(Dish::getName).reversed())
//                .filter(Dish::getVegan)
                .collect(Collectors.toList());
        long finish1 = System.currentTimeMillis();
        System.out.println(dishList1.size());
        System.out.println("Stream time: " + String.valueOf(finish1 - start1));

//        dishList1.forEach(System.out::println);
        /*
        Result:
        10000
        Stream time: 57
        10000
        Stream time: 17

         */

    }

    private static void init(List<Dish> menu) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Dish dish = new Dish(String.valueOf(random.nextInt(10)),
                    random.nextInt(10),
                    random.nextBoolean(),
                    "meat");
            menu.add(dish);
        }
    }
}

@Getter
@AllArgsConstructor
class Dish {
    private String name;
    private Integer calories;
    private Boolean vegan;
    private String type;

    @Override
    public String toString() {
        return name;
    }
}
