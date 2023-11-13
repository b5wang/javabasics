package com.b5wang.javabasics.alg.primary.linkedlist;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnnhm6/
 *
 * 实现链表逆序
 * head->1->2->3->4->5->6->7
 * 得到
 * head->7->6->5->4->3->2->1
 *
 * 思考多种方法；步奏 1）实现功能 2）效率
 *
 * @TODO
 * */
public class ReverseLinkedList {

    /**
     * (1)
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *
     * 1. 遍历链表过程同时做方向反转
     * 2. 需要临时变量来记录当前节点的next，以防丢失节点
     *
     * 性能分析，O(N)
     * */
    public static ListNode reverseList(ListNode head) {
        // if list is empty
        if(head == null){
            return head;
        }

        /**
         * reverse a list, n
         * eed keep the information, pre, current, post
         * 当拿到next之后，把current.next指向pre，相当于操作两个断开的链表
         * 思路：遍历链表的时候要多指针
         * */
        ListNode pre = null;
        ListNode current = head;
        ListNode next = head.next;
        current.next = pre;//

        while(next != null){
            // keep all information
            pre = current;
            current = next;
            next = current.next;
            /**
             * current.next is null, it means current is the last one of the linked list,
             * and it would be the head of new list
             * */
            // reverse the direction
            current.next = pre;
        }

        return current;
    }


    /**
     * Consider recursive algorithm
     * 递归算法：non-head
     *
     * */
    private ListNode recursivelyReverseNoHead(ListNode head) {
        ListNode newHead = null;
        if(head.next == null){
            newHead = head;
        }else{
            newHead = recursivelyReverseNoHead(head.next);
            head.next.next = head;
        }
        return newHead;
    }

    /**(2)
     * Consider recursive algorithm
     * 递归算法：head, 入口。处理方式和无head的有区别，要将真正的head.next=null
     *
     * 性能分析：O(N)
     * */
    public ListNode recursivelyReverse(ListNode head) {
        ListNode newHead = null;
        if(head.next == null){
            newHead = head;
        }else{
            newHead = recursivelyReverseNoHead(head.next);
            head.next.next = head;
            head.next = null;
        }
        return newHead;
    }


    /**(3)
     * 插入法：分成两个链表，
     * 新的链表不断从头部插入
     * 老的链表不断从头部移除
     *
     * 性能:O(N)
     * 比直接反转链表少用一个变量
     * */
    public static ListNode insertReverse(ListNode head){
        ListNode newHead = head;
        head = head.next;
        newHead.next = null;

        ListNode current = null;
        while(head != null){
            current = head;
            head = head.next;

            current.next = newHead;
            newHead = current;
        }
        return newHead;
    }


    /**
     * Testing
     * */
    public static void main(String[] args){
        ListNode head = ListHelper.generateList();
        ListHelper.printList(head);// init list

        head = reverseList(head);
        ListHelper.printList(head);// reversed list

        head = reverseList(head);
        ListHelper.printList(head);

        head = insertReverse(head);
        ListHelper.printList(head);
    }
}
