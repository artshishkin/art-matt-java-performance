package net.shyshkin.study.performance.benchmarking.matt;

import net.shyshkin.study.performance.benchmarking.NumberChecker;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersMatt {

    private final List<Integer> primes = new ArrayList<Integer>();
    private Integer lastNumberChecked = 1;
    private Integer lastNumberRetrieved = 0;
    private final NumberChecker checker;

    public PrimeNumbersMatt(NumberChecker checker) {
        this.checker = checker;
    }

    public void generateNextPrimeOriginal() {

        //only the add really needs to be synchronized
        synchronized (this) {
            Integer testNumber = lastNumberChecked + 1;
            while (!checker.isPrimeOriginal(testNumber)) {
                testNumber++;
            }
            lastNumberChecked = testNumber;
            primes.add(testNumber);
        }
    }

    public void generateNextPrimeOptimized() {

        //only the add really needs to be synchronized
        synchronized (this) {
            int testNumber = lastNumberChecked + 1;
            while (!checker.isPrimeOptimized(testNumber)) {
                testNumber++;
            }
            lastNumberChecked = testNumber;
            primes.add(testNumber);
        }
    }
}
