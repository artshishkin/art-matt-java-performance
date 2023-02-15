package net.shyshkin.study.performance.benchmarking;

public class NumberChecker {

    public Boolean isPrimeOriginal(Integer testNumber) {
        for (Integer i = 2; i < testNumber; i++) {
            if (testNumber % i == 0) return false;
        }
        return true;
    }

    public Boolean isPrimeOptimized(int testNumber) {
        int maxMultiplier = (int) Math.sqrt(testNumber);
        for (int i = 2; i <= maxMultiplier; i++) {
            if (testNumber % i == 0) return false;
        }
        return true;
    }

}
