package com.b5wang.javabasics.alg.primary.linkedlist;

/**
 * Delete a node in linked list.
 * */
public class DeleteNodeInLinkedList {

    /**
     * 在不知道pre-node的情况下如何删除节点？
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnarn7/
     * 用它的下一个节点把当前要删除的节点覆盖掉就可以了。
     * */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn2925/
     * 删除指定倒数指定的节点。一方面要遍历链表到结尾，另一方面还要记录倒数的节点位置。
     * 只能想到双指针，一个指针在前用来遍历，另一个在后与第一个指针相聚指定的位置，用来标志指定倒数节点的位置。
     *
     * --------
     * 稳妥一点可以先算链表的长度 len，被删除的节点的前一个节点的位置就是len-n。
     * 两次循环解决问题。
     * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 遍历list
        ListNode currentNode = head;
        int nodeCounter = 0;
        ListNode preDelNode = head;
        int interval = n + 1;
        while(currentNode != null){
            nodeCounter++;
            currentNode = currentNode.next;
            if(nodeCounter > interval){
                preDelNode = preDelNode.next;
            }
        }

        // 1. 节点数量少于n, 没有节点删除
        // 2. 节点数量==n，head被删除
        // 3. 节点数量>n, 删除节点，head不变.
        //    一个重要特例，当n=1的时候，就是最后一个节点
        if(nodeCounter < n){
            // do nothing
        }else if(nodeCounter == n){
            head = head.next;
        }else{
            // nodeNumber > n
            if(n == 1){
                preDelNode.next = null;
            }else{
                preDelNode.next = preDelNode.next.next;
            }
        }

        return head;
    }

    public static void main(String[] args){

    }

}
