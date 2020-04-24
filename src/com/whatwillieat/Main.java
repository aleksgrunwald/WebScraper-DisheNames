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
            List<String> finalDishNames = null;
            liElements.forEach((li) -> {
                        List<String> dishNamesFromLine = null;
                                if (!li.text().contains("<a")) {
                                    if(li.text().contains("or")) {
                                        List<String> dishesFromOneLine = devideByWord("or", li.text());
                                        for (String singleDish : dishesFromOneLine) {
                                            dishNamesFromLine.add(singleDish);
                                        }
                                    }
                                    dishNamesFromLine.add(li.text());
                                } else {
                                    dishNamesFromLine.add(li.select("a").text());
                                }

                                for (String dishNameFromLine : dishNamesFromLine) {
                                    finalDishNames.add(dishNameFromLine);
                                }
                            }
                    );
            for (String finalDishName : finalDishNames) {
                System.out.println("finalDishName:   " + finalDishName);
            }
            System.out.println("Finished adding  ----------------------------------------   ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done with the href -----");
        }


    private static List<String> devideByWord(String word, String paragraph){
        List<String> singleDishesFromOneLine = null;
        String[] dishes = paragraph.split(word);
        for (String dish : dishes) {
            singleDishesFromOneLine.add(dish);
        }
        return singleDishesFromOneLine;
    }
}
