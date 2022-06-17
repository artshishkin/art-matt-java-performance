package net.shyshkin.study.performance.escapingreferences.interfaceimmutable;

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

    @Override
    public String toString() {
        return name;
    }

}