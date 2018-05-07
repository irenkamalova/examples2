package com.kamalova.java8.examples;

import com.kamalova.java8.examples.EmptyInterface;
import jdk.management.resource.ResourceId;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaEight {

    static void init(EmptyInterface e) throws IOException {
        e.empty();
        EmptyInterface e2 = System.out::println;
    }

    public static void main(String[] args) {

        Comparator<Apple> byWeight = Comparator.comparing(Apple::getWeight);

        // Lambda can throw exception - just function inside lambda will throw it!
        EmptyInterface e = () -> { throw new IOException();};
//        init(e);

        // Упражнение: написать несколько lambda-функций и пользоваться подсказками идеи
        ResourceId resourceId = () -> "tram";
        Comparator<Integer> integerComparator = (Integer x, Integer y) -> (Integer) (x + y);
        Function<String, String> func = (String s) -> "tram";


        ArrayList<Apple> apples;
        apples = new ArrayList<>();
        apples.sort(byWeight);
        apples.forEach(System.out::println);

        //5
        List<Apple> greenApples = filterByPredicate(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.GREEN.equals(apple.getColor());
            }
        });

        //6
        List<Apple> greenApples6 = filterByPredicate(apples,
                (Apple apple) ->  Color.GREEN.equals(apple.getColor()));

        List<Integer> oldList = new ArrayList<>();
        //7
        List<Integer> list = filterByPredicate0(oldList, (Integer i) -> (i % 2 == 0));

        //One more example of beh parametrization
        Thread t = new Thread(() -> System.out.println("Hello world"));
        //And one more
        // button.setOnAction((ActionEvent event) -> label.setText("Sent!!"));

        // implicit and explicit type:
        Comparator<Apple> c = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());
        Comparator<Apple> c2 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

//        (Apple a) -> a.getWeight(); --> Apple::getWeight

        // Last solution
        Comparator<Apple> c3 = Comparator.comparing(Apple::getWeight);
        // Reverse order
        Comparator<Apple> c4 = Comparator.comparing(Apple::getWeight).reversed();


    }

    // прямо как с переводом в различные сервисы?
    public static List<Apple> filterGreenApple(List<Apple> apples, Color color) {
        List<Apple> greenApples = new ArrayList<>();
        for (Apple apple : apples) {
//            if (Color.GREEN.equals(apple.getColor()))
            if (color.equals(apple.getColor()))
                greenApples.add(apple);
        }
        return greenApples;
    }

    //  it breaks the DRY
    public static List<Apple> filterWeightApple(List<Apple> apples, int weight) {
        List<Apple> weightApples = new ArrayList<>();
        for (Apple apple : apples) {
//            if (Color.GREEN.equals(apple.getColor()))
            if (apple.getWeight() > weight)
                weightApples.add(apple);
        }
        return weightApples;
    }
    //7
    public static  <T> List<T> filterByPredicate0(List<T> oldThings, Predicate<T> predicate) {
        List<T> things = new ArrayList<>();
        for (T t : things) {
            if (predicate.test(t))
                things.add(t);
        }
        return things;
    }

    //8
    public <T> List<T> filterByPredicate2(List<T> oldThings, Predicate<T> predicate) {
        return oldThings.stream().filter(predicate::test).collect(Collectors.toList());
    }



    //4
    public static List<Apple> filterByPredicate(List<Apple> apples, ApplePredicate predicate) {
        List<Apple> weightApples = new ArrayList<>();
        for (Apple apple : apples) {
//            if (Color.GREEN.equals(apple.getColor()))
            if (predicate.test(apple))
                weightApples.add(apple);
        }
        return weightApples;
    }

    class Apple {
//        @Getter
        private Integer weight;

        private Color color;

        public Color getColor() {
            return color;
        }

        public Integer getWeight() {
            return weight;
        }
    }

}

//7
interface Predicate<T> {
    boolean test(T t);
}

