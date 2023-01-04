package com.b5wang.javabasics.leetcode.entrylevel;

import com.sun.istack.internal.NotNull;

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
     * */


    /** Fastest.
     *  Similar to HashMap, searching very fast
     * */
    public boolean containsDuplicate(int[] nums) {

        if(nums.length == 1){
            return false;
        }


        IntNode[] bucket = new IntNode[nums.length];

        int len = nums.length;
        for(int i=0; i<len; i++){
            int index = nums[i] % len;
            IntNode node = bucket[index];
            if(node == null){
                node = new IntNode(nums[i]);
                bucket[index] = node;
            }else{

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

    }

}
