package Threads;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shubhamsharma on 10/19/2015.
 */
public class PrintOddEvenExecutor {

    int i = 0;
    Object lock = new Object();

    public static void main(String[] a) {
        final PrintOddEvenExecutor printOddEvenExecutor = new PrintOddEvenExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(2);


        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (printOddEvenExecutor.i < 10) {
                    try {
                        synchronized (printOddEvenExecutor.lock) {
                            if (printOddEvenExecutor.i % 2 == 0) {
                                System.out.println("from first = " + printOddEvenExecutor.i++);
                                printOddEvenExecutor.lock.notifyAll();
                            } else {
                                printOddEvenExecutor.lock.wait();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (printOddEvenExecutor.i < 10) {
                    try {
                        synchronized (printOddEvenExecutor.lock) {
                            if (printOddEvenExecutor.i % 2 != 0) {
                                System.out.println("from second = " + printOddEvenExecutor.i++);
                                printOddEvenExecutor.lock.notifyAll();
                            } else {
                                printOddEvenExecutor.lock.wait();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
