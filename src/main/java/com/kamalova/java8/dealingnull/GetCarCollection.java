package com.kamalova.java8.dealingnull;

import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
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

        List<Person> collect = people.stream().filter(person -> person.getCar().isPresent()).collect(Collectors.toList());
        collect.forEach(System.out::println);
        Car car = new Car("m");

        Optional<Car> optCar = Optional.ofNullable(car);
        Optional<String> carLabel = optCar.map(Car::getLabel);

        carLabel.ifPresent(System.out::println);

        String label = carLabel.orElse("Unknown");
        System.out.println(label);

        carLabel.orElseGet(() -> {
            car.setLabel("Unknown");
            return "Unknown";
        });

        String result = carLabel.orElseThrow(IllegalArgumentException::new);

        // filter!
        carLabel.filter(l -> l.equals("m")).ifPresent(System.out::println);

        // now  rethink :)

        String five = "5";
//        Integer integer = OptionalUtility.
        OptionalInt optionalInt = new;

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
