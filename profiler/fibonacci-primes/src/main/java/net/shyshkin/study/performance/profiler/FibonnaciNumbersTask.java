package net.shyshkin.study.performance.profiler;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FibonnaciNumbersTask implements Runnable {

    private Queue<Integer> fibonnacis = new ConcurrentLinkedQueue<>();
    private Boolean finished;

    public void taskComplete() {
        finished = true;
    }

    public int getSize() {
        return (fibonnacis.size());
    }

    public Integer getNextNumber() {
        return fibonnacis.poll();
    }


    @Override
    public void run() {
        finished = false;
        int a = 0;
        int b = 1;

        fibonnacis.add(a);
        fibonnacis.add(b);

        while (!finished) {
            //only the add really needs to be synchronized.

            //we need to stop the fibonnaci numbers growing too quickly so we'll pause if there are > 100 waiting to be collected
            if (fibonnacis.size() < 100) {
                int c = a + b;
                fibonnacis.add(c);
                a = b;
                b = c;
            }

        }

    }

}
