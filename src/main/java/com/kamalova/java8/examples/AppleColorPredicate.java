package com.kamalova.java8.examples;

import java.awt.*;

public class AppleColorPredicate implements ApplePredicate {
    /**
     * You’ve achieved something really cool:
     * the behavior of the filterApples method depends on the code you
     * pass to it via the ApplePredicate object.
     * In other words, you’ve parameterized the behavior of the filterApples method!
     * @param apple
     * @return
     */
    @Override
    public boolean test(JavaEight.Apple apple) {
        return apple.getColor() == Color.green;
    }
}
