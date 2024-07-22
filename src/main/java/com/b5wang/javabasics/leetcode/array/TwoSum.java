package com.b5wang.javabasics.leetcode.array;

import java.util.*;

/**
 * https://leetcode.cn/problems/two-sum/
 * */
public class TwoSum {

    public static int[] twoSumBruteForceSolution(int[] nums, int target) {
        int[] indexes = new int[2];

        // Jump out of multiple-layer for loop
        OUT:
        for(int i=0; i<nums.length - 1; i++){
            for(int j=i+1;j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    indexes[0] = i;
                    indexes[1] = j;
                    break OUT;
                }
            }
        }

        return indexes;
    }

    public static int[] twoSumBruteForceSolutionOptimize(int[] nums, int target) {
        int[] indexes = new int[2];

        int y;
        // Jump out of multiple-layer for loop
        OUT:
        for(int i=0; i<nums.length - 1; i++){
            if(nums[i] >= target){
                continue;
            }
            y = target-nums[i];
            for(int j=i+1;j<nums.length; j++){
                if(nums[j] == y){
                    indexes[0] = i;
                    indexes[1] = j;
                    break OUT;
                }
            }
        }

        return indexes;
    }

    public static int[] twoSumOptimalSolution(int[] nums, int target) {
        /**
         * Trading time for space
         * */
        Map<Integer, List<Integer>> elements = new HashMap<>();
        for(int k=0; k<nums.length; k++){
            List<Integer> indexList = elements.get(nums[k]);
            if(indexList == null){
                indexList = new ArrayList<>();
                elements.put(nums[k],indexList);
            }
            indexList.add(k);
        }

        int[] indexes = new int[2];

        int y;
        for(int i=0; i<nums.length - 1; i++){
            y = target-nums[i];
            if(elements.containsKey(y)){
                List<Integer> indexList = elements.get(y);
                for(int j:indexList){
                    if(j > i){
                        // the other element must be after i
                        indexes[0] = i;
                        indexes[1] = j;
                        break;
                    }
                }
            }
        }

        return indexes;
    }

    public static void main(String[] args){
        int[] result = twoSumOptimalSolution(new int[]{-1,-2,-3,-4,-5},-8);
        System.out.println(Arrays.toString(result));
    }
}
