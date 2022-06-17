package net.shyshkin.study.performance.escapingreferences.immutable;

import net.shyshkin.study.performance.escapingreferences.Customer;

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

        //No problem anymore - throws java.lang.UnsupportedOperationException
//        Map<String, Customer> myCustomers = records.getCustomers();
//        myCustomers.clear(); //we can not clear anymore

        Customer sameObject = records.getCustomers().values().iterator().next();
        System.out.println("Objects are the same: " + (initialObject == sameObject));
    }

}
