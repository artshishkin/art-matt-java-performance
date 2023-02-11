package net.shyshkin.study.performance.soft.leaks;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class CustomerManager {

    private List<Customer> customers = new CopyOnWriteArrayList<>();
    private AtomicInteger nextAvalailbleId = new AtomicInteger();

    public void addCustomer(Customer customer) {
        customer.setId(nextAvalailbleId.getAndIncrement());
        customers.add(customer);
    }

    public Optional<Customer> getNextCustomer() {

        if (customers.size() > 0) {
            return Optional.of(customers.remove(0));
        }
        return Optional.empty();
    }

    public void howManyCustomers() {
        int size = 0;
        size = customers.size();
        System.out.println("" + new Date() + " Customers in queue : " + size + " of " + nextAvalailbleId);
    }

}
