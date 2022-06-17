package net.shyshkin.study.performance.escapingreferences.usingmodules.customers;

import net.shyshkin.study.performance.escapingreferences.usingmodules.customers.implementation.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerRecords {
    private Map<String, Customer> records;

    public CustomerRecords() {
        this.records = new HashMap<String, Customer>();
    }

    public void addCustomer(String customerName) {
        this.records.put(customerName, new Customer(customerName));
    }

    public Map<String, Customer> getCustomers() {
        return Map.copyOf(this.records);
    }

    public ReadOnlyCustomer find(String name) {
        Customer original = records.get(name);
        return (original == null) ?
                null :
                new Customer(original);
    }

}
