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
import java.util.zip.GZIPInputStream;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        URLValidator urlValidator = new URLValidator();

        String pathToFile = "/Users/irenkamalova/Downloads/sitemaps/sitemap_dealers_1.txt.gz";
        File directory = new File("/Users/irenkamalova/Downloads/sitemaps5/");




        Main main = new Main();
        long start = System.currentTimeMillis();
//        for (File fileEntry : directory.listFiles()) {
        File fileEntry = new File("/Users/irenkamalova/Downloads/sitemaps6/sitemap_offers_cars_1.txt.gz");
            System.out.println(fileEntry.getName());
            main.analyseFile(fileEntry);
//        }
        long end = System.currentTimeMillis();

        System.out.println("It took: " + (end - start));

    }

    public void analyseFile(File file) throws IOException, InterruptedException {
//        ExecutorService executor = Executors.newFixedThreadPool(50);

//        URLValidator urlValidator = new URLValidator();
        FileInputStream fileInputStream = new FileInputStream(file);
        GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);
        BufferedReader br = new BufferedReader(new InputStreamReader(gzipInputStream));

        int countLine = 0;
        String strLine;
        long start = System.currentTimeMillis();
        while ((strLine = br.readLine()) != null) {
            if (countLine % 1000 == 0) {
                countLine += doCycle(strLine, br);
                System.out.println("Returned countline is: " + countLine);
                Thread.sleep(1000);

            }
        }
        br.close();
        System.out.println("End of scanning file");

        File resultFile = new File(file.getName() + ".output.txt");
        resultFile.deleteOnExit();
//        executor.shutdown();shutdown
        System.out.println("End of creating result");
    }

    private int doCycle(String strLine, BufferedReader br) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(50);

        List<Future<Pair<String, Integer>>> list = new ArrayList<>();

        // to validate the first link:
        Callable<Pair<String, Integer>> callable0 = new ValidateLinkCallable(strLine);
        Future<Pair<String, Integer>> future0 = executor.submit(callable0);
        list.add(future0);
        int countLine = 0;
        long start = System.currentTimeMillis();
        while ((strLine = br.readLine()) != null && countLine < 1000) {
            Callable<Pair<String, Integer>> callable = new ValidateLinkCallable(strLine);
            Future<Pair<String, Integer>> future = executor.submit(callable);
            list.add(future);
            countLine++;
            if (countLine % 100 == 0) {
                System.out.println("Spended to check " + countLine + " lines");
                long end = System.currentTimeMillis();
                System.out.println("Spent " + (end - start) / 1000 + " seconds" + (end - start) % 1000 + " milliseconds");
            }

            if (countLine % 1000 == 0) {
                int checkedLine = 0;
                for (Future<Pair<String, Integer>> fut : list) {
                    try {
                        Pair<String, Integer> pair = fut.get();
                        if (pair.getValue() != 200) {
                            System.out.println("Error with link, code is " + pair.getValue());
                        }
                        checkedLine++;
                        if (checkedLine % 100 == 0) {
                            System.out.println("Checked " + checkedLine + " lines");
                            long end = System.currentTimeMillis();
                            System.out.println("Spent " + (end - start) / 1000 + " seconds" + (end - start) % 1000 + " milliseconds");
                        }
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        executor.shutdown();
        return countLine;
    }
}
