package com.b5wang.javabasics.leetcode.entrylevel;

/**
 * https://leetcode.cn/problems/contains-duplicate/?envType=study-plan&id=shu-ju-jie-gou-ru-men&plan=data-structures&plan_progress=yvcyv1t
 *
 * 217. 存在重复元素
 * Find out repeated integers in an array.
 *
 * */
public class Ex217_FindDuplicatedElements {

    /**
     * 简单粗暴法：分别比较各个数字
     * 1. 第一个数字和后面的数字比较
     * 2. 第二个数字和后面的数字比较
     * ...
     * n-1. 和最后一个数字比较
     * 时间复杂度是 O(n*n)
     * */




    /**
     * 要想再提高速度，目前我能想到的就是先排序，在比较相邻的两个数字打小
     * 需要用一个快的排序算法。
     * TODO Sorting algorithm
     * */





    /** Fastest.
     *  1. Similar to HashMap, searching very fast
     *  2. Consider negative integer
     * */
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return false;
        }

        if(len == 2){
            return (nums[0] == nums[1]);
        }

        IntNode[] bucket = new IntNode[nums.length];
        for(int i=0; i<len; i++){
            int index = nums[i] % len;
            if(index < 0){
                index = -1 * index;
            }
            IntNode node = bucket[index];
            if(node == null){
                // no node yet
                node = new IntNode(nums[i]);
                bucket[index] = node;
            }else{
                // exist some nodes
                // 1st node
                if(node.num == nums[i]){
                    return true;
                }

                // 2nd to last node
                while(node.next != null){
                    node = node.next;
                    if(node.num == nums[i]){
                        return true;
                    }
                }

                // add new num to node link end
                node.next = new IntNode(nums[i]);
            }
        }

        return false;
    }

    private static class IntNode{
        int num;
        IntNode next;

        IntNode(int num){
            this.num = num;
        }
    }


    public static void main(String[] args){

        int[] nums1 = {1,2,3,1};
        int[] nums2 = {1,2,3,4};
        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};

        Ex217_FindDuplicatedElements ex217 = new Ex217_FindDuplicatedElements();

        System.out.println(ex217.containsDuplicate(nums1));
        System.out.println(ex217.containsDuplicate(nums2));
        System.out.println(ex217.containsDuplicate(nums3));
    }

}
