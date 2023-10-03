package com.AlgorithmDemo.InsertionDemo;

import com.AlgorithmDemo.utils.exchangeDemo;
import com.AlgorithmDemo.utils.greater;

import java.util.Arrays;

// 插入排序其实就是倒叙排序进行参数的快排
public class InsertionDemo1 {

    public static void main(String[] args) {
        Integer[] a = {4, 5, 6, 3, 2, 1};
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }


    /**
     * 插入排序就是倒着插入数据，从右边向左进行排序的操作，最后一次排序最大长度数排序；
     * 特点是从数组右边开始向最左边插入；
     * 遍历次数
     * @param a
     */
    public static void insertionSort(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j =i ; j>0; j--){
                if (greater.greaterDemo(a[j-1], a[j])) {  // 倒序比较排序
                    exchangeDemo.exchange(a, j-1, j);
                }else {
                    break;
                }
            }

        }

    }
}
