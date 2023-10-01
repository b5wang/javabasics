package com.b5wang.javabasics.concurrency.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implement a counter with ReentrantLock and Condition
 *
 * */
public class ReentrantLockConditionCounter implements Runnable{

    private static int counter = 0;

    private static ReentrantLock counterLock = new ReentrantLock();

    private static Condition counterCondition = counterLock.newCondition();

    private ReentrantLock threadLock = new ReentrantLock();

    private Condition threadCondition = threadLock.newCondition();

    private boolean isSuspend = false;

    private String name;

    public ReentrantLockConditionCounter(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {

            /**
             * suspend
             * 有个特殊情况，比如 T1, T2两个线程
             * 其中一个挂起的时候，另外一个正是await状态。结果变成T1 T2同时挂起。
             * 为了避免这种状况，挂起的同时要notify或者signal其它线程，让出执行通道.
             */
            try {
                threadLock.lockInterruptibly();
                while (isSuspend) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": go into suspend!");
                        threadCondition.await();
                    } catch (InterruptedException e) {
                        // Interrupt happen during suspend, break
                        System.out.println(Thread.currentThread().getName() + ": threadCondition.await() got interrupted!");
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": threadLock.lockInterruptibly() got interrupted!");
                Thread.currentThread().interrupt();
            } finally {
                if(threadLock.isHeldByCurrentThread()){
                    threadLock.unlock();
                }
            }


            // terminate
            if(Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName() + " terminate!");
                break;
            }

            // execute work
            try{
                counterLock.lockInterruptibly();

                Thread.sleep(100);
                counter++;
                System.out.println(Thread.currentThread().getName() + ": " + counter);

                //counterCondition.signal();
                //counterCondition.await();
            } catch (InterruptedException e) {
                // terminate
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + ": interrupted!");
            } finally {
                if(counterLock.isHeldByCurrentThread()) {
                    counterLock.unlock();
                }
            }
            Thread.yield();
        }
    }

    public void suspend(){
        isSuspend = true;
        System.out.println(name + ": suspend ----------------------------");
    }

    public void resume(){
        isSuspend = false;
        try{
            threadLock.lockInterruptibly();
            threadCondition.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(name + ": resume ----------------------------");
            if(threadLock.isHeldByCurrentThread()) {
                threadLock.unlock();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockConditionCounter c1 = new ReentrantLockConditionCounter("T1");
        ReentrantLockConditionCounter c2 = new ReentrantLockConditionCounter("T2");
        ReentrantLockConditionCounter c3 = new ReentrantLockConditionCounter("T3");

        Thread t1 = new Thread(c1,"T1");
        Thread t2 = new Thread(c2,"T2");
        Thread t3 = new Thread(c3,"T3");

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(5000);
        c1.suspend();
        c2.suspend();

        Thread.sleep(5000);
        c1.resume();

        Thread.sleep(5000);
        c3.suspend();

        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
    }

}
