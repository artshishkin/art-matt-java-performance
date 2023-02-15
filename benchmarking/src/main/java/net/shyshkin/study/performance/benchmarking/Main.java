package net.shyshkin.study.performance.benchmarking;

import java.time.Duration;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        NumberChecker numberChecker = new NumberChecker();

        //warm up period
        for (int i = 1; i < 10_000; i++)
            numberChecker.isPrimeOptimized(i);

        Thread.sleep(2000);

        System.out.println("Warmup finished, now measuring");

        LocalDateTime start = LocalDateTime.now();
        for (int i = 1; i < 50_000; i++) {
            numberChecker.isPrimeOptimized(i);
        }
        LocalDateTime end = LocalDateTime.now();

        System.out.println("Time taken: " + Duration.between(start, end));
    }
}
