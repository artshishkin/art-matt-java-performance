package net.shyshkin.study.performance.benchmarking;

import net.shyshkin.study.performance.benchmarking.art.PrimeNumbersArt;
import net.shyshkin.study.performance.benchmarking.matt.PrimeNumbersMatt;
import org.openjdk.jmh.annotations.Benchmark;

public class PrimesBenchmark {

    public static final int COUNT_PRIME_NUMBERS = 50;

    @Benchmark
    public void artOriginalBenchmarking() {
        NumberChecker numberChecker = new NumberChecker();
        var primeNumbers = new PrimeNumbersArt(numberChecker);
        for (int i = 2; i < COUNT_PRIME_NUMBERS; i++) {
            primeNumbers.generateNextPrimeOriginal();
        }
    }

    @Benchmark
    public void artOptimizedBenchmarking() {
        NumberChecker numberChecker = new NumberChecker();
        var primeNumbers = new PrimeNumbersArt(numberChecker);
        for (int i = 2; i < COUNT_PRIME_NUMBERS; i++) {
            primeNumbers.generateNextPrimeOptimized();
        }
    }

    @Benchmark
    public void mattOriginalBenchmarking() {
        NumberChecker numberChecker = new NumberChecker();
        var primeNumbers = new PrimeNumbersMatt(numberChecker);
        for (int i = 2; i < COUNT_PRIME_NUMBERS; i++) {
            primeNumbers.generateNextPrimeOriginal();
        }
    }

    @Benchmark
    public void mattOptimizedBenchmarking() {
        NumberChecker numberChecker = new NumberChecker();
        var primeNumbers = new PrimeNumbersMatt(numberChecker);
        for (int i = 2; i < COUNT_PRIME_NUMBERS; i++) {
            primeNumbers.generateNextPrimeOptimized();
        }
    }

}
