package com.b5wang.javabasics.leetcode.entrylevel;

/**
 * https://leetcode.cn/problems/maximum-subarray/?envType=study-plan&id=shu-ju-jie-gou-ru-men&plan=data-structures&plan_progress=c0c3k7m
 * */
public class Ex51_maxSubArray {

    /**
     * Brute force algorithm(solution), exhaustion
     * Calculate all sub arrays result.
     * Time complexity can't be up to standard.
     * */
    public int maxSubArrayWithBruteForceAlg(int[] nums) {
        int max = nums[0];
        int mI = 0;
        int mJ = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(i == j){
                    sum = nums[i];
                }else{
                    sum = sum + nums[j];
                }
                if(sum > max){
                    max = sum;
                    mI = i;
                    mJ = j;
                }
            }
        }
        //System.out.println("max sum array: i=" + mI + ", j=" + mJ);
        return max;
    }


    /**
     * Dynamic programming algorithm
     * */


    /**
     * Divide and conquer algorithm
     * */


    public int maxSubArray(int[] nums) {

        return 0;
    }



    public static void main(String[] args){
        //int[] arr = {1, 3, -2, 4, -5};
        int[] arr = {-2,1};

        Ex51_maxSubArray ex = new Ex51_maxSubArray();
        int max = ex.maxSubArrayWithBruteForceAlg(arr);
        System.out.println("max sub array value = " + max);
    }


}
