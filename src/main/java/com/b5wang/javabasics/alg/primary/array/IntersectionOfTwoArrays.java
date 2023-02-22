package com.b5wang.javabasics.alg.primary.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2y0c2/
 *
 *
 * */
public class IntersectionOfTwoArrays {

    public int[] intersect(int[] nums1, int[] nums2){
        // sort
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> intersect = new ArrayList<>();

        // double pointers
        int p1 = 0,p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                
            }
        }
    }

}
