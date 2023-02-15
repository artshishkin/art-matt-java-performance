package net.shyshkin.study.performance.profiler;

import java.util.LinkedList;
import java.util.List;

public class CombinedNumbersTask implements Runnable {

    private FibonnaciNumbersTask fibonnaciNumbersTask;
    private PrimeNumbersTask primeNumbersTask;

    private List<Integer> primes = new LinkedList<>();
    private List<Integer> fibonnacis = new LinkedList<>();
    private List<Integer> combined = new LinkedList<>();

    private Boolean finished;

    public void taskComplete() {
        finished = true;
    }

    public void printCombinedNumbers() {
        System.out.println(combined.toString());
    }

    public void printStatus() {
        System.out.println("primes : " + primes.size() + " fibs : " + fibonnacis.size());
    }

    public void setFibonnaciNumbersTask(FibonnaciNumbersTask fibonnaciNumbersTask) {
        this.fibonnaciNumbersTask = fibonnaciNumbersTask;
    }

    public void setPrimeNumbersTask(PrimeNumbersTask primeNumbersTask) {
        this.primeNumbersTask = primeNumbersTask;
    }

    public int getSize() {
        return combined.size();
    }

//    Threads in the application were blocked on locks for a total of 35,415 s.
//
//    The most blocking monitor class was ''net.shyshkin.study.performance.profiler.CombinedNumbersTask'', which was blocked 151 times for a total of 35,415 s.
//-----------------------------
//  After improving -> this issue disappears in JMC

    @Override
    public void run() {
        finished = false;

        while (!finished) {
            Integer prime = primeNumbersTask.getNextNumber();
            if (prime != null) primes.add(prime);
            Integer fib = fibonnaciNumbersTask.getNextNumber();
            if (fib != null) fibonnacis.add(fib);

            List<Integer> temp = new LinkedList<>(primes);
            temp.retainAll(fibonnacis);

            combined = temp;

        }

    }

}
