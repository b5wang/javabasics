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
     *
     * */




    public void rotate2(int[] nums, int k) {

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
