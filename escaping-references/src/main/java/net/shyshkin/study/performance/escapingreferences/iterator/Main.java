package net.shyshkin.study.performance.escapingreferences.iterator;

import net.shyshkin.study.performance.escapingreferences.Customer;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        CustomerRecords records = new CustomerRecords();

        records.addCustomer(new Customer("John"));
        records.addCustomer(new Customer("Simon"));

        //Expected usage
        for (Customer next : records) {
            System.out.println(next);
        }

        Iterator<Customer> iterator = records.iterator();
        iterator.next();
        iterator.remove(); //we can remove object from a collection

        System.out.println("------after another brake------");

        for (Customer next : records) {
            System.out.println(next);
        }

    }

}
