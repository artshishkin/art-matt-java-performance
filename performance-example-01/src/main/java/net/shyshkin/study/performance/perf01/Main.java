package net.shyshkin.study.performance.perf01;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Date startTime = new Date();
        PrimeNumbers primeNumbers = new PrimeNumbers();
        Integer max = Integer.parseInt(args[0]);
        primeNumbers.generateNumbers(max);
        Date endTime = new Date();
        System.out.println("Elapsed time: " + (endTime.getTime() - startTime.getTime())+" ms.");
    }

}
