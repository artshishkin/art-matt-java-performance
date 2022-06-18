package net.shyshkin.study.performance.exploringstrings;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ManyStrings {
    public static void main(String[] args) {

        var start = LocalDateTime.now();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            String val = String.valueOf(i).intern();
            strings.add(val);
        }
        var stop = LocalDateTime.now();
        System.out.println("Elapsed time was :" + Duration.between(start, stop));
        System.out.println("Strings Count: " + strings.size());
        System.out.println("Last string: " + strings.get(strings.size() - 1));

        //statistics unavailable at this moment
        //to prevent this bug just add pause
        sleep(5000);

    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
