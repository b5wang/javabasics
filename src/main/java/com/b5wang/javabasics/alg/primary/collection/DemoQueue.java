package com.b5wang.javabasics.alg.primary.collection;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class DemoQueue {

    public static void main(String[] args) {

        /**
         * FIFO
         * */
        Queue<Integer> queue = new ArrayBlockingQueue<>(2);// LinkedList -> Deque -> Queue

        // Append to list end
        System.out.println("queue.add(1)         = " + queue.add(1));
        System.out.println("queue.add(2)         = " + queue.add(2));
        try{
            System.out.println("queue.add(3)       = " + queue.add(3));// Queue full, throw exception
        }catch (java.lang.IllegalStateException ex){
            System.out.println("queue.add(3)         =, empty queue, throw exception");
        }
        System.out.println("queue.offer(3)       = " + queue.offer(3));// No exception
        System.out.println("queue                = " + queue);

        // Get first element, and remove it from queue
        System.out.println("queue.remove()       = " + queue.remove());
        System.out.println("queue.poll()         = " + queue.poll());
        System.out.println("queue.poll()         = " + queue.poll());// Get value from empty queue, return null
        try {
            System.out.println("queue.remove()       = " + queue.remove());// Get value from empty queue, throw exception
        }catch (java.util.NoSuchElementException ex){
            System.out.println("queue.remove()       =, empty queue, throw exception");
        }
        System.out.println("queue                = " + queue);

        // Get first element, but not remove
        try {
            System.out.println("queue.element()      = " + queue.element());// throw exception
        }catch (java.util.NoSuchElementException ex){
            System.out.println("queue.element()      =, empty queue, throw exception");
        }
        System.out.println("queue.peek()         = " + queue.peek());

        System.out.println("queue                = " + queue);
        System.out.println("queue.add(3)         = " + queue.add(3));
        System.out.println("queue.offer(4)       = " + queue.offer(4));
        System.out.println("queue                = " + queue);
        System.out.println("queue.element()      = " + queue.element());
        System.out.println("queue.peek()         = " + queue.peek());
    }

}
