package com.whatwillieat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;



public class Main {

    public static void main(String[] args) {
	    System.out.println("running...");
        Document document;
        try {
            document = Jsoup.connect("https://funcheaporfree.com/foodie-tuesday-what-to-make-for/").get();
            String title = document.title();
            System.out.println("  Title:: " + title);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done with the href -----");
    }
}
