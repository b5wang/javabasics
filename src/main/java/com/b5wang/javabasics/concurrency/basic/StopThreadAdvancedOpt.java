package com.b5wang.javabasics.concurrency.basic;

public class StopThreadAdvancedOpt {
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
        @Override
        public void run(){
            while(true){

                // Checking stop status
                if(this.isInterrupted()){
                    System.out.println("Exit thread of ChangeObjectThread");
                    break;
                }

                synchronized (job){
                    int v = (int)(System.currentTimeMillis()/1000);
                    job.key = v;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted when sleep");
                        this.interrupt();
                    }
                    job.value = v;
                }
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
            cot.interrupt();
        }
    }
}
