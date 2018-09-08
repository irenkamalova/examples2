package com.kamalova.urlValidator;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ValidateLinkCallable implements Callable<List<Pair<String, Integer>>> {

    public ValidateLinkCallable(List<String> urlString) {
        this.urlString = urlString;
    }

    private List<String> urlString;

    @Override
    public List<Pair<String, Integer>> call() throws Exception {
        List<Pair<String, Integer>> list = new ArrayList<>();
        for (String url : urlString) {
            list.add(readURL(url));
        }
        return list;
    }

    private Pair<String, Integer> readURL(String urlString) {
        URLValidator urlValidator = new URLValidator();
        return new Pair<>(urlString, urlValidator.getUrlResponseCode(urlString));
    }
}
