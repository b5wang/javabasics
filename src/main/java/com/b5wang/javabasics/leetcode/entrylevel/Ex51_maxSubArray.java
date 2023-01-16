package com.b5wang.javabasics.leetcode.entrylevel;

public class Ex51_maxSubArray {

    /**
     * Brute force algorithm(solution), exhaustion
     * For example
     * Original array: [5,4,-1,7,8]
     * From i=0      : [5,9,8,15,23], i=0,j=5
     * From i=1      : [0,4,3,10,18], i=0,j=5
     * From i=2      : [0,0,-1,6,14], i=0,j=5
     * From i=3      : [0,0,0,7,15],  i=0,j=5
     * From i=4      : [0,0,0,0,8],   i=0,j=5
     * Finally i=0,j=5 sub-array index from 0 to 5, it is [5,4,-1,7,8]
     * */
    public int maxSubArrayWithBruteForceAlg(int[] nums) {

        int maxSubArray = nums[0];
        int maxSubArrayI = 0;
        int maxSubArrayJ = 0;

        for(int i = 0; i < nums.length; i++){

        }

        return 0;
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

    }


}
