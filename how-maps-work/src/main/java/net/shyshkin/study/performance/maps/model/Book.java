package net.shyshkin.study.performance.maps.model;

public class Book {

    private final int id;
    private final String title;
    private final String author;
    private final Double price;

    public Book(int id, String title, String author, Double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
