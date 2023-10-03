package com.AlgorithmDemo.SelectionDemo;
import com.AlgorithmDemo.utils.exchangeDemo;
import com.AlgorithmDemo.utils.greater;

import java.util.Arrays;

public class SelectionDemo1 {
    public static void main(String[] args) {
        Integer[] a = {4, 5, 6, 3, 2, 1};
        selectSort(a);
        System.out.println(Arrays.toString(a));

    }

    /**
     * 选择排序： 选定最开始索引，然后对比后续值，如果开始索引值大于后续的则两者值进行调换；
     * 完成一轮遍历后；
     * 最开始的索引数＋1 重复之前的遍历，直到循环总数-2次即可排序完成；
     *
     * @param a
     */

    public static void selectSort(Comparable[] a){
        for (int i = 0; i < a.length -2; i++) {
            int minValue = i;
            for (int j = i+1; j<a.length; j++){
                if (greater.greaterDemo(a[minValue], a[j])){
                    minValue = j; // 交换完成之后的值
                }
                exchangeDemo.exchange(a,i, minValue);
            }

        }
    }
}
