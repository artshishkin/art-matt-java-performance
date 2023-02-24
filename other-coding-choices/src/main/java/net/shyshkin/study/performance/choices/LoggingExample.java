package net.shyshkin.study.performance.choices;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class LoggingExample {

    Logger logger = Logger.getLogger("My Logger");

    @Benchmark
    public void logInfo() {
        logger.log(Level.INFO, "Result of time-consuming method: " + timeConsumingMethod());
    }

    @Benchmark
    public void logFine() {
        logger.log(Level.FINE, "Result of time-consuming method: " + timeConsumingMethod());
    }

    @Benchmark
    public void logFineParameters() {
        logger.log(Level.FINE, "Result of time-consuming method: {0}", timeConsumingMethod());
    }

    @Benchmark
    public void logFineLazy() {
        logger.log(Level.FINE, () -> "Result of time-consuming method: " + timeConsumingMethod());
    }

    @Benchmark
    public void logFineIsLoggable() {
        if (logger.isLoggable(Level.FINE))
            logger.log(Level.FINE, "Result of time-consuming method: " + timeConsumingMethod());
    }

    private String timeConsumingMethod() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ignored) {
        }
        return "OK";
    }

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(LoggingExample.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
