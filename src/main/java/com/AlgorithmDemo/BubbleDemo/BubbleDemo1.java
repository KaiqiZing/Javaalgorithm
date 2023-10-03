package com.AlgorithmDemo.BubbleDemo;

import com.AlgorithmDemo.utils.exchangeDemo;
import com.AlgorithmDemo.utils.greater;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleDemo1 {
    public static void main(String[] args) {
        Integer[] a = {4, 5, 6, 3, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    // 冒泡排序的逻辑，比邻交换
    public static void sort(Comparable[] a){
        for (int i = a.length-1; i >0 ; i--) { // 循环5次
            for (int j = 0; j<i; j++){ // 基于i的大小，执行循环i次
                if (greater.greaterDemo(a[j], a[j+1])) { // 比邻交换
                    exchangeDemo.exchange(a, j, j+1);

                }
            }

        }
    }



}
