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
     * 数组有多少个元素，就一共移动多少次
     * */
    public void rotateFastest(int[] nums, int k) {
        int len = nums.length;

        // 1 round
        int index1 = 0;
        int index2 = k % len;
        int tmp1 = nums[index2];
        int tmp2;
        nums[index2] = nums[index1];

        for(int i = 0; i < len; i++){
            index1 = index2;
            index2 = (index2 + k) % len;


            tmp2 = tmp1
            ;

        }
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;

        System.out.println("Before: " + Arrays.toString(arr));
        RotateArray ex = new RotateArray();
        ex.rotate(arr,k);
        System.out.println("After : " + Arrays.toString(arr));
    }

}
