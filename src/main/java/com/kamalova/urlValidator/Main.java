package com.kamalova.urlValidator;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;

public class Main {

    private final static int fixedThreadCount = 6;

    public static void main(String[] args) throws IOException, InterruptedException {

        Main main = new Main();
        long start = System.currentTimeMillis();
//        for (File fileEntry : directory.listFiles()) {
        File fileEntry = new File("filename.txt.gz");
            System.out.println(fileEntry.getName());
            main.analyseFile(fileEntry);
//        }
        long end = System.currentTimeMillis();

        System.out.println("It took: " + (end - start));

    }

    public void analyseFile(File file) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(file);
        GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);
        BufferedReader br = new BufferedReader(new InputStreamReader(gzipInputStream));

        int countLine = 0;
        String strLine;
        long start = System.currentTimeMillis();
        while ((strLine = br.readLine()) != null && countLine <= 101) {
                long start0 = System.currentTimeMillis();
                countLine += doCycle(strLine, br, countLine);
                System.out.println("Returned countline is: " + countLine);
                    System.out.println("Spended to check " + countLine + " lines");
                    long end = System.currentTimeMillis();
                    System.out.println("Spent " + (end - start0) / 1000
                            + " seconds " + (end - start) % 1000
                            + " milliseconds");

        }
        br.close();
        System.out.println("End of scanning file");

        File resultFile = new File(file.getName() + ".output.txt");
        resultFile.deleteOnExit();
        System.out.println("End of creating result");
    }

    private int doCycle(String strLine, BufferedReader br, int startValue) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(fixedThreadCount);

        List<Future<Pair<String, Integer>>> list = new ArrayList<>();

        // to validate the first link:
        Callable<Pair<String, Integer>> callable0 = new ValidateLinkCallable(strLine);
        Future<Pair<String, Integer>> future0 = executor.submit(callable0);
        list.add(future0);
        int countLine = 0;
        while ((strLine = br.readLine()) != null && countLine <= startValue + 10) {
            Callable<Pair<String, Integer>> callable = new ValidateLinkCallable(strLine);
            Future<Pair<String, Integer>> future = executor.submit(callable);
            list.add(future);
            countLine++;
        }
        for (Future<Pair<String, Integer>> future : list) {
            // if you don't want to terminate a program before terminating all threads
            while (!future.isDone()) {}
        }
        executor.shutdown();
        return countLine;
    }

    /*
    fixedThreadCount = 4
    sitemap_offers_moto_1.txt.gz
    Returned countline is: 11
    Spended to check 11 lines
    Spent 3 seconds 18 milliseconds
    Returned countline is: 33
    Spended to check 33 lines
    Spent 2 seconds 625 milliseconds
    Returned countline is: 77
    Spended to check 77 lines
    Spent 4 seconds 324 milliseconds
    Returned countline is: 165
    Spended to check 165 lines
    Spent 11 seconds 727 milliseconds
    End of scanning file
    End of creating result
    It took: 21729

    fixedThreadCount = 6
    sitemap_offers_moto_1.txt.gz
    Returned countline is: 11
    Spended to check 11 lines
    Spent 1 seconds 872 milliseconds
    Returned countline is: 33
    Spended to check 33 lines
    Spent 2 seconds 4 milliseconds
    Returned countline is: 77
    Spended to check 77 lines
    Spent 3 seconds 748 milliseconds
    Returned countline is: 165
    Spended to check 165 lines
    Spent 7 seconds 258 milliseconds
    End of scanning file
    End of creating result
    It took: 15260
     */
}
