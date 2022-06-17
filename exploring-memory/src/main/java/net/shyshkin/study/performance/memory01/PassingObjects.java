package net.shyshkin.study.performance.memory01;

public class PassingObjects {

    public static void main(String[] args) {
        var c = new Customer("Art");
        renameCustomer(c);
        System.out.println(c.getName());
    }

    public static void renameCustomer(Customer customer) {
        customer.setName("Kate");
    }
}
