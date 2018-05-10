package com.kamalova.java8.transfer.optionals;

import java.util.Optional;

public class GetCurrency {
    public static void main(String[] args) {
        Currency currency = new Currency("RUB");
        Card card = new Card(Optional.of(currency), "38");
        Person person = new Person(Optional.of(card), 77);
        Transfer transfer = new Transfer(Optional.of(person), Optional.of("card"));

        Optional<String> currencyCode;
//        Optional.ofNullable(transfer).ifPresent(
//                        t -> {
//                            Optional.ofNullable(transfer.getPerson()).ifPresent(
//                                    p -> Optional.ofNullable(Optional.ofNullable(p.getCard()).ifPresent();)
//                            );
//                        }
//        );

        currencyCode = Optional.ofNullable(transfer)
                .map(Transfer::getPerson)
                .map(Person::getCard)
                .map(Card::getCurrency)
                .map(Currency::getCode);
        System.out.println(currencyCode);

        Optional<Optional<Person>> person1 = Optional.ofNullable(transfer)
                .map(Transfer::getPerson);
        // на что похоже?

        Optional<Person> p = person1.get();

        currencyCode = Optional.ofNullable(transfer)
                .map(Transfer::getPerson)
                .get()
                .map(Person::getCard)
                .get()
                .map(Card::getCurrency)
                .get()
                .map(Currency::getCode);



        System.out.println(currencyCode);






    }
}
