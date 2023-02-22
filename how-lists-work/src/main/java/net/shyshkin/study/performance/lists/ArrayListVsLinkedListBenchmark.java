package net.shyshkin.study.performance.lists;

import net.shyshkin.study.performance.lists.model.Book;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ArrayListVsLinkedListBenchmark {

    public static final int BOOK_LIST_SIZE = 10_000_000;
    private static final int INDEX = 4_987_654;

    private static final ArrayList<Book> booksArrayList = IntStream.range(0, BOOK_LIST_SIZE)
            .mapToObj(ArrayListVsLinkedListBenchmark::mockBook)
            .collect(Collectors.toCollection(() -> new ArrayList<>(BOOK_LIST_SIZE)));
    private static final LinkedList<Book> booksLinkedList = IntStream.range(0, BOOK_LIST_SIZE)
            .mapToObj(ArrayListVsLinkedListBenchmark::mockBook)
            .collect(Collectors.toCollection(LinkedList::new));

    @Benchmark
    public void arrayListGetByIndex() {
        Book book = booksArrayList.get(INDEX);
    }

    @Benchmark
    public void linkedListGetByIndex() {
        Book book = booksLinkedList.get(INDEX);
    }

    private static Book mockBook(int id) {
        return new Book(id, "Title" + id, "Author" + id, ThreadLocalRandom.current().nextDouble());
    }

}
