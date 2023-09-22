package com.b5wang.javabasics.concurrency.basic;

public class StopThreadUnsafeFix {
    private static Job job = new Job();

    /**
     * key should always equal to value.
     * */
    private static class Job{
        private int key = 0;
        private int value = 0;

        public String toString(){
            return "Job{key=" + key + ", value=" + value + "}";
        }
    }

    private static class ChangeObjectThread extends Thread{

        private volatile boolean isStop = false;

        public void terminate(){
            isStop = true;
        }

        @Override
        public void run(){
            while(true){

                if(isStop){
                    System.out.println("Exit thread of ChangeObjectThread");
                    break;
                }

                synchronized (job){
                    int v = (int)(System.currentTimeMillis()/1000);
                    job.key = v;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    job.value = v;
                }
                /**
                 * A hint to the scheduler that the current thread is willing to yield its current use of a processor.
                 * The scheduler is free to ignore this hint.
                 * */
                Thread.yield();
            }
        }
    }

    private static class ReadObjectThread extends Thread{
        @Override
        public void run(){
            while(true){
                synchronized (job){
                    if(job.key != job.value){
                        System.out.println(job.toString());
                    }
                }
                Thread.yield();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ReadObjectThread rot = new ReadObjectThread();
        rot.start();

        while(true){
            ChangeObjectThread cot = new ChangeObjectThread();
            cot.start();
            Thread.sleep(150);
            // cot.stop();
            cot.terminate();
        }
    }

}
