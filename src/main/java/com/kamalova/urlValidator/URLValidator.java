package com.kamalova.urlValidator;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLValidator {

     public int getUrlResponseCode(String urlString) {
        try {
            URL u = new URL(urlString);
            HttpURLConnection huc =  (HttpURLConnection)  u.openConnection();
            huc.setRequestMethod("GET");
            huc.connect();
            return huc.getResponseCode();
        } catch (IOException e) {
            System.out.println(" Error with URL: " + urlString);
            e.printStackTrace();
            return -1;
        }
    }
}
