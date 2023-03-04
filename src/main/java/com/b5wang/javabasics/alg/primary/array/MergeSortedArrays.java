package com.b5wang.javabasics.alg.primary.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnumcr/
 *
 * */
class MergeSortedArrays {

    static void merge(int[] nums1, int m, int[] nums2, int n){

        if(n == 0){
            return;
        }
        if(m == 0){
            for(int i = 0; i < nums2.length; i++){
                nums1[i] = nums2[i];
            }
            return;
        }

        int[] copy = new int[nums1.length];
        int p1 = 0;
        int p2 = 0;
        while(p1 < m || p2 < n){
            if(p1 < m && p2 < n) {
                if (nums1[p1] <= nums2[p2]) {
                    copy[p1 + p2] = nums1[p1];
                    p1++;
                } else {
                    copy[p1 + p2] = nums2[p2];
                    p2++;
                }
            }else if(p1 == m){
                copy[p1 + p2] = nums2[p2];
                p2++;
            }else{
                copy[p1 + p2] = nums1[p1];
                p1++;
            }
        }

        for(int i = 0; i < nums1.length; i++){
            nums1[i] = copy[i];
        }
    }

    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        merge(nums1,m,nums2,n);

        System.out.println(Arrays.toString(nums1));
    }

}
