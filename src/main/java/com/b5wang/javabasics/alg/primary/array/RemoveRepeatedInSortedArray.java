package com.b5wang.javabasics.alg.primary.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2gy9m/
 *
 * 删除排序数组中的重复项
 *
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
        System.out.println("Before: " + Arrays.toString(nums));
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

        System.out.println("After: " + Arrays.toString(nums));
        return len;
    }


    /**
     * 双指针，终极解法？
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
     *
     * 需要注意，题目要求返回删除后数组的新长度就可以，并不需要返回新数组
     * */
    public int removeDuplicates2(int[] nums) {
        if(nums.length <= 1){
            return 1;
        }
        if(nums.length == 2){

        }

        System.out.println("Before: " + Arrays.toString(nums));

        // 初始位置
        int fP = 0;
        int bP = 1;

        while(bP < nums.length){
            if(nums[fP] == nums[bP]){
                // 两个位置的数字相等，只需要把后指针继续后移，继续寻找不同的数字
                //bP++;
            }else{
                if((fP + 1) == bP){
                    // fp和bp紧挨着的，又不相等, fp,bp同时整体后移
                    fP++;
                    //bP++;
                }else{
                    // bP移动到了第一个不等于fP的元素（从fP到bP-1,位置上的元素都是相等的），把不相等的元素移到fP+1位置，相当于删除了多余的相等元素。
                    // 这个时候fP前移到下一位。
                    nums[fP + 1] = nums[bP];
                    fP++;
                    //bP++;
                }
            }
            //无论以上那种情况，后指针bP每次都要前进一步
            bP++;
        }

        System.out.println("After: " + Arrays.toString(nums));

        return fP + 1;
    }

    public static void main(String[] args){
        //int[] arr = {1,1};
        int[] arr = {1,2};

        // Special case, 3 same elements join together.
        //int[] arr = {0,0,1,1,1,2,2,3,3,4};


        RemoveRepeatedInSortedArray ex = new RemoveRepeatedInSortedArray();

        //ex.remove(arr, 1);

        //int len = ex.removeDuplicates(arr);
        //System.out.println("len=" + len);

        int len = ex.removeDuplicates2(arr);
        System.out.println("len=" + len);
    }

}
