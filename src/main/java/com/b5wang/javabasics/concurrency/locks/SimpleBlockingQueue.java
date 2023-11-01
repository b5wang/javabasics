package com.b5wang.javabasics.concurrency.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 展示ReentrantLock and Condition的用法，利用他们实现一个有阻塞队列
 * */
public class SimpleBlockingQueue {

    private final static int MAX_LEN = 10;

    private final String[] arr = new String[MAX_LEN];

    private int count = 0;

    private final ReentrantLock lock = new ReentrantLock();

    private final Condition notEmpty = lock.newCondition();

    private final Condition notFull = lock.newCondition();

    public void put(String el){

    }
}
