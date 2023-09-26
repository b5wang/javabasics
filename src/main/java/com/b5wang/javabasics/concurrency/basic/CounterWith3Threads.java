package com.b5wang.javabasics.concurrency.basic;

/**
 * 用多个线程做计数器，主要是实践线程之前如何协作
 * wait和notify
 * */
public class CounterWith3Threads {

    private static class Counter implements Runnable{

        private static volatile int counter = 0;

        private static Object object = new Object();

        @Override
        public void run() {
            while(true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().getName() + " exit!");
                    break;
                }

                synchronized (object){
                    counter = counter + 1;
                    System.out.println(Thread.currentThread().getName() + ": counter = " + counter);
                    try {
                        Thread.sleep(1000);
                        object.notify();
                        object.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Counter(),"T1");
        Thread t2 = new Thread(new Counter(),"T2");
        Thread t3 = new Thread(new Counter(),"T3");

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(1000 * 60);
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
    }
}
