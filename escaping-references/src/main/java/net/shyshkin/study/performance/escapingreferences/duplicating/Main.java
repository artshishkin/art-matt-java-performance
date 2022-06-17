package net.shyshkin.study.performance.escapingreferences.duplicating;

import net.shyshkin.study.performance.escapingreferences.Customer;

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
        Customer initialObject = records.getCustomers().values().iterator().next();

        //No problem anymore
        Map<String, Customer> myCustomers = records.getCustomers();
        myCustomers.clear(); //we can not clear anymore

        records.getCustomers()
                .values()
                .forEach(System.out::println);

        Customer sameObject = records.getCustomers().values().iterator().next();
        System.out.println("Objects are the same: " + (initialObject == sameObject));
    }

}
