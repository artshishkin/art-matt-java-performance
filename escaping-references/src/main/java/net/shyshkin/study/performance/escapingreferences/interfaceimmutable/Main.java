package net.shyshkin.study.performance.escapingreferences.interfaceimmutable;

public class Main {

    public static void main(String[] args) {
        CustomerRecords records = new CustomerRecords();

        records.addCustomer(new Customer("John"));
        records.addCustomer(new Customer("Simon"));

        //Expected usage
        ReadOnlyCustomer customer = records.find("John");
        System.out.println("Customer is " + customer);

        //Problem absent - can not set name
//        records.find("John").setName("Buzz");
    }

}
