package net.shyshkin.study.performance.escapingreferences.usingmodules.customers.implementation;

import net.shyshkin.study.performance.escapingreferences.usingmodules.customers.ReadOnlyCustomer;

public class Customer implements ReadOnlyCustomer {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(Customer original) {
        this.name = original.name;
    }

    @Override
    public String toString() {
        return name;
    }

}
