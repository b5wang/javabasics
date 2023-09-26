package com.b5wang.javabasics.concurrency.basic;

import com.b5wang.javabasics.concurrency.basic.suspend.Counter;

public class SynchronizedCounter {

    private static class Counter{
        private int i = 0;

        public synchronized void increase(){
            i++;
        }

        public int getCounter(){
            return i;
        }
    }

    private static class CountingThread implements Runnable{

        private SynchronizedCounter.Counter counter;

        public CountingThread(SynchronizedCounter.Counter counter){
            this.counter = counter;
        }

        @Override
        public void run() {
            for(int i = 1; i<=10000; i++){
                counter.increase();
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(new CountingThread(counter),"t1");
        Thread t2 = new Thread(new CountingThread(counter),"t2");
        Thread t3 = new Thread(new CountingThread(counter),"t3");
        Thread t4 = new Thread(new CountingThread(counter),"t4");
        Thread t5 = new Thread(new CountingThread(counter),"t5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        // Waiting all threads complete
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("Final counter: " + counter.getCounter());// should be 50000
    }
}
