package com.kamalova.java8.transfer;

import java.util.Optional;

public class GetCurrency {

    public static void main(String[] args) {
        Currency currency = new Currency("RUB");
        Card card = new Card(currency, "38");
        Person person = new Person(card, 77);
        Transfer transfer = new Transfer(person, "card");

        String code;
        if (transfer != null) {
            if (transfer.getPerson() != null) {
                if (transfer.getPerson().getCard() != null) {
                    if (transfer.getPerson().getCard().getCurrency() != null) {
                        if (transfer.getPerson().getCard().getCurrency().getCode() != null) {
                            code = transfer.getPerson().getCard().getCurrency().getCode();
                        }
                    }
                }
            }
        }

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

        Transfer transfer2 = new Transfer(null, "card");

        currencyCode = Optional.ofNullable(transfer2)
                .map(Transfer::getPerson)
                .map(Person::getCard)
                .map(Card::getCurrency)
                .map(Currency::getCode);
        System.out.println(currencyCode);

        Transfer transfer3 = null;
        currencyCode = Optional.ofNullable(transfer3)
                .map(Transfer::getPerson)
                .map(Person::getCard)
                .map(Card::getCurrency)
                .map(Currency::getCode);
        System.out.println(currencyCode);


    }
}
