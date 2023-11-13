package com.b5wang.javabasics.alg.primary.linkedlist;

/**
 * 从无序链表中移除重复项
 * 比如: 1->3->1->5->5->7
 * 得到: 1->3->5->7
 *
 * @TODO
 * */
public class DeleteDuplicateElement {

    /**
     * (1) Double pointers
     * frontPointer, backPointer
     *
     * */
    public static ListNode removeDeplicatedElement(ListNode head){
        if(head.next == null){
            return head;
        }

        ListNode frontPointer = head;
        ListNode pre = null;
        ListNode backPointer = head.next;
        while(frontPointer != null){
            if(frontPointer.val == backPointer.val){

            }


            backPointer = backPointer.next;

        }

        return head;
    }


}
