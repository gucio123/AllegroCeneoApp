package com.example.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Scanner;


//public class WebScraper {
//    public static void main(String[] args) {
//        String ProductName = "";
//        try {
//            String url ="https://www.ceneo.pl/;szukaj-" + ProductName;
//
//            Document document = Jsoup.connect(url)
//                    .timeout(50000)
//                    .get();
//
//            int i = 0;
//            int count = 0;
//
//
//            Elements products = document.getElementsByClass("cat-prod-row__body");
//
//            for (Element product : products) {
//                String title = product.select("a").attr("title");
//                System.out.println("TITLE: " + title);
//
//                String ceneoHttp = "https://www.ceneo.pl";
//                String link = ceneoHttp + product.select("a").attr("href");
//
//                System.out.println("LINK: " + link);
//
//                String linkImage1 = product.select("img").attr("data-original");
//                String linkImage2 = product.select("img").attr("src");
//                String linkImage = "https:";
//
//                if(linkImage1.isEmpty()){
//                    System.out.println("HEADER IMAGE: https:" + linkImage2);
//                    linkImage += linkImage2;
//                }else{
//                    System.out.println("HEADER IMAGE: https:" + linkImage1);
//                    linkImage += linkImage1;
//                }
//
//                String price = product.select("span.value").text() + product.select("span.penny").text();
//                System.out.println("PRICE: " + price);
//
//                String caterogry = product.select("a.link--accent").text();
//                System.out.println("Category: " + caterogry);
//
//
//
//                result[i] = new Product(title,
//                        link,
//                        linkImage,
//                        price,
//                        caterogry);
//                System.out.println();
//                i++;
//                if(i == 10)
//                    break;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return List.of(result);
//    //}
//}