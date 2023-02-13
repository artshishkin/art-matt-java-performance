package net.shyshkin.study.performance.gc.tuning;

import java.util.LinkedList;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        var customers = new LinkedList<Customer>();

        while (true) {
            Customer customer = new Customer(UUID.randomUUID().toString());
            customers.add(customer);
            if (customers.size() > 10_000) {
                for (int i = 0; i < 5_000; i++) {
                    customers.poll();
                }
            }
        }
    }
}
