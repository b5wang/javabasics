package com.b5wang.javabasics.concurrency.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreLimitThreads implements Runnable{

    private static Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();

            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ": done!");

            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        /**
         * Create 20 threads, but it has 5 maximum semaphore limitation
         * */
        for(int i=0; i<20; i++){
            executorService.submit(new SemaphoreLimitThreads());
        }
        executorService.shutdown();
    }
}
