package com.b5wang.javabasics.alg.primary.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2gy9m/
 * In-place algorithm
 * */
public class RemoveRepeatedInSortedArray {

    /**
     * 1. practice, remove a specific index element in array
     *    Move all elements forward 1 space.
     * */
    public int[] remove(int[] nums, int index){
        System.out.println("Before: " + Arrays.toString(nums));

        for(int i = index; i < nums.length; i++){
            if(i+1 < nums.length){
                nums[i] = nums[i+1];
            }else{
                nums[i] = nums[0] - 1;
            }
        }

        System.out.println("After: " + Arrays.toString(nums));
        return nums;
    }



    public int removeDuplicates(int[] nums) {
        System.out.println("Before: " + Arrays.toString(nums));
        int len = nums.length;

        if(len == 1){
            return 1;
        }

        int i = 1;
        while(i < len){
            if(nums[i-1] == nums[i]){
                if(i + 1 == len){
                    // nums[i] is the last element in array.
                    // nums[0] is the smallest element in array.
                    nums[i] = nums[0] - 1;
                }else{
                    // nums[i] is not the last one, move all elements 1 step forward
                    int j = i+1;
                    while(j < len){
                        nums[j-1] = nums[j];
                        j++;
                    }
                }
                len--;
            }
            i++;
        }

        System.out.println("After: " + Arrays.toString(nums));
        return len;
    }

    public static void main(String[] args){
        int[] arr = {1,1,2,3,3};


        RemoveRepeatedInSortedArray ex = new RemoveRepeatedInSortedArray();

        ex.remove(arr, 1);


        //int len = ex.removeDuplicates(arr);
        //System.out.println("len=" + len);
    }

}
