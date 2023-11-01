package com.AlgorithmDemo;

import com.AlgorithmDemo.ComparableDemo.Student;
import com.AlgorithmDemo.MergeDemo.MergeDemo1;

import java.util.Arrays;

public class TestStudent {


    public static void main(String[] args) {

/*        // 累加计算
        for (int i = -5; i < 5; i++) {
           // System.out.println("累加计算："+ i);

        }
        int i = 0;
        if (i<5){
            System.out.println(i);
            i++;
        }else {
            return;
        }*/
        int k =5;
      while (k>1){
          System.out.println(k);
          k = k/2;
      }
/*

        for (int i = 5; i >0 ; i--) {
            System.out.println("累计减计算："+ i);

        }

        int i = 1;
        while (i <5){
            i = i+1;
            System.out.println("while 累加计算"+ i);
        }

        int j = 5;
        while (j > 0){
            j = j-1;
            System.out.println("while累减计算："+ j);
        }
*/


    }


    public static Comparable getMax(Comparable c1, Comparable c2){

        /*
        *
        * compareTo 方法返回一个整数值，表示两个对象之间的比较结果。具体的返回值规则如下：
        * 如果当前对象小于 obj，则返回负整数。
        * 如果当前对象等于 obj，则返回零。
        * 如果当前对象大于 obj，则返回正整数。
        * */
        int cmp = c1.compareTo(c2);
        if (cmp >=0){
            return c1;
        }else {
            return c2;
        }
    }




}
