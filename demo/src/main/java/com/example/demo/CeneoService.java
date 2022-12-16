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
//        String input = productInput.getInput();

        List<Product> result = new ArrayList<Product>();
        String[] multipleProducts = input.split(",");

        long startTime = System.currentTimeMillis();


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


//                    Elements productsCategory = document.getElementsByClass("cat-prod-row__category");
//
//                    for (Element productCategory : productsCategory) {
//                        String category = productCategory.select("a.link.link--accent").text();
//                        System.out.println("CATEGORY/OPINION: " + category);
//
//                    }


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

//                    Cena produktu w linku, wtedy lepiej bo mamy odrazu cene skojarzoną z wysyłką ale gorzej bo niektóre produkty nie mają tej strony
//                    Element priceElement = document2.select("span.price").first();
//
//                    String priceText = priceElement.text();
//
//                    String[] priceParts = priceText.split(",");
//
//                    String price = priceParts[0] + priceParts[1];
//
//                    System.out.println(price);



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
                        result.add(new Product(title,
                                link,
                                linkImage,
                                price,
                                category,
                                deliveryPrice,
                                productOffert
                        ));
                        i++;
                    }

                    long estimetedTime = System.currentTimeMillis() - startTime;

                    if ((i == 10)|| (estimetedTime >= 30000)){
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
