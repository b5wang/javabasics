package com.b5wang.javabasics.concurrency.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * Implement a multi-thread
 * */
public class ReentrantLockCounter implements Runnable{

    /**
     * ReentrantLock有两个构造方法，还有一个是fair=true/false, 公平锁
     * */
    private static ReentrantLock reentrantLock = new ReentrantLock();

    static int counter = 0;

    @Override
    public void run() {
        for(int i=0; i<10000;i++){
            reentrantLock.lock();
            try {
                counter++;
            }finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ReentrantLockCounter());
        Thread t2 = new Thread(new ReentrantLockCounter());
        Thread t3 = new Thread(new ReentrantLockCounter());
        Thread t4 = new Thread(new ReentrantLockCounter());
        Thread t5 = new Thread(new ReentrantLockCounter());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("Counter: " + counter);
    }

}
