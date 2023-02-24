package net.shyshkin.study.performance.choices;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class StringBuilderPerformance {

    private static final String[] firstNames = {"Adam", "Bill", "Carey", "Delia", "Emma", "Frank", "Gillian", "Harold"};
    private static final String[] middleNames = {"Irene", "Jill", "Kevin", "Leanne", "Mike", "Nick", "Orphelia", "Pete"};
    private static final String[] surnames = {"Green", "White", "Black", "Brown", "Purple", "Yellow", "Pink", "Orange"};

    private static final ThreadLocalRandom r = ThreadLocalRandom.current();

    @Benchmark
    public String generateNamesConcat() {
        String result = firstNames[r.nextInt(8)];
        result = result + " ";
        result = result + middleNames[r.nextInt(8)];
        result = result + " ";
        result = result + surnames[r.nextInt(8)];
        result = result + " and ";
        result = result + firstNames[r.nextInt(8)];
        result = result + " ";
        result = result + middleNames[r.nextInt(8)];
        result = result + " ";
        result = result + surnames[r.nextInt(8)];
        return (result);
    }

    @Benchmark
    public String generateNamesConcatOptimized() {
        String result = firstNames[r.nextInt(8)]
                + " "
                + middleNames[r.nextInt(8)]
                + " "
                + surnames[r.nextInt(8)]
                + " and "
                + firstNames[r.nextInt(8)]
                + " "
                + middleNames[r.nextInt(8)]
                + " "
                + surnames[r.nextInt(8)];
        return (result);
    }

    @Benchmark
    public String generateNamesStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append(firstNames[r.nextInt(8)]);
        sb.append(" ");
        sb.append(middleNames[r.nextInt(8)]);
        sb.append(" ");
        sb.append(surnames[r.nextInt(8)]);
        sb.append(" and ");
        sb.append(firstNames[r.nextInt(8)]);
        sb.append(" ");
        sb.append(middleNames[r.nextInt(8)]);
        sb.append(" ");
        sb.append(surnames[r.nextInt(8)]);
        return sb.toString();
    }

    @Benchmark
    public String generateNamesStringJoiner() {
        var sj = new StringJoiner(" ");
        sj.add(firstNames[r.nextInt(8)]);
        sj.add(middleNames[r.nextInt(8)]);
        sj.add(surnames[r.nextInt(8)]);
        sj.add("and");
        sj.add(firstNames[r.nextInt(8)]);
        sj.add(middleNames[r.nextInt(8)]);
        sj.add(surnames[r.nextInt(8)]);
        return sj.toString();
    }

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(StringBuilderPerformance.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
