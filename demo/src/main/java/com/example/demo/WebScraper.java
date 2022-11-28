package com.example.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;




public class WebScraper {
    public static void main(String[] args) {
        for(int i = 1; i <= 4; ++i) {
            System.out.println("PAGE " + i);
            try {
                String url = (i==1) ? "https://jbzd.com.pl/?date-preset=24h" : "https://jbzd.com.pl/str/2?date-preset=24h" + i;

                Document document = Jsoup.connect(url)
                        .timeout(50000)
                        .get();

                Elements blogs = document.getElementsByClass("article-content");
                for (Element blog : blogs) {
                    String title = blog.select("h3").text();
                    System.out.println("TITLE: " + title);

                    String link = blog.select("a").attr("href");
                    System.out.println("LINK: " + link);
                    try {
                        String headerImage = blog.selectFirst("img").attr("src");
                        System.out.println("HEADER IMAGE: " + headerImage);
                    }
                    catch (NullPointerException e){
                        e.printStackTrace();
                    }
//                    String authorImage = blog.select("img[src*=authors]").attr("src");
//                    System.out.println("AUTHOR IMAGE:" + authorImage);

                    System.out.println();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}