package net.shyshkin.study.performance.lists;

import net.shyshkin.study.performance.lists.model.Book;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListBenchmark {

    public static final int BOOK_LIST_SIZE = 10_000_000;

    @Benchmark
    public void arrayListDefault() {
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < BOOK_LIST_SIZE; i++) {
            books.add(mockBook(i));
        }
    }

    @Benchmark
    public void arrayListSettingSize() {
        ArrayList<Book> books = new ArrayList<>(BOOK_LIST_SIZE);
        for (int i = 0; i < BOOK_LIST_SIZE; i++) {
            books.add(mockBook(i));
        }
    }

    @Benchmark
    public void arrayListStream() {
        ArrayList<Book> books = IntStream.range(0, BOOK_LIST_SIZE)
                .mapToObj(this::mockBook)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Benchmark
    public void arrayListStreamWithSize() {
        ArrayList<Book> books = IntStream.range(0, BOOK_LIST_SIZE)
                .mapToObj(this::mockBook)
                .collect(Collectors.toCollection(() -> new ArrayList<>(BOOK_LIST_SIZE)));
    }

    @Benchmark
    public void arrayListStreamWithCopy() {
        List<Book> fromStream = IntStream.range(0, BOOK_LIST_SIZE)
                .mapToObj(this::mockBook)
                .collect(Collectors.toList());
        ArrayList<Book> books = new ArrayList<>(fromStream);
    }

    private Book mockBook(int id) {
        return new Book(id, "Title" + id, "Author" + id, ThreadLocalRandom.current().nextDouble());
    }

}
