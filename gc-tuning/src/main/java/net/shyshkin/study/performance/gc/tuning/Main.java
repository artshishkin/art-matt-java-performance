package net.shyshkin.study.performance.gc.tuning;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        var customers = new LinkedList<Customer>();

        while (true) {
            String name = new String("Art");
            Customer customer = new Customer(name);
            customers.add(customer);
            if (customers.size() > 10_000) {
                System.out.println(customers.getFirst().getName() == customers.get(1_000).getName()); //does not work
                for (int i = 0; i < 5_000; i++) {
                    customers.poll();
                }
            }
        }
    }
}
