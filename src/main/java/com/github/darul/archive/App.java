package com.github.darul.archive;

import com.github.darul.archive.researchers.wikipedia.WikipediaResearcher;

import java.io.IOException;
import java.net.http.HttpClient;

public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println(new WikipediaResearcher(HttpClient.newHttpClient()).findData("Ibn Khaldun"));
    }
}
