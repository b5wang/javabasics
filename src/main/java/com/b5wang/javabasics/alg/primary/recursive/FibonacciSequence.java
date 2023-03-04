package com.b5wang.javabasics.alg.primary.recursive;

/**
 * https://zh.wikipedia.org/zh-sg/%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E6%95%B0
 * */
class FibonacciSequence {

    static int fibonacciNumber(int i){
        if(i >= 2){
            return fibonacciNumber(i - 1) + fibonacciNumber( i - 2);
        }else{
            // Recursive exit
            return i;
        }
    }


    public static void main(String[] args){
        for(int i = 0; i < 10; i++){
            System.out.print(fibonacciNumber(i));
            System.out.print(" ");
        }
    }

}
