package net.shyshkin.study.performance.maps.model;

import java.util.Objects;

public class BookWrongHashCode {

    private final int id;
    private final String title;
    private final String author;
    private final Double price;

    public BookWrongHashCode(int id, String title, String author, Double price) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookWrongHashCode book = (BookWrongHashCode) o;
        return id == book.id && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
