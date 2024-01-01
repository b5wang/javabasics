package com.b5wang.javabasics.alg.primary.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 从无序链表中移除重复项
 * 比如: 1->3->1->5->5->7
 * 得到: 1->3->5->7
 *
 * @TODO
 * */
public class DeleteDuplicateElement {

    /** (1)
     * 双指针遍历
     *
     * O(N^2)
     * */
    public static void doublePointers(ListNode head){
        ListNode front = head;
        ListNode backPre = null;
        ListNode back = null;

        while(front != null){
            backPre = front;
            back = front.next;
            while(back != null){
                if(front.val == back.val){
                    // Remove back node
                    backPre.next = back.next;
                    back = backPre.next;
                }else{
                    backPre = back;
                    back = back.next;
                }
            }
            front = front.next;
        }
    }

    /**
     *
     * */
    public static void fatestWay(ListNode head){
        Set<Integer> values = new HashSet<>();

        ListNode pre = null;
        ListNode curr = head;
        while(curr != null){
            if(values.contains(curr.val)){
                //
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {1,3,1,5,5,7};
        ListNode head = ListHelper.asList(arr);
        ListHelper.printList(head);// init list
        doublePointers(head);
        ListHelper.printList(head);// init list

        int[] arr2 = {1};
        ListNode head2 = ListHelper.asList(arr2);
        ListHelper.printList(head2);// init list
        doublePointers(head2);
        ListHelper.printList(head2);// init list

        int[] arr3 = {1,1,1,1};
        ListNode head3 = ListHelper.asList(arr3);
        ListHelper.printList(head3);// init list
        doublePointers(head3);
        ListHelper.printList(head3);// init list

        int[] arr4 = {1,1,1,1,2,2,2,2};
        ListNode head4 = ListHelper.asList(arr4);
        ListHelper.printList(head4);// init list
        doublePointers(head4);
        ListHelper.printList(head4);// init list
    }

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
