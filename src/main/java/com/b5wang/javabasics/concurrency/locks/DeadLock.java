package com.b5wang.javabasics.concurrency.locks;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLock implements Runnable{

    private static ReentrantLock lock1 = new ReentrantLock();

    private static ReentrantLock lock2 = new ReentrantLock();

    private int lock;

    public DeadLock(int lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println( Thread.currentThread().getName() + " exit!");
        }
    }

    /**
     * 发生死锁，直到一个锁发生中断
     * */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DeadLock(1),"deadLock1");
        Thread t2 = new Thread(new DeadLock(2),"deadLock2");

        t1.start();
        t2.start();

        Thread.sleep(10000);

        t2.interrupt();
    }
}
