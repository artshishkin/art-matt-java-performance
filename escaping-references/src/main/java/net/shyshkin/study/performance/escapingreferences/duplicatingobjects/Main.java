package net.shyshkin.study.performance.escapingreferences.duplicatingobjects;

public class Main {

    public static void main(String[] args) {
        CustomerRecords records = new CustomerRecords();

        records.addCustomer(new Customer("John"));
        records.addCustomer(new Customer("Simon"));

        //Expected usage
        Customer customer = records.find("John");
        System.out.println("Customer is " + customer);

        //Problem
        records.find("John").setName("Buzz");
        System.out.println("Customer is " + customer);
        Customer absentBuzz = records.find("Buzz");
        System.out.println("We changed name but when we tried to find him we get `" + absentBuzz + "`");
    }

}
