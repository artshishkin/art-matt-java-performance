package net.shyshkin.study.performance.escapingreferences.interfaceimmutable;

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
        return Map.copyOf(this.records);
    }

    public ReadOnlyCustomer find(String name) {
        return records.get(name);
    }

}
