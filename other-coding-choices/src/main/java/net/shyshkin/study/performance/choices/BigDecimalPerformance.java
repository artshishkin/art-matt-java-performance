package net.shyshkin.study.performance.choices;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class BigDecimalPerformance {

    private BigDecimal addNumbersBigDecimal(long howMany) {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal adder = new BigDecimal(17.31);
        for (long l = 0; l <= howMany; l++) {
            result = result.add(adder);
        }
        return (result);
    }

    private BigDecimal addNumbersDouble(long howMany) {
        Double result = 0d;
        Double adder = 17.31d;
        for (long l = 0; l <= howMany; l++) {
            result = result + adder;
        }
        return (new BigDecimal(result));
    }

    @Benchmark
    public void addNumbersBigDecimalBenchmark() {
        addNumbersBigDecimal(1_000_000);
    }

    @Benchmark
    public void addNumbersDoubleBenchmark() {
        addNumbersDouble(1_000_000);
    }

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(BigDecimalPerformance.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}

