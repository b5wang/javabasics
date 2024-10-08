package com.b5wang.javabasics.alg.primary.collection;

/***
 * LIFO
 */

import java.util.Arrays;
import java.util.Stack;

public class DemoStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // Push, add element on top
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        System.out.println("stack: " + stack);
        System.out.println("stack.empty(): " + stack.empty());

        // If stack is empty, throw exception
        // Get value on top without removing it
        System.out.println("stack.peek(): " + stack.peek());
        System.out.println("stack: " + stack);

        // Get value on top with removing it
        // If stack is empty, throw exception
        System.out.println("stack.pop(): " + stack.pop());
        System.out.println("stack: " + stack);

        // Get value by index
        System.out.println("stack.get(0): " + stack.get(0));
        System.out.println("stack.get(1): " + stack.get(1));
        System.out.println("stack.size(): " + stack.size());
        System.out.println("stack: " + stack);

        // Search
        System.out.println("stack.search(\"5\"): " + stack.search("5"));
        System.out.println("stack.search(\"4\"): " + stack.search("4"));
        System.out.println("stack.search(\"3\"): " + stack.search("3"));
        System.out.println("stack.search(\"2\"): " + stack.search("2"));
        System.out.println("stack.search(\"1\"): " + stack.search("1"));
        System.out.println("stack: " + stack);

        // Empty stack
        System.out.println("stack.pop(): " + stack.pop());// 4
        System.out.println("stack.pop(): " + stack.pop());// 3
        System.out.println("stack.peek(): " + stack.peek());// 2
        System.out.println("stack.pop(): " + stack.pop());// 2
        System.out.println("stack.pop(): " + stack.pop());// 1

        try {
            System.out.println("stack.pop(): " + stack.pop());
        } catch (java.util.EmptyStackException ex){
            System.out.println("Call pop on empty stack");
        }

        try {
            System.out.println("stack.peek(): " + stack.peek());
        } catch (java.util.EmptyStackException ex){
            System.out.println("Call peek on empty stack");
        }


    }

}
