package net.shyshkin.study.performance.choices;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class LoopPerformance {

    private static final String[] firstNames = {"Adam", "Bill", "Carey", "Delia", "Emma", "Frank", "Gillian", "Harold"};
    private static final String[] middleNames = {"Irene", "Jill", "Kevin", "Leanne", "Mike", "Nick", "Orphelia", "Pete"};
    private static final String[] surnames = {"Green", "White", "Black", "Brown", "Purple", "Yellow", "Pink", "Orange"};

    private static final ThreadLocalRandom r = ThreadLocalRandom.current();

    private static final List<String> names = IntStream.rangeClosed(1, 5_000_000)
            .mapToObj(i -> generateName())
            .collect(Collectors.toList());

    @Benchmark
    public void calculateLengthLoopBenchmark() {
        calculateLengthLoop(names);
    }

    @Benchmark
    public void calculateLengthStreamBenchmark() {
        calculateLengthStream(names);
    }

    @Benchmark
    public void calculateLengthStreamFlatMapBenchmark() {
        calculateLengthStreamFlatMap(names);
    }

    @Benchmark
    public void calculateLengthParallelStreamBenchmark() {
        calculateLengthParallelStream(names);
    }

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(LoopPerformance.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    private long calculateLengthLoop(List<String> names) {
        long length = 0;
        for (String name : names) {
            long nameLength = name.length();
            if (nameLength > 9)
                length += name.length();
        }
        return length;
    }

    private long calculateLengthStream(List<String> names) {
        return names.stream()
                .mapToInt(String::length)
                .filter(l -> l > 9)
                .sum();
    }

    private long calculateLengthStreamFlatMap(List<String> names) {
        return names.stream()
                .flatMapToInt(s -> IntStream.of(s.length() > 9 ? s.length() : null))
                .sum();
    }

    private long calculateLengthParallelStream(List<String> names) {
        return names.parallelStream()
                .mapToInt(String::length)
                .filter(l -> l > 9)
                .sum();
    }

    private static String generateName() {
        return firstNames[r.nextInt(8)] + " "
                + middleNames[r.nextInt(8)] + " "
                + surnames[r.nextInt(8)];
    }

}
