package com.kamalova.java8.examples;

@FunctionalInterface
public interface OurPredicate<T> {
    boolean test(T t);
}
