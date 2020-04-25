package com.whatwillieat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
            List<String> finalDishNames = new ArrayList<String>();
            liElements.forEach((li) -> {
                            List<String> dishNamesFromLine = new ArrayList<String>();
                                    if(li.text().contains("or")) {
                                        List<String> dishesFromOneLine = devideByWord(" or ", li.text());
                                        dishNamesFromLine.addAll(dishesFromOneLine);
                                    } else {
                                        dishNamesFromLine.add(li.text());
                                    }

                                finalDishNames.addAll(dishNamesFromLine);
                            }
                    );
            for (String finalDishName : finalDishNames) {
                System.out.println("finalDishName:   " + finalDishName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done with the href -----");
    }




    private static List<String> devideByWord(String word, String paragraph){
        String[] dishes = paragraph.split(word);
        return Arrays.asList(dishes);
    }

}
