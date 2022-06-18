package net.shyshkin.study.performance.exploringstrings;

public class Main {

    public static void main(String[] args) {

        String one = "hello";
        String two = "hello";

        System.out.println(one.equals(two));
        System.out.println(one == two);
        delimiter();

        String three = one + two;
        String four = one + two;

        System.out.println(three.equals(four));
        System.out.println(three == four);
        delimiter();

        Integer i = 76;
        String five = i.toString();
        String six = "76";
        System.out.println(five.equals(six));
        System.out.println(five == six);
        delimiter();

    }

    public static void delimiter() {
        System.out.println("---------------------");
    }
}
