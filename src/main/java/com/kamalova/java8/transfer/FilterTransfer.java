package com.kamalova.java8.transfer;

import java.util.ArrayList;
import java.util.List;

public class FilterTransfer {
    public static void main(String[] args) {
        Currency currency0 = new Currency("RUB");
        Card card0 = new Card(currency0, "38");
        Person person0 = new Person(card0, 77);
        Transfer transfer0 = new Transfer(person0, "card");
        List<Transfer> transferList = new ArrayList<>();
        transferList.add(transfer0);

        long count1 = 0;
        for (Transfer t : transferList) {
            if ("card".equals(t.getType())) {
                if (t.getPerson().getAge() > 18) {
                    if ("38".equals(t.getPerson().getCard().getTb())) {
                        if ("RUB".equals(t.getPerson().getCard().getCurrency())) {
                            count1++;
                        }
                    }
                }
            }
        }
        System.out.println(count1);

        long count2 = transferList.stream()
                .filter(transfer -> "card".equals(transfer.getType())).map(Transfer::getPerson)
                .filter(person -> person.getAge() > 18).map(Person::getCard)
                .filter(card -> "38".equals(card.getTb())).map(Card::getCurrency)
                .filter(currency -> "RUB".equals(currency.getCode()))
                .count();
        System.out.println(count2);

        long count = transferList.stream().map(Transfer::getPerson).map(Person::getCard)
                .map(Card::getCurrency).map(Currency::getCode)
                .filter(c -> c.equals("RUB")).count();
        System.out.println(count);

    }
}
