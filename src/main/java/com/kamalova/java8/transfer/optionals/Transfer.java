package com.kamalova.java8.transfer.optionals;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@AllArgsConstructor
@Getter
public class Transfer {
    private Optional<Person> person;
    private Optional<String> type;
}
