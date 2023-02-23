package net.shyshkin.study.performance.lists;

import net.shyshkin.study.performance.lists.model.Book;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class SortingListBenchmark {

    public static final int BOOK_LIST_SIZE = 10_000_000;

    private static final ArrayList<Book> BOOKS_ARRAY_LIST_ORIGINAL = IntStream.range(0, BOOK_LIST_SIZE)
            .mapToObj(SortingListBenchmark::mockBook)
            .collect(Collectors.toCollection(() -> new ArrayList<>(BOOK_LIST_SIZE)));
    private static final LinkedList<Book> BOOKS_LINKED_LIST_ORIGINAL = new LinkedList<>(BOOKS_ARRAY_LIST_ORIGINAL);


    @Benchmark
    public void cloneArrayList() {
        ArrayList<Book> booksArrayList = (ArrayList<Book>) BOOKS_ARRAY_LIST_ORIGINAL.clone();
    }

    @Benchmark
    public void copyArrayList() {
        ArrayList<Book> booksArrayList = new ArrayList<>(BOOKS_ARRAY_LIST_ORIGINAL);
    }

    @Benchmark
    public void cloneLinkedList() {
        LinkedList<Book> booksLinkedList = (LinkedList<Book>) BOOKS_LINKED_LIST_ORIGINAL.clone();
    }

    @Benchmark
    public void copyLinkedList() {
        LinkedList<Book> booksLinkedList = new LinkedList<>(BOOKS_LINKED_LIST_ORIGINAL);
    }

    @Benchmark
    public void sortArrayList() {
        ArrayList<Book> booksArrayList = (ArrayList<Book>) BOOKS_ARRAY_LIST_ORIGINAL.clone();
        booksArrayList.sort(Comparator.comparing(Book::getPrice));
    }

    @Benchmark
    public void sortLinkedList() {
        LinkedList<Book> booksLinkedList = (LinkedList<Book>) BOOKS_LINKED_LIST_ORIGINAL.clone();
        booksLinkedList.sort(Comparator.comparing(Book::getPrice));
    }

    private static Book mockBook(int id) {
        return new Book(id, "Title" + id, "Author" + id, ThreadLocalRandom.current().nextDouble());
    }

    /*
     * ============================== HOW TO RUN THIS TEST: ====================================
     *
     * You are expected to see the different run modes for the same benchmark.
     * Note the units are different, scores are consistent with each other.
     *
     * You can run this test:
     *
     * a) Via the command line:
     *    $ mvn clean install
     *    $ java -jar target/benchmarks.jar SortingListBenchmark -f 1
     *    (we requested a single fork; there are also other options, see -h)
     *
     * b) Via the Java API:
     *    (see the JMH homepage for possible caveats when running from IDE:
     *      http://openjdk.java.net/projects/code-tools/jmh/)
     */

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SortingListBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
