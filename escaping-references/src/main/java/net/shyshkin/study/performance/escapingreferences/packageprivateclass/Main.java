package net.shyshkin.study.performance.escapingreferences.packageprivateclass;

import net.shyshkin.study.performance.escapingreferences.packageprivateclass.customers.CustomerRecords;
import net.shyshkin.study.performance.escapingreferences.packageprivateclass.customers.ReadOnlyCustomer;

public class Main {

    public static void main(String[] args) {
        CustomerRecords records = new CustomerRecords();

        records.addCustomer("John");
        records.addCustomer("Simon");

        //Expected usage
        ReadOnlyCustomer customer = records.find("John");
        System.out.println("Customer is " + customer);

        //Can not cast
        ReadOnlyCustomer readOnlyJohn = records.find("John");
        //Customer castedJohn = (Customer) readOnlyJohn;

    }

}
