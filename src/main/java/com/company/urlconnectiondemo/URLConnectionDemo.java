/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.company.urlconnectiondemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kamau
 */
public class URLConnectionDemo {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://google.com");
            URLConnection urlConnection = url.openConnection();
            InputStreamReader isr = new InputStreamReader((InputStream) urlConnection.getContent());
            BufferedReader br = new BufferedReader(isr);
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);

            }
            br.close();

            System.out.println("getAllowUserInteraction: " + urlConnection.getAllowUserInteraction());
            System.out.println("getDoInput: " + urlConnection.getDoInput());
            System.out.println("getDoOuput: " + urlConnection.getDoOutput());
            System.out.println("getIfModifiedSince: " + urlConnection.getIfModifiedSince());
            System.out.println("getUseCaches: " + urlConnection.getUseCaches());
            System.out.println("getURL: " + urlConnection.getURL());
            System.out.println("getContentEncoding: " + urlConnection.getContentEncoding());
            System.out.println("getLastModified: " + urlConnection.getLastModified());
            Map<String, List<String>> map = urlConnection.getHeaderFields();

            for (Map.Entry<String, List<String>> me : map.entrySet()) {
                String key = me.getKey();
                List<String> valueList = me.getValue();
                System.out.println("key: " + key);
                for(String value : valueList){
                    System.out.println("Value: "+value);
                }
                System.out.println();

            }

        } catch (MalformedURLException e) {
            e.getMessage();
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }
}
