package com.AlgorithmDemo.ShellDemo;
import com.AlgorithmDemo.utils.exchangeDemo;
import com.AlgorithmDemo.utils.greater;

import java.util.Arrays;

public class ShellDemo1 {
    public static void main(String[] args) {
        Integer[] a = {4, 5, 3,6, 2, 1};
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 希尔排序：
     * 1.先确认数据最大的增量如 h；
     * 2.在对最大的增量做减法h/2;
     * 3.在以上基础做循环，先找到待插入的元素a[j],再找到被插入的位置a[j-h] ,[j-h]相当于步进的幅度
     * @param a
     */
    public static void shellSort(Comparable[] a){

        // 先确认增量h
        int h = 1;
        while (h <a.length / 2){
            h = 2 * h + 1;
        }
        while (h >=1){
            // 先找到待插入元素
            for (int i = h; i < a.length; i++) {
                // 基于h的增量做进一步的插入操作
                for (int j = i; j>=h; j -=h){
                    if (greater.greaterDemo(a[j-h], a[j])) {
                        exchangeDemo.exchange(a, j-h , j);
                    }else {
                        break;
                    }

                }

            }
            // 对增量做减法
            h = h/2;
        }

    }
}
