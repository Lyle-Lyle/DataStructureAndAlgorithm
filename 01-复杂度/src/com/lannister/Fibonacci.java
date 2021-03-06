package com.lannister;

public class Fibonacci {

    //计算得到前n项的和,n从0开始
    public static int fib1(int n){
        if(n <= 1){
            return n;
        }
        return fib1(n-2) + fib1(n-1);
    }

    public static int fib2(int n){
        if(n <= 1){
            return n;
        }
        int first = 0;
        int second = 1;
        int sum = 0;
        for(int i = 0; i < n-1;i++){
            sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }
    public static void main(String[] args) {
        //System.out.println(fib1(5));
        System.out.println(fib2(5));

    }
}
