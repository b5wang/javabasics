package com.b5wang.javabasics.concurrency.basic.suspend;

public class Counter extends Thread{


    private String threadName;

    private boolean isSuspended = false;

    private static volatile int counter = 0;

    private static Object object = new Object();

    public Counter(){
        super();
    }

    public Counter(String name){
        super(name);
        threadName = name;
    }

    @Override
    public void run() {
        while(true){

            // 挂起
            synchronized (this) {
                while (isSuspended) {
                    try {
                        /**
                         * 不一定所有挂起的线程都会打印这句。
                         * 因为后面还有个wait，如果其它线程都被挂起，后面的wait就不会有线程去notify，线程就会停在后面的wait
                         * */
                        System.out.println(Thread.currentThread().getName() + " suspended!");
                        this.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println(Thread.currentThread().getName() + " interrupted at wait(1)!");
                        break;
                    }
                }
            }

            // 退出
            if(Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName() + " exit!");
                break;
            }

            synchronized (object){
                counter = counter + 1;
                System.out.println(Thread.currentThread().getName() + ": counter = " + counter);
                try {
                    Thread.sleep(1000);
                    //object.notify();
                    //object.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " interrupted at wait(2)!");
                }
            }
            Thread.yield();
        }
    }

    public void mySuspend(){
        this.isSuspended = true;
        System.out.println(threadName + " plan to suspend!");
    }

    public void myResume(){
        this.isSuspended = false;
        synchronized (this){
            notify();
            System.out.println(threadName + " plan to resume!");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        testCase1();
        testCase2();

    }

    /**Test case 1:
     * 所有线程正常运行30秒后退出
     * */
    private static void testCase1() throws InterruptedException {
        Counter t1 = new Counter("T1");
        Counter t2 = new Counter("T2");
        Counter t3 = new Counter("T3");

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(30*1000);

        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
    }

    /**Test case 2:
     * 1. 线程运行10秒后挂起，
     * 2. 10秒后线程继续
     * 3. 10秒后退出
     * */
    private static void testCase2() throws InterruptedException {
        Counter t1 = new Counter("T1");
        Counter t2 = new Counter("T2");
        Counter t3 = new Counter("T3");

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(10*1000);
        t1.mySuspend();
        t2.mySuspend();
        t3.mySuspend();

        Thread.sleep(10*1000);
        t1.myResume();
        t2.myResume();
        t3.myResume();

        Thread.sleep(10*1000);
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
    }
}
