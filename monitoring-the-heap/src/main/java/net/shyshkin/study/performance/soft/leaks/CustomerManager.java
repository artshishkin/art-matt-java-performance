package net.shyshkin.study.performance.soft.leaks;

import java.util.Date;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;


public class CustomerManager {

    private Queue<Customer> customers = new ConcurrentLinkedQueue<Customer>();
    private AtomicInteger nextAvalailbleId = new AtomicInteger();

    public void addCustomer(Customer customer) {
        customer.setId(nextAvalailbleId.getAndIncrement());
        customers.add(customer);
    }

    public Optional<Customer> getNextCustomer() {

        return Optional.ofNullable(customers.poll());
    }

    public void howManyCustomers() {
        int size = 0;
        size = customers.size();
        System.out.println("" + new Date() + " Customers in queue : " + size + " of " + nextAvalailbleId);
    }

}
