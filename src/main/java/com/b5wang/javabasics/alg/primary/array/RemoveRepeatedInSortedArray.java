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
        //System.out.println("remove - Before: " + Arrays.toString(nums));

        for(int i = index; i < nums.length; i++){
            if(i+1 < nums.length){
                nums[i] = nums[i+1];
            }else{
                nums[i] = nums[0] - 1;
            }
        }

        //System.out.println("remove - After: " + Arrays.toString(nums));
        return nums;
    }



    /**
     * 简单暴力直接解法。先解决有没有，再解决行不行
     * 把算法拆解，
     * 1，找相同的相邻元素
     * 2，如果arr[i-1] = arr[i] 位置的元素，将i后面的元素依次向前移动一个位置，覆盖元素arr[i]
     * 3. 后面多出来数字标记为arr[0]-1, 数组中最小的数字
     * */
    public int removeDuplicates(int[] nums) {
        //System.out.println("Before: " + Arrays.toString(nums));
        int len = nums.length;

        // Start from 2nd element
        int i = 1;
        while(i < len){
            if(nums[i-1] == nums[i]){
                if(i == len - 1){
                    // nums[i] is the last element in array, don't need move the other elements
                    // Mark nums[0] is the smallest element in array.
                    nums[i] = nums[0] - 1;
                }else{
                    // nums[i] is not the last one, so need move all elements step one forward.
                    remove(nums,i);
                }
                len--;
            }else {
                // 只有没有元素移动的情况下i才能增长。因为在arr[i-1]=arr[i]的情况下，新的arr[i]仍然有可能会发生arr[i-1]=arr[i]的情况
                i++;
            }
        }

        //System.out.println("After: " + Arrays.toString(nums));
        return len;
    }


    /**
     * 双指针，终极解法？
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
     * */
    public int removeDuplicates1(int[] nums) {
        return 0;
    }

    public static void main(String[] args){
        //int[] arr = {1,1};
        //int[] arr = {1,1,2,2};

        // Special case, 3 same elements join together.
        int[] arr = {0,0,1,1,1,2,2,3,3,4};


        RemoveRepeatedInSortedArray ex = new RemoveRepeatedInSortedArray();

        //ex.remove(arr, 1);

        int len = ex.removeDuplicates(arr);
        System.out.println("len=" + len);
    }

}
