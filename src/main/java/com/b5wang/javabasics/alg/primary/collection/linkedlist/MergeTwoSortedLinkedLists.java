package com.b5wang.javabasics.alg.primary.collection.linkedlist;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnnbp2/
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * Double pointers, move 2 pointers on 2 list in 1 round
 * */
public class MergeTwoSortedLinkedLists {

    /**
     * p1 and p2 present the current nodes respectively
     * */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null && list2 == null){
            return null;
        }else if(list2 == null){
            return list1;
        }else if(list1 == null){
            return list2;
        }

        ListNode p1 = list1;
        ListNode p2 = list2;

        ListNode head = null;
        ListNode currentNode = null;// current node new list

        if(p1.val < p2.val){
            head = p1;

            currentNode = p1;
            p1 = p1.next;
        }else if(p1.val == p2.val){
            head = p1;

            currentNode = p1;
            p1 = p1.next;

            currentNode.next = p2;
            p2 = p2.next;

            currentNode = currentNode.next;
        }else{
            head = p2;

            currentNode = p2;
            p2 = p2.next;
        }

        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                currentNode.next = p1;
                p1 = p1.next;
                currentNode = currentNode.next;
            }else if(p1.val == p2.val){
                currentNode.next = p1;
                p1 = p1.next;
                currentNode = currentNode.next;

                currentNode.next = p2;
                p2 = p2.next;
                currentNode = currentNode.next;
            }else{
                currentNode.next = p2;
                p2 = p2.next;
                currentNode = currentNode.next;
            }
        }

        if(p1 != null || p2 != null){
            if(p1 != null){
                currentNode.next = p1;
            }else{
                currentNode.next = p2;
            }
        }else{
            currentNode.next = null;
        }

        return head;
    }


}
