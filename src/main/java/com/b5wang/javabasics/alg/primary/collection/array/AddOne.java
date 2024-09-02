package com.b5wang.javabasics.alg.primary.collection.array;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2cv1c/
 *
 * Main points:
 * 1. Loop an array from end till start
 * 2. Directly add 1 on the last element, if value is greater than 10, need carry 1 to tens
 * */
public class AddOne {

    public int[] plusOne(int[] digits) {
        int len = digits.length;

        for(int i = (len - 1); i >= 0; i--){
            int val = digits[i] + 1;

            if(val < 10){
                // no carry
                digits[i] = val;
                break;
            }else{
                // val >= 10, need carry 1 to high position.
                // if i = 0, it means array need add one position
                digits[i] = val - 10;
                if(i == 0){
                    int[] newArr = new int[len + 1];
                    newArr[0] = 1;
                    for(int j = 1; j < newArr.length; j++){
                        newArr[j] = digits[j - 1];
                    }
                    digits = newArr;
                }
            }
        }

        return digits;
    }

}
