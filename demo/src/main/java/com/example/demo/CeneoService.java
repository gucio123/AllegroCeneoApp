package com.example.demo;

import Models.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CeneoService {

    public List<Product> findAllProducts(){

        Product[] result = new Product[10];
        String ProductName = "durex";
        try {
            String url ="https://www.ceneo.pl/;szukaj-" + ProductName;

            Document document = Jsoup.connect(url)
                    .timeout(50000)
                    .get();

            int i = 0;
            int count = 0;


            Elements products = document.getElementsByClass("cat-prod-row__body");
            Elements categoryProduct = document.getElementsByClass("cat-prod-row__category");

            for (Element product : products) {
                String title = product.select("a").attr("title");
                System.out.println("TITLE: " + title);
                
                String ceneoHttp = "https://www.ceneo.pl";
                String link = ceneoHttp + product.select("a").attr("href");
                
                System.out.println("LINK: " + link);

                String linkImage1 = product.select("img").attr("data-original");
                String linkImage2 = product.select("img").attr("src");
                String linkImage = "https:";

                if(linkImage1.isEmpty()){
                    System.out.println("HEADER IMAGE: https:" + linkImage2);
                    linkImage += linkImage2;
                }else{
                    System.out.println("HEADER IMAGE: https:" + linkImage1);
                    linkImage += linkImage1;
                }

                String price = product.select("span.value").text() + product.select("span.penny").text();
                System.out.println("PRICE: " + price);

                String category = product.select("a.link.link--accent").text();
                System.out.println("Category: " + category);



                result[i] = new Product(title,
                        link,
                        linkImage,
                        price,
                        category);
                System.out.println();
                i++;
                if(i == 10)
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of(result);
    }

}
