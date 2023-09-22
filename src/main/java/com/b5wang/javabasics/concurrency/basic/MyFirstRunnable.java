package com.b5wang.javabasics.concurrency.basic;

public class MyFirstRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Executing thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args){
        Thread t = new Thread(new MyFirstRunnable(),"My second thread");
        t.start();
    }
}
