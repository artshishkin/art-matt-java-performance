package net.shyshkin.study.performance.maps;

import net.shyshkin.study.performance.maps.model.Book;
import net.shyshkin.study.performance.maps.model.BookWrongHashCode;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class HashCodeBenchmark {

    private static final int BUCKETS_COUNT = 1024*32;
    private static final int BOOK_LIST_SIZE = BUCKETS_COUNT * 7 / 10;

    private final Map<Book, Double> normalBucketSizeMap = IntStream.range(0, BOOK_LIST_SIZE)
            .mapToObj(HashCodeBenchmark::mockBook)
            .collect(Collectors.toMap(Function.identity(), Book::getPrice, (b1, b2) -> b1, () -> new HashMap<>(BUCKETS_COUNT)));

    private final Map<BookWrongHashCode, Double> allInOneBucketMap = IntStream.range(0, BOOK_LIST_SIZE)
            .mapToObj(HashCodeBenchmark::mockBookWrongHashCode)
            .collect(Collectors.toMap(Function.identity(), BookWrongHashCode::getPrice, (b1, b2) -> b1, () -> new HashMap<>(BUCKETS_COUNT)));

    @Benchmark
    public void getLastFromUsualHashMap() {
        int lastIndex = BOOK_LIST_SIZE - 1;
        var lastBook = mockBook(lastIndex);
        Double price = normalBucketSizeMap.get(lastBook);
        if (!Objects.equals(price, lastBook.getPrice()))
            throw new RuntimeException("Expected price of " + lastBook + " does not match " + price);
    }

    @Benchmark
    public void getLastFromAllInOneBucketMap() {
        int lastIndex = BOOK_LIST_SIZE - 1;
        var lastBook = mockBookWrongHashCode(lastIndex);
        Double price = allInOneBucketMap.get(lastBook);
        if (!Objects.equals(price, lastBook.getPrice()))
            throw new RuntimeException("Expected price of " + lastBook + " does not match " + price);
    }

    private static Book mockBook(int id) {
        return new Book(id, "Title" + id, "Author" + id, id + 0.123);
    }

    private static BookWrongHashCode mockBookWrongHashCode(int id) {
        return new BookWrongHashCode(id, "Title" + id, "Author" + id, id + 0.123);
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

//        HashCodeBenchmark hashCodeBenchmark = new HashCodeBenchmark();
//        hashCodeBenchmark.getLastFromAllInOneBucketMap();

        Options opt = new OptionsBuilder()
                .include(HashCodeBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
