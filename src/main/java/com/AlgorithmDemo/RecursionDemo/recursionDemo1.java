package com.AlgorithmDemo.RecursionDemo;


/**
 * 递归算法：方法内部调用方法本身，不适用于大规模的调用，会导致不断开辟栈内存空间；
 *
 */
public class recursionDemo1 {
    public static void main(String[] args) {
        int i = testFunction(5);
        System.out.println(i);

    }

    public static int testFunction(int number){
        if (number ==1){
            return 1;
        }
        return number * testFunction(number -1);

    }
}
