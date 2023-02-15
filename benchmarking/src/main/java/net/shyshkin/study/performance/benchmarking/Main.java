package net.shyshkin.study.performance.benchmarking;

public class Main {

    public static void main(String[] args) {
        NumberChecker numberChecker = new NumberChecker();
        System.out.println(numberChecker.isPrimeOriginal(22));
    }
}
