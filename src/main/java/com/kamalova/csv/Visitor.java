package com.kamalova.csv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Visitor {

    @CsvBindByName(column = "First Name")
    @CsvBindByPosition(position = 2)
    private String firstName;

    @CsvBindByName(column = "Last Name")
    @CsvBindByPosition(position = 1)
    private String lastName;

    @CsvBindByName(column = "visitsToWebsite")
    @CsvBindByPosition(position = 0)
    private int visitsToWebsite;

}
