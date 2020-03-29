package com.whatwillieat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        System.out.println("running...");
        System.out.println("  -----------   ");
        Document webpage;
        List<String> dishNames = new ArrayList<String>();

        try {
            webpage = Jsoup.connect("https://funcheaporfree.com/foodie-tuesday-what-to-make-for/").get();
//            String title = webpage.title();
//            System.out.println("  Title:: " + title);
            Elements liElements = webpage.select("h3 ~ ul").select("li");
            liElements.forEach((li) -> {
//                            String dishName;
                                if (!li.text().contains("<a")) {
                                    if(li.text().contains("of")) {
                                        devideByOr(li.text());
                                    }
                                    System.out.println(li.text());
                                } else {
                                    System.out.println(li.select("a").text());
                                }
                            }
                    );
            System.out.println("  ----------------------------------------   ");
//            System.out.println("  <ul>s:: " + liElements);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done with the href -----");
        }

    public static void devideByOr(String paragraph){
        String[] dishes = paragraph.split("or");
        for (String s : dishes) {
            System.out.println("-----  " + s);
        }
    }
}
