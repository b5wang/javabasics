package com.b5wang.javabasics.alg.primary.linkedlist;

/**
 * @TODO
 * Help to test list operations
 * 1. Make a list by int array
 * 2. Print a list
 * */
public class ListHelper {

    /**
     * Quickly make a list by a array
     * */
    public static ListNode asList(int[] arr){
        ListNode head = new ListNode();
        ListNode node = head;
        int last = arr.length - 1;
        for(int i = 0; i < arr.length; i++){
            node.val = arr[i];
            if(i < last){
                node.next = new ListNode();
                node = node.next;
            }
        }
        return head;
    }

    /**
     * Print a LinkedList
     * */
    public static void printList(ListNode head){
        if(head == null){
            System.out.println("head is null!");
            return;
        }

        System.out.print("head");

        ListNode node = head;
        while(true){
            System.out.print("->" + node.val);
            node = node.next;
            if(node == null){
                break;
            }
        }
        System.out.println();
    }

    public static ListNode generateList(){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        return asList(arr);
    }

    public static ListNode generateList(int n){
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i + 1;
        }
        return asList(arr);
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ListNode head = asList(arr);
        printList(head);

        head = generateList(100);
        printList(head);
    }

}
