package com.kamalova.java8.examples;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

//import jdk.management.resource.ResourceId;

public class JavaEight {

    static void init(EmptyInterface e) throws IOException {
        e.empty();
        EmptyInterface e2 = System.out::println;
    }

    public static void main(String[] args) {

        Comparator<Apple> byWeight = Comparator.comparing(Apple::getWeight);

        // Lambda can throw exception - just function inside lambda will throw it!
        EmptyInterface e = () -> {
            throw new IOException();
        };
//        init(e);

        // Упражнение: написать несколько lambda-функций и пользоваться подсказками идеи
//        ResourceId resourceId = () -> "tram";
        Comparator<Integer> integerComparator = (Integer x, Integer y) -> (Integer) (x + y);
        Function<String, String> func = (String s) -> "tram";


        ArrayList<Apple> apples;
        apples = new ArrayList<>();

        List<Apple> list = new ArrayList<>();
        OurPredicate<Apple> predicate = new OurPredicateImplColor(Color.GREEN);

        OurPredicate<Apple> green = (Apple apple) -> apple.getColor().equals(Color.YELLOW);
        OurPredicate<Apple> weightGreater150 = (Apple a) -> a.getWeight() > 150;
        OurPredicate<Apple> weightGreater150_2 = new OurPredicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 150;
            }
        };

        java.util.function.Predicate<Apple> predicateGreen =
                apple -> apple.getColor().equals(Color.GREEN);
        java.util.function.Predicate<Apple> predicateYellow =
                apple -> apple.getColor().equals(Color.YELLOW);
        java.util.function.Predicate<Apple> predicateYellowOrGreen =
                predicateGreen.or(predicateYellow);

        Consumer<Integer> consumer = (Integer i) -> System.out.println(i);
        Integer integer = 24;
        consumer.accept(integer);

        Supplier<Integer> supplier = () -> 42;
        Integer answer = supplier.get();

        Function<String, Integer> stringIntegerFunction =
                (String s) -> Integer.valueOf(s);
        String s1 = "42";
        Integer answer2 = stringIntegerFunction.apply(s1);


        List<Apple> appleList = apples.stream().filter(predicateYellowOrGreen).collect(Collectors.toList());


        list = getListByColor(predicate, apples);
        List<Apple> list2 = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getColor().equals(Color.YELLOW)) {
                list2.add(apple);
            }
        }


        apples.sort(byWeight);
        apples.forEach(System.out::println);

        //5
        Integer i = 5;
        List<Apple> greenApples = filterByPredicate(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                i.toString();
                return Color.GREEN.equals(apple.getColor());
            }
        });

        Comparator<Apple> appleComparator =
                (apple, apple2) -> apple.getWeight().compareTo(apple2.getWeight());

        apples.sort(appleComparator);


//        i = 6;

        //6
//        List<Apple> greenApples6 = filterByPredicate(apples,
//                (Apple apple) -> {
//            i.toString();
//            Color.GREEN.equals(apple.getColor());
//        });

        List<Integer> oldList = new ArrayList<>();
        //7
//        List<Integer> list = filterByPredicate0(oldList, (Integer i) -> (i % 2 == 0));

        //One more example of beh parametrization
        Thread t = new Thread(() -> System.out.println("Hello world"));
        //And one more
        // button.setOnAction((ActionEvent event) -> label.setText("Sent!!"));

        // implicit and explicit type:
        Comparator<Apple> c = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());
        Comparator<Apple> c2 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

//        (Apple a) -> a.getWeight(); --> Apple::getWeight

        // Last solution
        Comparator<Apple> appleComparator1 = Comparator.comparing(Apple::getWeight);


        Comparator<Apple> c3 = Comparator.comparing(Apple::getWeight);
        // Reverse order
        Comparator<Apple> c4 = Comparator.comparing(Apple::getWeight);
//                .reversed().thenComparing();


//        (Double d, Long l, String r) -> System.out.println(l + d + r);

    }

    public static List<Apple> getListByColor(OurPredicate p, List<Apple> apples) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if (p.test(apple)) {
                list.add(apple);
            }
        }
        return list;
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
    public static <T> List<T> filterByPredicate0(List<T> oldThings, Predicate<T> predicate) {
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
//interface Predicate<T> {
//    boolean test(T t);
//}

