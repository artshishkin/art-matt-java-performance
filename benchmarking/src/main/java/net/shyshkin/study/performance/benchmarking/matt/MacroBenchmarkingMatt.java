package net.shyshkin.study.performance.benchmarking.matt;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MacroBenchmarkingMatt {

    public static void main(String[] args) throws InterruptedException {

        int target = 8;
        String primesTarget = System.getProperty("primes.target"); //through VM Options `-Dprimes.target=100` for example
        if (primesTarget != null) {
            target = Integer.parseInt(primesTarget);
        }

        LocalDateTime start = LocalDateTime.now();

        PrimeNumbersTask primeNumbersTask = new PrimeNumbersTask();
        Thread primesGeneratorThread = new Thread(primeNumbersTask);
        primesGeneratorThread.start();
        primesGeneratorThread.setName("primesGeneratorThread");

        FibonnaciNumbersTask fibonnaciNumbersTask = new FibonnaciNumbersTask();
        Thread fibonnaciNumbersThread = new Thread(fibonnaciNumbersTask);
        fibonnaciNumbersThread.setName("fibonnaciNumbersThread");
        fibonnaciNumbersThread.start();

        CombinedNumbersTask combinedNumbersTask = new CombinedNumbersTask();
        combinedNumbersTask.setPrimeNumbersTask(primeNumbersTask);
        combinedNumbersTask.setFibonnaciNumbersTask(fibonnaciNumbersTask);
        Thread combinedNumbersThread = new Thread(combinedNumbersTask);
        combinedNumbersThread.start();
        combinedNumbersThread.setName("combinedNumbersThread");

        int combined = 0;
        int iterations = 0;
        while (combined < target) {
            iterations++;
            combined = combinedNumbersTask.getSize();

            if (iterations > 400) {
                iterations = 0;
                System.out.println("Currently got " + combined + " matching numbers - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
                if (combined > 0) combinedNumbersTask.printCombinedNumbers();
                Thread.sleep(1000);
            }
        }

        primeNumbersTask.taskComplete();
        fibonnaciNumbersTask.taskComplete();
        combinedNumbersTask.taskComplete();

        System.out.println("Job done  - found " + combined + ".");
        if (combined > 0) combinedNumbersTask.printCombinedNumbers();

        LocalDateTime end = LocalDateTime.now();

        System.out.println("Time taken: " + Duration.between(start, end));
    }

}
