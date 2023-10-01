package com.b5wang.javabasics.concurrency.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockTimeout implements Runnable{

    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try{

            if(lock.tryLock(10, TimeUnit.MILLISECONDS)){
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " get lock!");
            } else{
                System.out.println("Failed to get lock!");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if(lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args){
        Thread t1 = new Thread(new TryLockTimeout());
        Thread t2 = new Thread(new TryLockTimeout());
        Thread t3 = new Thread(new TryLockTimeout());

        t1.start();
        t2.start();
        t3.start();
    }
}
