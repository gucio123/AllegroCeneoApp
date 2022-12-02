package Models;

public class Product {

    private final String linkImage;
    private final String price;
    private final String title;
    private final String link;

    public Product(String title, String link, String linkImage, String price) {
        this.title = title;
        this.link = link;
        this.linkImage = linkImage;
        this.price = price;
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

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                "linkImage='" + linkImage + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
