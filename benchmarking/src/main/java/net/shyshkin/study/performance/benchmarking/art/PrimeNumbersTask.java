package net.shyshkin.study.performance.benchmarking.art;

import net.shyshkin.study.performance.benchmarking.NumberChecker;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PrimeNumbersTask implements Runnable {

    private final Queue<Integer> primes = new ConcurrentLinkedQueue<>();
    private Integer lastNumberChecked;
    private NumberChecker checker;
    private Boolean finished;

    private void generateNextPrime() {

        //only the add really needs to be synchronized

        Integer testNumber = lastNumberChecked + 1;
        while (!checker.isPrimeOptimized(testNumber)) {
            testNumber++;
        }
        lastNumberChecked = testNumber;
        primes.add(testNumber);
    }

    public void taskComplete() {
        finished = true;
    }

    public int getSize() {
        return (primes.size());
    }

    public Integer getNextNumber() {
        return primes.poll();
    }

    @Override
    public void run() {
        finished = false;
        checker = new NumberChecker();
        primes.add(2);
        lastNumberChecked = 2;

        while (!finished) {
            generateNextPrime();
        }
    }
}
