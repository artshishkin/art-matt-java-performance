package net.shyshkin.study.performance.benchmarking.art;

import net.shyshkin.study.performance.benchmarking.NumberChecker;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PrimeNumbersArt {

    private final Queue<Integer> primes = new ConcurrentLinkedQueue<>();
    private Integer lastNumberChecked = 1;
    private final NumberChecker checker;

    public PrimeNumbersArt(NumberChecker checker) {
        this.checker = checker;
    }

    public void generateNextPrimeOriginal() {

        Integer testNumber = lastNumberChecked + 1;
        while (!checker.isPrimeOriginal(testNumber)) {
            testNumber++;
        }
        lastNumberChecked = testNumber;
        primes.add(testNumber);
    }

    public void generateNextPrimeOptimized() {

        int testNumber = lastNumberChecked + 1;
        while (!checker.isPrimeOptimized(testNumber)) {
            testNumber++;
        }
        lastNumberChecked = testNumber;
        primes.add(testNumber);
    }

}
