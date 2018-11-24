package com.kamalova.csv;

import com.opencsv.CSVWriter;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.apache.commons.text.StringEscapeUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class CSVWriterExample {

    public static void main(String[] args) throws Exception {
        // simple writer
//        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File("simple2.csv")),
//                "utf-8");
//        writer.write("i1,i2,i3");
//        writer.write("\n");
//        writer.write(StringEscapeUtils.escapeCsv("a\t\"b\""));
//        System.out.println("a\t\"b\"");
//        System.out.println("But if you will write it without escapeCsv - you will see a b");
//        writer.write(",");
//        writer.write("i2,i3");
//        writer.write("\n");
//
//        List<String> strings = new ArrayList<>();
//        strings.add("dsk\t\' \" \" / \\ fd\'\t'dfd'  \n   df");
//        strings.add("dsk\t\'fd\'\t'dfd'     df");
//        strings.add("dsk\t\'fd\'\t'dfd'     df");
//
//
//
//        strings.forEach(s -> {
//            try {
//                writer.write(StringEscapeUtils.escapeCsv(s));
//                writer.write(",");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        });
//        writer.write("\n");
//        writer.close();
//
//



        // opencsv http://opencsv.sourceforge.net

//        List<String> beans = new ArrayList<>();
//        beans.add("item1");
//        beans.add("item2");
//        beans.add("item3");
//        CSVWriter csvWriter = new CSVWriter(new FileWriter("test_file.csv"));
//        csvWriter.writeNext(beans.toArray(new String[0]));
//        csvWriter.close();

//        List<Visitor> visitors = new ArrayList<>();
//        visitors.add(new Visitor("B", "B", 6));
//        visitors.add(new Visitor("A", "A", 5));
        Writer fileWriter = new FileWriter("your_file.csv");


//        beanToCsv.beanToCsv
        createCsvWriter(fileWriter).write(new Visitor("A", "B", 6));
        createCsvWriter(fileWriter).write(new Visitor("C", "C", 6));
        createCsvWriter(fileWriter).write(new Visitor("D", "D", 6));
//        beanToCsv.write(visitors);
        fileWriter.close();

        // ostermiller https://ostermiller.org/utils/CSV.html


    }

    private static StatefulBeanToCsv<Visitor> createCsvWriter(Writer fileWriter) {
        final CustomMappingStrategy customMappingStrategy = new CustomMappingStrategy<>();
        customMappingStrategy.setType(Visitor.class);
        return new StatefulBeanToCsvBuilder<Visitor>(fileWriter)
                .withMappingStrategy(customMappingStrategy)
                .build();
    }


}
