package com.b5wang.javabasics.concurrency.locks;

import java.util.concurrent.locks.ReentrantLock;

public class TryLock implements Runnable{

    private ReentrantLock lock1 = new ReentrantLock();

    private ReentrantLock lock2 = new ReentrantLock();

    private int lock;

    public TryLock(int lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                executeJob(lock1, lock2);
            } else {
                executeJob(lock2, lock1);
            }
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    private void executeJob(ReentrantLock lk1, ReentrantLock lk2) throws InterruptedException {
        while(true){
            if(lk1.tryLock()){
                try{
                    Thread.sleep(1000);
                    if(lk2.tryLock()){
                        try {
                            System.out.println(Thread.currentThread().getName() + " job is done!");
                            return;
                        } finally {
                            lk2.unlock();
                        }
                    }
                } finally {
                    lk1.unlock();
                }
            }
        }
    }

    public static void main(String[] args){
        Thread t1 = new Thread(new TryLock(1));
        Thread t2 = new Thread(new TryLock(2));

        t1.start();
        t2.start();
    }
}
