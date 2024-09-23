package com.b5wang.javabasics.alg.primary.collection;

/***
 * LIFO
 */

import java.util.Stack;

public class DemoStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // Push
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        System.out.println("stack: " + stack);
        System.out.println("stack.empty(): " + stack.empty());
        System.out.println("stack.peek(): " + stack.peek());// Get value on top without removing it
        // If stack is empty, throw exception
        System.out.println("stack: " + stack);
        System.out.println("stack.pop(): " + stack.pop());// Get value on top with removing it
        // If stack is empty, throw exception
        System.out.println("stack: " + stack);
        System.out.println("stack.get(0): " + stack.get(0));
        System.out.println("stack.get(1): " + stack.get(1));
        System.out.println("stack.size(): " + stack.size());
        System.out.println("stack: " + stack);
    }

}
