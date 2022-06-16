package net.shyshkin.study.performance.perf01;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(20000);
        System.out.println("Starting the work...");
        PrimeNumbers primeNumbers = new PrimeNumbers();
        Integer max = Integer.parseInt(args[0]);
        primeNumbers.generateNumbers(max);
    }

}
