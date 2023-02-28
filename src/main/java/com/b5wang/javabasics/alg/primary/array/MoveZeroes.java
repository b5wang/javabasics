package com.b5wang.javabasics.alg.primary.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2ba4i/
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * */
class MoveZeroes {

    /**
     * 暴力解法，brute force???
     * No no no! Perfect!
     * */
    static void moveZeroesBruteForce(int[] nums) {
        int l = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == 0){
                l++;
            }else{
                if(l > 0){
                    nums[i-l] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {0,1,0,3,12};

        moveZeroesBruteForce(nums);

        System.out.println(Arrays.toString(nums));
    }

}
