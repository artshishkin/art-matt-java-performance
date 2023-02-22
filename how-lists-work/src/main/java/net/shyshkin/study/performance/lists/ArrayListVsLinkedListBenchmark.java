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
    public void arrayListAddAt0RemoveLast() {
        booksArrayList.add(0, mockBook(ThreadLocalRandom.current().nextInt()));
        booksArrayList.remove(BOOK_LIST_SIZE);
    }

    @Benchmark
    public void linkedListGetByIndex() {
        Book book = booksLinkedList.get(INDEX);
    }

    @Benchmark
    public void linkedListAddAt0RemoveLast() {
        booksLinkedList.add(0, mockBook(ThreadLocalRandom.current().nextInt()));
        booksLinkedList.removeLast();  //prevent OutOfMemoryError
    }

    @Benchmark
    public void linkedListAddFirstRemoveLast() {
        booksLinkedList.addFirst(mockBook(ThreadLocalRandom.current().nextInt()));
        booksLinkedList.removeLast(); //prevent OutOfMemoryError
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
     *    $ java -jar target/benchmarks.jar ArrayListVsLinkedListBenchmark -f 1
     *    (we requested a single fork; there are also other options, see -h)
     *
     * b) Via the Java API:
     *    (see the JMH homepage for possible caveats when running from IDE:
     *      http://openjdk.java.net/projects/code-tools/jmh/)
     */

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ArrayListVsLinkedListBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
