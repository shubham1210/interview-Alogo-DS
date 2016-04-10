package Threads;

/**
 * Created by shubhamsharma on 10/19/2015.
 */
public class ThreeThreadPrintNo {

    Object lock = new Object();
    int i=0;
    public static void main(String[] a)
    {
        ThreeThreadPrintNo ts = new ThreeThreadPrintNo();

        Thread t1 =  new Thread(ts.new printFirst(0));
        Thread t2 =  new Thread(ts.new printSecond(1));
        Thread t3 =  new Thread(ts.new printThird(2));
        t1.start();
        t2.start();
        t3.start();
    }

    private class printFirst implements Runnable{
        int threadNo;

        public printFirst(int threadNo)
        {
            this.threadNo = threadNo;
        }
        @Override
        public void run() {
            try {
                while(i<50) {
                    synchronized (lock) {
                        if (i % 3 == threadNo) {
                            System.out.println("first thread " + i++);
                            lock.notifyAll();
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

    private class printSecond implements Runnable{
        int threadNo;

        public printSecond(int threadNo)
        {
            this.threadNo = threadNo;
        }

        @Override
        public void run() {
            try{
                while(i<50) {

                    synchronized (lock) {
                        if (i % 3 == threadNo) {
                            System.out.println("second thread " + i++);
                            lock.notifyAll();
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
        int threadNo;

        public printThird(int threadNo)
        {
            this.threadNo = threadNo;
        }
        @Override
        public void run() {
            try{
                while(i<50) {

                    synchronized (lock) {
                        if (i % 3 == threadNo) {
                            System.out.println("third Thread" + i++);
                            lock.notifyAll();
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
