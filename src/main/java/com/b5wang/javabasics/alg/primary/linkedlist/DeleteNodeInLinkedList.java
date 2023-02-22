package com.b5wang.javabasics.alg.primary.linkedlist;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnarn7/
 * Delete a node in linked list.
 * */
public class DeleteNodeInLinkedList {

    /**
     * 在不知道pre-node的情况下如何删除节点？
     * 用它的下一个节点把当前要删除的节点覆盖掉就可以了。
     * */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args){

    }

}
