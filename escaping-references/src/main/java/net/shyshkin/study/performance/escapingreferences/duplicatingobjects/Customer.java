package net.shyshkin.study.performance.escapingreferences.duplicatingobjects;

public class Customer {
    private String name;

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

    public String toString() {
        return name;
    }

}
