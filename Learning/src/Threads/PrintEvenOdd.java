package Threads;

import java.util.Objects;

/**
 * Created by shubhamsharma on 10/19/2015.
 */
public class PrintEvenOdd {

    Object lock = new Object();
    int i=0;
    public static void main(String[] a)
    {
        PrintEvenOdd ts = new PrintEvenOdd();

        Thread t1 =  new Thread(ts.new printEven());
        Thread t2 =  new Thread(ts.new printOdd());
        t1.start();
        t2.start();
    }

    private class printOdd implements Runnable{
        int threadNo;

        @Override
        public void run() {
            try {
                while(i<50) {
                    synchronized (lock) {
                        if (i % 2 != 0) {
                            System.out.println("odd no " + i++);
                            lock.notify();
                        } else {
                            lock.wait();
                        }

                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class printEven implements Runnable{

        @Override
        public void run() {
            try{
                while(i<50) {

                    synchronized (lock) {
                        if (i % 2 == 0) {
                            System.out.println("even no " + i++);
                            lock.notify();
                        } else {
                            lock.wait();
                        }
                    }
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    private class printThird implements Runnable{

        @Override
        public void run() {
            try{
                while(i<50) {

                    synchronized (lock) {
                        if (i % 2 == 0) {
                            System.out.println("even no " + i++);
                            lock.notify();
                        } else {
                            lock.wait();
                        }
                    }
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
