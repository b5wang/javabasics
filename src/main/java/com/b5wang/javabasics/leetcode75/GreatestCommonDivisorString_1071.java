package com.b5wang.javabasics.leetcode75;

class GreatestCommonDivisorString_1071 {

    /**
     * Greatest common divisor of integer
     * */
    private static int gcdRecursive(int a, int b){
        if(a < b){
            int t = a;
            a = b;
            b = t;
        }
        // a mt b

        int r = a % b;
        if(r == 0){
            return b;
        }else{
            return gcd(b,r);
        }
    }

    private static int gcd(int a, int b){
        if(a < b){
            int t = a;
            a = b;
            b = t;
        }
        // a mt b
        // Remainder
        int r = a % b;
        while(r != 0){
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }

    /**
     * https://leetcode.cn/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
     * Idea: GCD - Greatest Common Divisor and Euclid's algorithm
     * Euclid algorithm - 若r是a÷b的余数，则gcd(a,b) = gcd(b,r)
     * */
    private static String gbcStr(String str1, String str2){

        if(!(str1 + str2).equals(str2 + str1)){
            // No gcd string
            return "";
        }

        int a = str1.length();
        int b = str2.length();
        int gcd = gcd(a,b);
        if(gcd > 0) {
            return str1.substring(0, gcd);
        }else{
            return "-";
        }
    }

    private static void testGcd(){
        int a = 252;
        int b = 105;
        System.out.println("" + gcdRecursive(a,b));
        System.out.println("" + gcd(a,b));
    }

    private static void testCase1(){
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(gbcStr(str1,str2));
    }

    private static void testCase2(){
        String str1 = "ABABAB";
        String str2 = "ABAB";
        System.out.println(gbcStr(str1,str2));
    }

    private static void testCase3(){
        String str1 = "LEET";
        String str2 = "CODE";
        System.out.println(gbcStr(str1,str2));
    }

    public static void main(String[] args) {
        testGcd();
        testCase1();
        testCase2();
        testCase3();
    }
}
