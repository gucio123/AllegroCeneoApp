package Models;

public class Product {

    private final String linkImage;
    private final String price;
    private final String title;
    private final String link;
    private final String category;

    public Product(String title, String link, String linkImage, String price, String category) {
        this.title = title;
        this.link = link;
        this.linkImage = linkImage;
        this.price = price;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public String getPrice() {
        return price;
    }

    public String getLink() {
        return link;
    }
    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                "linkImage='" + linkImage + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
