package com.whatwillieat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;



public class Main {

    public static void main(String[] args) {
	    System.out.println("running...");
        Document webpage;
        try {
            webpage = Jsoup.connect("https://funcheaporfree.com/foodie-tuesday-what-to-make-for/").get();
            String title = webpage.title();
            System.out.println("  Title:: " + title);
            String uls = webpage.select("h3 ~ ul").select("li").html();
            System.out.println("  <ul>s:: " + uls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done with the href -----");
    }
}
