package net.shyshkin.study.performance.escapingreferences.iterator;

import net.shyshkin.study.performance.escapingreferences.Customer;

public class Main {

    public static void main(String[] args) {
        CustomerRecords records = new CustomerRecords();

        records.addCustomer(new Customer("John"));
        records.addCustomer(new Customer("Simon"));

        //Expected usage
//        records.iterator()
//                .forEachRemaining(System.out::println);
// OR
        for (Customer next : records) {
            System.out.println(next);
        }

        //Problem solved - can not do like this
//        Map<String, Customer> myCustomers = records.getCustomers();
//        myCustomers.clear(); //we do not want to allow this behaviour

    }

}
