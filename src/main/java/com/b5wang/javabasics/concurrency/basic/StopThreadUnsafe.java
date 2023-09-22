package com.b5wang.javabasics.concurrency.basic;

public class StopThreadUnsafe {

    private static Job j = new Job();

    private static class Job{
        private int id = 0;
        private String name = "0";
    }

    private static class ChangeJobThread extends Thread{
        @Override
        public void run(){
            while(true){
                synchronized (j){
                    int id = 
                }
            }
        }
    }

}
