package com.kamalova.urlValidator;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws IOException {
        URLValidator urlValidator = new URLValidator();

        String urlString = "https://auto.ru/sitemap_parts-114.txt.gz";

        String pathToFile = "/Users/irenkamalova/Downloads/sitemaps/sitemap_dealers_1.txt";

        Main main = new Main();
        long start = System.currentTimeMillis();
        main.analyseFile(pathToFile);
        long end = System.currentTimeMillis();

        System.out.println("It took: " + (end - start));


    }

    public void analyseFile(String pathToFile) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(50);
        // 500 тредов - 40 секунд для 7000 строк
        // 100 тредов - чуть лучше
        // 50 - тоже самое
        List<Future<Pair<String, Integer>>> list = new ArrayList<>();

        URLValidator urlValidator = new URLValidator();
        File inputFile = new File(pathToFile);
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));

        List<ValidateLinkCallable> listCallable = new ArrayList<>();

        int countLine = 0;
        String strLine;
        long start = System.currentTimeMillis();
        while ((strLine = br.readLine()) != null) {
            while (countLine < 50) {
                ValidateLinkCallable callable = new ValidateLinkCallable(strLine);
                listCallable.add(callable);
                Future<Pair<String, Integer>> future = executor.submit(callable);
                list.add(future);
                countLine++;

            }

            for (ValidateLinkCallable callable : listCallable) {
                if ((strLine = br.readLine()) != null) {
                    callable.changeUrl(strLine);
                    try {
                        callable.call();
                        Future<Pair<String, Integer>> future = executor.submit(callable);
                        list.add(future);
                        countLine++;
                        if (countLine % 100 == 0) {
                            System.out.println("Checked " + countLine + " lines");
                            long end = System.currentTimeMillis();
                            System.out.println("Spent " + (end - start) / 1000 + " seconds" + (end - start) % 1000 + " milliseconds");
                        }
                    } catch (Exception e) {
                        System.out.println("Error with call callable for link " + strLine);
                        e.printStackTrace();
                    }

                }
            }

            countLine++;
            if (countLine % 100 == 0) {
                System.out.println("Checked " + countLine + " lines");
                long end = System.currentTimeMillis();
                System.out.println("Spent " + (end - start) / 1000 + " seconds" + (end - start) % 1000 + " milliseconds");
            }
        }
        br.close();
        System.out.println("End of scanning file");

        File resultFile = new File(pathToFile + ".output.txt");
        resultFile.deleteOnExit();
        FileOutputStream fileOutputStream = new FileOutputStream(resultFile);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        countLine = 0;


        for (Future<Pair<String, Integer>> fut : list) {
            try {
                Pair<String, Integer> pair = fut.get();
                countLine++;
                if (countLine % 100 == 0) {
                    System.out.println("Checked " + countLine + " lines");
                    long end = System.currentTimeMillis();
                    System.out.println("Spent " + (end - start) / 1000 + " seconds" + (end - start) % 1000 + " milliseconds");
                }
//                bw.write(pair.getKey() + " " +
//                        (pair.getValue().toString()));
//                bw.newLine();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        bw.close();

        executor.shutdown();

        System.out.println("End of creating result");
    }
}