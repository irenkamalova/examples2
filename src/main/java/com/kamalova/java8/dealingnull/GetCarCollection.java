package com.kamalova.java8.dealingnull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GetCarCollection {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("a", "a", "a"));
        people.add(new Person("b", "b", "b"));
        people.add(new Person("c", "c", "c"));
        people.add(new Person("d", "d", "d"));
        Person p = new Person("e", "e", "e");
        p.setCar(Optional.of(new Car("m")));
        people.add(p);

        Person cleverPerson = new Person("7", "7", "7");
        cleverPerson.setBrain(Optional.of(new Brain()));
        people.add(cleverPerson);

        List<Person> cleverPeople = people.stream()
                .filter(person -> person.getBrain().isPresent())
                .peek(System.out::println)
                .collect(Collectors.toList());



        List<Person> collect = people.stream().filter(person -> person.getCar().isPresent()).collect(Collectors.toList());
        collect.forEach(System.out::println);
        Car car = new Car("m");

        Optional<Car> optCar = Optional.ofNullable(car);
        Optional<String> carLabel = optCar.map(Car::getLabel);

        carLabel.ifPresent(System.out::println);

        String label = carLabel.orElse("Unknown");
        System.out.println(label);

//        carLabel.orElseGet();

        String s = carLabel.get();

        Optional<Car> car1 = Optional.of(car);

        carLabel.orElseThrow(NullPointerException::new);

        String result = carLabel.orElseThrow(IllegalArgumentException::new);

        // filter!
        carLabel.filter(l -> l.equals("m")).ifPresent(System.out::println);

        // now  rethink :)

        String five = "5";
//        Integer integer = OptionalUtility.
//        OptionalInt optionalInt = new;

    }

    public Optional<String> nullSafeFindCheapestInsurance( Optional<Person> person, Optional<Car> car) {

//        return Optional.ofNullable(findCheapestInsurance());





        return person.flatMap(p -> car.flatMap(c -> Optional.ofNullable(findCheapestInsurance(p, c))));
    }

    public String findCheapestInsurance(Person person, Car car) {
        // queries services provided by the different insurance companies // compare all those data return cheapestCompany; }
        return "will be implemented...";
    }


}
