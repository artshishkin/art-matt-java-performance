package net.shyshkin.study.performance.benchmarking;

import java.time.Duration;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        NumberChecker numberChecker = new NumberChecker();

        LocalDateTime start = LocalDateTime.now();
        for (int i = 1001; i < 2000; i++) {
            numberChecker.isPrimeOriginal(i);
        }
        LocalDateTime end = LocalDateTime.now();

        System.out.println("Time taken: " + Duration.between(start, end));
    }
}
