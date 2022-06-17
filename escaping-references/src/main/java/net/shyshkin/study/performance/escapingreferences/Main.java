package net.shyshkin.study.performance.escapingreferences;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        CustomerRecords records = new CustomerRecords();

        records.addCustomer(new Customer("John"));
        records.addCustomer(new Customer("Simon"));

        //Expected usage
        for (Customer next : records.getCustomers().values()) {
            System.out.println(next);
        }

        //Problem
        Map<String, Customer> myCustomers = records.getCustomers();
        myCustomers.clear(); //we do not want to allow this behaviour

    }

}
