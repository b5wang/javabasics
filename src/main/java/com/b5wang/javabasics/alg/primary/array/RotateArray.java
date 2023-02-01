package com.b5wang.javabasics.alg.primary.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2skh7/
 *
 * 旋转数组
 * */
public class RotateArray {

    /**
     * Brute force way.
     * For example: move 2 steps
     * 0- [1,2,3,4]
     * 1- [4,1,2,3]
     * 2- [3,4,1,2]
     * */
    public void rotate(int[] nums, int k) {
        int tmp;
        while(k-- > 0){
            tmp = nums[nums.length - 1];
            int j = nums.length - 1;
            while(j > 0){
                nums[j] = nums[j-1];
                j--;
            }
            nums[0] = tmp;
        }
    }

    /**
     * Don't consider space complexity.
     * Move elements of nums into a new array, nums2.
     * Copy new array to nums
     * */
    public void rotateFaster(int[] nums, int k) {
        int len = nums.length;
        int[] nums2 = new int[len];

        // move nums elements to nums2
        for(int i = 0; i < len; i++){
            nums2[(i + k) % len] = nums[i];
        }

        // copy back to nums
        for(int j = 0; j < len; j++){
            nums[j] = nums2[j];
        }
    }

    /**
     * 数组有多少个元素，就一共移动多少次
     * Complete all in one step.
     *
     * 这种方法的一个致命弱点，nums长度等于k或者是k的倍数，就会陷入循环
     * ***** 这种方法不可行 *****
     * */
    public void rotateFastest(int[] nums, int k) {

        if(nums.length == k || k == 0){
            return;
        }

        int len = nums.length;

        // total len steps
        int index1,index2;
        int tmp1,tmp2;

        index1 = 0;
        tmp2 = nums[0];
        for(int i = 0; i < len; i++){
            index2 = (index1 + k) % len;

            tmp1 = nums[index2];
            nums[index2] = tmp2;
            tmp2 = tmp1;
            index1 = index2;

            System.out.println("nums: " + Arrays.toString(nums) + ", index1=" + index1 + ", tmp2=" + tmp2);
        }
    }

    public static void main(String[] args){
        //int[] arr = {1,2,3,4,5,6,7};
        //int[] arr = {1,2,3};
        int[] arr = {-1,-100,3,99};
        int k = 2;

        System.out.println("Before: " + Arrays.toString(arr));
        RotateArray ex = new RotateArray();
        //ex.rotate(arr,k);
        //ex.rotateFaster(arr,k);
        ex.rotateFastest(arr,k);
        System.out.println("After : " + Arrays.toString(arr));
    }

}
