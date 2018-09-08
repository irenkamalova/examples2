package com.kamalova.urlValidator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
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
