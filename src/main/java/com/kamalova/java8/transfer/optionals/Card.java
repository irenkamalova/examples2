package com.kamalova.java8.transfer.optionals;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@AllArgsConstructor
@Getter
public class Card {
    private Optional<Currency> currency;
    private String tb;
}
