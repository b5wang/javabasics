package com.b5wang.javabasics.alg.primary.recursive;

/**
 * 倒序输出一个正整数:
 * 例如给出正整数 n=12345，希望以各位数的逆序形式输出，即输出54321。
 * */
class ReverseOutputInt {

    static void printLastDigit(int i){
        System.out.print(i%10);
        // end recursive
        if(i > 10){
            printLastDigit(i/10);
        }
    }

    static void printLastDigitNoRecursive(int i){
        while(i > 0){
            System.out.print(i%10);
            i = i/10;
        }
    }

    public static void main(String[] args){
        int i = 123456;
        System.out.println(i);
        printLastDigit(i);
        System.out.println();
        printLastDigitNoRecursive(i);
    }

}
