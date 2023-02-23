package com.b5wang.javabasics.alg.primary.linkedlist;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnnhm6/
 *
 * */
public class ReverseList {

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * 1. 遍历链表过程同时做方向反转
     * 2. 需要临时变量来记录当前节点的next，以防丢失节点
     * */
    public ListNode reverseList(ListNode head) {
        // if list is empty
        if(head == null){
            return head;
        }

        /**
         * reverse a list, need keep the information, pre, current, post
         * */
        ListNode pre = null;
        ListNode currentNode = head;
        ListNode next = head.next;
        currentNode.next = pre;

        while(next != null){
            // keep all information
            pre = currentNode;
            currentNode = next;
            next = next.next;

            // reverse the direction
            currentNode.next = pre;
        }

        return currentNode;
    }


    /**
     * Consider recursive algorithm
     * */
    public ListNode reverseListRecursively(ListNode head) {
        return null;
    }


    public static void main(String[] args){

    }
}
