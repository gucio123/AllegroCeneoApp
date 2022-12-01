package com.example.demo;

import Models.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Scanner;

@Service
public class CeneoService {

    public Product[] products(){

        Product[] result = new Product[10];
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter product name");
//
//        String ProductName = myObj.nextLine();  // Read user input
        String ProductName = "kuchenka";
        try {
            //Allegro: String url = (i==1) ? "https://www.ceneo.pl/;szukaj-aspiryna" : "https://allegro.pl/listing?string=aspiryna&p=" + i;
            String url ="https://www.ceneo.pl/;szukaj-" + ProductName;

            Document document = Jsoup.connect(url)
                    .timeout(50000)
                    .get();
            int i = 0;
            Elements blogs = document.getElementsByClass("cat-prod-row__name");
            for (Element blog : blogs) {
//                    String titleChild = String.valueOf(blog.getAllElements());
//                    System.out.println("TITLECHILD:" + titleChild );

//                    String NameProduct = String.valueOf(blog.getElementsMatchingText("Aspiryna"));
//                    System.out.println("NameProduct: " + NameProduct);

                String title = blog.select("a").text();
                System.out.println("TITLE: " + title);

                String link = blog.select("a").attr("href");
                System.out.println("LINK: https://www.ceneo.pl" + link);

                String headerImage = blog.getElementsByClass("cat-prod-row__foto").attr("img");
                System.out.println("HEADER IMAGE: " + headerImage);

//                  String authorImage = blog.select("img[src*=authors]").attr("src");
//                  System.out.println("AUTHOR IMAGE:" + authorImage);

                result[i] = new Product(title, link);
                System.out.println();
                i++;
                if(i == 10)
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
