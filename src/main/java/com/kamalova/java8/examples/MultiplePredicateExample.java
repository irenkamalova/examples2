package com.kamalova.java8.examples;

import com.kamalova.java8.examples.Apple;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class MultiplePredicateExample {

    public static void main(String[] args) {
        Predicate<Apple> green = a -> a.getColor().equals(Color.GREEN);
        Predicate<Apple> yellow = a -> a.getColor().equals(Color.YELLOW);
        Predicate<Apple> red = a -> a.getColor().equals(Color.RED);

        Predicate<Apple> greater150 = a -> a.getWeight() > 150;

        Predicate<Apple> redAndGreen = green.and(red);

        List<Apple> appleList = new ArrayList<>();

        List<Apple> filteredApples = appleList.stream()
                .filter(green)
                .filter(yellow)
                .filter(red)
                .collect(Collectors.toList());

        List<Apple> apples = appleList.stream().
                filter(green.and(red).and(yellow).and(greater150)).collect(Collectors.toList());

        apples.forEach(System.out::println);


        filteredApples.forEach(apple -> {
            if(redAndGreen.test(apple)) {
                System.out.println(apple);
            }
        });

        filteredApples.stream().filter(green).forEach(System.out::println);

        filteredApples.stream().filter(green.and(red).and(yellow)).forEach(System.out::println);

        appleList.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getAge)
                .reversed());


    }
}
