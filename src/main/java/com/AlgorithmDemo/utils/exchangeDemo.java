package com.AlgorithmDemo.utils;

public class exchangeDemo {
    public static  void exchange(Comparable[] a, int i, int j){


        // 数值交换
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;

    }
}
