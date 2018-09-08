package com.kamalova.urlValidator;

import javafx.util.Pair;

import java.util.concurrent.Callable;

public class ValidateLinkCallable implements Callable<Pair<String, Integer>> {

    public ValidateLinkCallable(String urlString) {
        this.urlString = urlString;
    }

    private String urlString;

    @Override
    public Pair<String, Integer> call() throws Exception {
        URLValidator urlValidator = new URLValidator();
        return new Pair<>(urlString, urlValidator.getUrlResponseCode(urlString));
    }

    public void changeUrl(String newUrl) {
        urlString = newUrl;
    }
}
