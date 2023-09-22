package com.b5wang.javabasics.concurrency.basic;

public class MyFirstThread extends Thread{

    public MyFirstThread(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("Executing thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args){
        MyFirstThread t = new MyFirstThread("My first thread");
        t.start();
    }
}
