package net.shyshkin.study.performance.escapingreferences.immutable;

import net.shyshkin.study.performance.escapingreferences.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerRecords {
    private Map<String, Customer> records;

    public CustomerRecords() {
        this.records = new HashMap<String, Customer>();
    }

    public void addCustomer(Customer c) {
        this.records.put(c.getName(), c);
    }

    public Map<String, Customer> getCustomers() {
//        return Collections.unmodifiableMap(this.records); // pre JVM10 syntax
        return Map.copyOf(this.records); // >=JVM10 syntax
    }
}
