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
            int code = huc.getResponseCode();
            if (code != 200) {
                System.out.println("LINK ERROR: " + urlString + " code is " + code);
            }
            return code;
        } catch (IOException e) {
            System.out.println(" Error with URL: " + urlString);
            return -1;
        }
    }
}
