package com.example.demo.scraping.Ceneo;

public class KosmetykiFarmacja {

    private String Category; // kosmetyki badz artykuly farma
    private String subCategory; // wszystkie kategorie odpowiednio dla kosmetykow i farmy
    private String name;
//    private Integer id;
    private Integer price; // cena OD (?)


    public KosmetykiFarmacja(){};


    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
