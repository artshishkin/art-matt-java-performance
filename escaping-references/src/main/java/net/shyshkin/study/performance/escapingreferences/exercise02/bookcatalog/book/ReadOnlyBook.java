package net.shyshkin.study.performance.escapingreferences.exercise02.bookcatalog.book;

public interface ReadOnlyBook {
    int getId();

    String getTitle();

    String getAuthor();

    String toString();

    Price getPrice();
}
