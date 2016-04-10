package Threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by shubhamsharma on 12/10/2015.
 */
public class CyclicBarrierExample {

    private static class Task implements Runnable{

        private CyclicBarrier barrier;

        public Task(CyclicBarrier barrier)
        {
            this.barrier = barrier;
        }

        public void run()
        {
            try {
                System.out.println("Before barrier"+Thread.currentThread().getName());
                barrier.await();
                System.out.println("After barrier"+Thread.currentThread().getName());

            }catch (InterruptedException e)
            {

            }
            catch (BrokenBarrierException e)
            {

            }
        }

        public static void main(String[] a)
        {
            CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
                @Override
                public void run() {
                    System.out.println("in barrier");
                }
            });

            Thread t1 = new Thread(new Task(cb), "Thread 1");
            Thread t2 = new Thread(new Task(cb), "Thread 2");
            Thread t3 = new Thread(new Task(cb), "Thread 3");

            t1.start();
            t2.start();
            t3.start();

        }

    }



}
