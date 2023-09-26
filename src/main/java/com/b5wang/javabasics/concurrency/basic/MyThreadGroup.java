package com.b5wang.javabasics.concurrency.basic;

public class MyThreadGroup {

    private static class MyThread implements Runnable{
        @Override
        public void run() {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                System.out.println(Thread.currentThread().getThreadGroup().getName() + "-" +
                        Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup tg = new ThreadGroup("TG");

        Thread t1 = new Thread(tg, new MyThread(),"T1");
        Thread t2 = new Thread(tg, new MyThread(),"T2");
        Thread t3 = new Thread(tg, new MyThread(),"T3");

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(5000);
        System.out.println("Thread numbers in ThreadGroup: " + tg.activeGroupCount());

        Thread.sleep(10000);
        System.out.println("Thread numbers in ThreadGroup: " + tg.activeGroupCount());

        tg.interrupt();// interrupt all
    }

}
