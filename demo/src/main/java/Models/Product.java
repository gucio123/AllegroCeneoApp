package Models;

public class Product {

    private String title;
    private String link;

    public Product(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
