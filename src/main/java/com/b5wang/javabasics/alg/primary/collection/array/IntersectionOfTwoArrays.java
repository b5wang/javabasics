package com.b5wang.javabasics.alg.primary.collection.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2y0c2/
 *
 * Keys (essentials):
 * 1. Sort arrays
 * 2. Double pointers
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
                // record this value
                intersect.add(nums1[p1]);
                // p1, p2 all would move 1 step forward
                p1++;
                p2++;
            }else if(nums1[p1] < nums2[p2]){
                // p1 is small.Who is smaller should move 1 step forward
                p1++;
            }else{
                // p2 is small.Who is smaller should move 1 step forward
                p2++;
            }

        }

        int[] arr = new int[intersect.size()];
        int i = 0;
        for(Integer el : intersect){
            arr[i++] = el;
        }
        return arr;
    }


    public static void main(String[] args){
//        int[] nums1 = {1,2,2,1};
//        int[] nums2 = {2,2};

        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));

        IntersectionOfTwoArrays opr = new IntersectionOfTwoArrays();
        System.out.println("intersect = " + Arrays.toString(opr.intersect(nums1,nums2)));

    }

}
