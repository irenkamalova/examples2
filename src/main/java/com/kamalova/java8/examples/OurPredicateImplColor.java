package com.kamalova.java8.examples;

import lombok.AllArgsConstructor;

import java.awt.*;

@AllArgsConstructor
public class OurPredicateImplColor implements OurPredicate<JavaEight.Apple> {
    private Color color;

    @Override
    public boolean test(JavaEight.Apple apple) {

        return apple.getColor().equals(color) || apple.getColor().equals(Color.GREEN);
    }
}
