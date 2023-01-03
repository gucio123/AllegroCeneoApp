package com.example.demo;

import Models.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CeneoService {

    public List<Product> findProducts(String input) {


        List<Product> result = new ArrayList<Product>();
        String[] multipleProducts = input.split(",");

        long startTime = System.currentTimeMillis();
        long elapsedTime = 0;

//        while ((elapsedTime < 10000) || (result.size() <= 10)) {  // 30000 milliseconds = 30 seconds



//            Thread.sleep(100);  // Pause for 100 milliseconds

            for (int j = 0; j < multipleProducts.length; j++) {

                String ProductName = multipleProducts[j];

                try {

                    String url = "https://www.ceneo.pl/;szukaj-" + ProductName + ";0112-0.htm";

                    Document document = Jsoup.connect(url)
                            .timeout(50000)
                            .get();

                    int i = 0;
                    int count = 0;

                    Elements products = document.getElementsByClass("cat-prod-row__body");

                    for (Element product : products) {

                        String title = product.select("a").attr("title");
                        System.out.println("TITLE: " + title);

                        String ceneoHttp = "https://www.ceneo.pl";
                        String link = ceneoHttp + product.select("a").attr("href");

                        System.out.println("LINK: " + link);

                        String linkImage1 = product.select("img").attr("data-original");
                        String linkImage2 = product.select("img").attr("src");
                        String linkImage = "https:";

                        if (linkImage1.isEmpty()) {

                            System.out.println("HEADER IMAGE: https:" + linkImage2);
                            linkImage += linkImage2;

                        } else {
                            System.out.println("HEADER IMAGE: https:" + linkImage1);
                            linkImage += linkImage1;
                        }

                        String price = product.select("span.value").text() + product.select("span.penny").text();
                        System.out.println("PRICE: " + price);


                        ///////////////  Wchodzenie w link od produktu i pobieranie informacji o wysyłce i nazwie sklepu  /////////////////////

                        String urlDetail = link;

                        Document document2 = Jsoup.connect(urlDetail)
                                .timeout(50000)
                                .get();


                        ////GET CATEGORY
                        Elements productsCategory = document2.select("div[itemprop=itemListElement][itemtype=http://schema.org/ListItem]");

                        Elements categoryNames = productsCategory.select("a");

                        String category = null;
                        try {

                            Element categoryName = categoryNames.get(1);
                            category = categoryName.text();
                            System.out.println("CATEGORY: " + category);

                        } catch (IndexOutOfBoundsException e) {
                            category = "The category name is not avalible";
                            System.out.println(category);
                        }

                        Element deliveryPrices = document2.select("div.product-offer-summary__labels").first();

                        String deliveryPrice = null;
                        try {
                            deliveryPrice = deliveryPrices.text();
                            System.out.println("Cost with delivery: " + deliveryPrice);

                        } catch (NullPointerException e) {
                            deliveryPrice = "The delivery price is not avalible";
                            System.out.println(deliveryPrice);
                        }


                        Elements productsOfferts = document2.getElementsByClass("page-tabs--product-page");

                        String productOffert = null;

                        try {

                            productOffert = productsOfferts.select("a").attr("title");
                            productOffert = productOffert.replaceAll("\\D+", "");
                            System.out.println("AMOUNT OF OFFERTS: " + productOffert);

                        } catch (NullPointerException e) {
                            e.printStackTrace();
                            productOffert = "Amount of offerts is not avalibile";
                            System.out.println(productOffert);
                        }
                        if(productOffert.isEmpty()){
                            productOffert = "Amount of offerts is not avalibile";
                        }



                        if (category.equalsIgnoreCase("uroda") || category.equalsIgnoreCase("zdrowie")) {
                            result.add(new Product(
                                    title,
                                    link,
                                    linkImage,
                                    price,
                                    category,
                                    deliveryPrice,
                                    productOffert
                            ));
                            i++;
                        }

                        if ((i == 10)){
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            elapsedTime = System.currentTimeMillis() - startTime;
//        }
        return result;
    }

}
