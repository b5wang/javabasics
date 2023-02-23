package com.b5wang.javabasics.alg.primary.linkedlist;

class ListNode {
    int val;
    ListNode next;

    ListNode(){}

    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
