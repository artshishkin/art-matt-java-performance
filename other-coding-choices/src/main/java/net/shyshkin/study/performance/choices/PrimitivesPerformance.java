package net.shyshkin.study.performance.choices;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class PrimitivesPerformance {

    private long addNumbersPrimitive(long howMany) {
        long result = 0;
        for (long l = 0; l <= howMany; l++) {
            result = result + 17L;
        }
        return (result);
    }

    private double addNumbersDoublePrimitive(long howMany) {
        double result = 0.0;
        for (long l = 0; l <= howMany; l++) {
            result = result + 17.0;
        }
        return (result);
    }

    private Long addNumbersObject(Long howMany) {
        Long result = 0L;
        Long adder = 17L;
        for (Long l = 0L; l <= howMany; l++) {
            result = result + adder;
        }
        return (result);
    }

    private Double addNumbersDoubleObject(Long howMany) {
        Double result = 0.0;
        Double adder = 17.0;
        for (Long l = 0L; l <= howMany; l++) {
            result = result + adder;
        }
        return (result);
    }

    @Benchmark
    public void addNumbersPrimitiveBenchmark() {
        long res = addNumbersPrimitive(10_000_000L);
    }

    @Benchmark
    public void addNumbersObjectBenchmark() {
        Long res = addNumbersObject(10_000_000L);
    }

    @Benchmark
    public void addNumbersPrimitiveDoubleBenchmark() {
        var res = addNumbersDoublePrimitive(10_000_000L);
    }

    @Benchmark
    public void addNumbersObjectDoubleBenchmark() {
        var res = addNumbersDoubleObject(10_000_000L);
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
                .include(PrimitivesPerformance.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}

