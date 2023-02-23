package net.shyshkin.study.performance.maps;

import net.shyshkin.study.performance.maps.model.Book;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MapBenchmark {

    public static final int BOOK_LIST_SIZE = 10_000_000;
    public static final float LOAD_FACTOR = 0.9f;

    @Benchmark
    public void putToHashMap() {
        Map<Integer, Book> books = new HashMap<>();
        IntStream.range(0, BOOK_LIST_SIZE)
                .mapToObj(this::mockBook)
                .forEach(b -> books.put(b.getId(), b));
    }

    @Benchmark
    public void putToHashMapInitialCapacity() {
        Map<Integer, Book> books = new HashMap<>(BOOK_LIST_SIZE / 2);
        IntStream.range(0, BOOK_LIST_SIZE)
                .mapToObj(this::mockBook)
                .forEach(b -> books.put(b.getId(), b));
    }

    @Benchmark
    public void putToHashMapInitialCapacityLoadFactor() {
        Map<Integer, Book> books = new HashMap<>(BOOK_LIST_SIZE / 2, LOAD_FACTOR);
        IntStream.range(0, BOOK_LIST_SIZE)
                .mapToObj(this::mockBook)
                .forEach(b -> books.put(b.getId(), b));
    }

    @Benchmark
    public void collectHashMapFromStream() {
        Map<Integer, Book> books = IntStream.range(0, BOOK_LIST_SIZE)
                .mapToObj(this::mockBook)
                .collect(Collectors.toMap(Book::getId, Function.identity(), (b1, b2) -> b1, HashMap::new));
    }

    @Benchmark
    public void collectHashMapFromStreamInitialCapacity() {
        Map<Integer, Book> books = IntStream.range(0, BOOK_LIST_SIZE)
                .mapToObj(this::mockBook)
                .collect(Collectors.toMap(Book::getId, Function.identity(), (b1, b2) -> b1, () -> new HashMap<>(BOOK_LIST_SIZE / 2)));
    }

    @Benchmark
    public void collectHashMapFromStreamInitialCapacityLoadFactor() {
        Map<Integer, Book> books = IntStream.range(0, BOOK_LIST_SIZE)
                .mapToObj(this::mockBook)
                .collect(Collectors.toMap(Book::getId, Function.identity(), (b1, b2) -> b1, () -> new HashMap<>(BOOK_LIST_SIZE / 2, LOAD_FACTOR)));
    }

    private Book mockBook(int id) {
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
                .include(MapBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
