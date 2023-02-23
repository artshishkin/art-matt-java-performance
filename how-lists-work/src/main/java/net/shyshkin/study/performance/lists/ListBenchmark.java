package net.shyshkin.study.performance.lists;

import net.shyshkin.study.performance.lists.model.Book;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
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

    @Benchmark
    public void linkedListStream() {
        LinkedList<Book> books = IntStream.range(0, BOOK_LIST_SIZE)
                .mapToObj(this::mockBook)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private Book mockBook(int id) {
        return new Book(id, "Title" + id, "Author" + id, ThreadLocalRandom.current().nextDouble());
    }

}
