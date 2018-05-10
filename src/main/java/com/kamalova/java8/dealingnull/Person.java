package com.kamalova.java8.dealingnull;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Optional;

@ToString
@Getter
public class Person {
//    @NotNull
    private String firstName;
//    @NotNull
    private String secondName;
//    @NotNull
    private String thirdName;

    public Person(@NonNull String firstName, @NonNull String secondName, @NonNull String thirdName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;

        this.car = Optional.empty();
    }

//        public Person(String firstName, String secondName, String thirdName) {
//        if (firstName == null)
//            throw new NullPointerException("First name is null");
//        this.firstName = firstName;
//        this.secondName = secondName;
//        this.thirdName = thirdName;
//
//    }

    public static void main(String[] args) throws IOException, IllegalAccessException {
        Person p = new Person("a", "b", "c");
        Field[] fields = p.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            f.set(p, null);
        }
        System.out.println("Now, first name is " + p.getFirstName());

        Person person = new Person(null, null, null);


    }

    @Setter
    private Optional<Car> car;
}

