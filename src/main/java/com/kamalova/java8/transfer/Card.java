package com.kamalova.java8.transfer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Card {
    private Currency currency;
    private String tb;
}
