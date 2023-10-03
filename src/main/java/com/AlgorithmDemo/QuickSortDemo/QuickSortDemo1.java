package com.AlgorithmDemo.QuickSortDemo;

import java.util.Arrays;

public class QuickSortDemo1 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 2, 1, 6, 3, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString((arr)));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            // 让左子组进行排序
            quickSort(arr, left, pivotIndex - 1);
            // 右子组进行排序
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        // 确定分界值
        int pivot = arr[left];
        // 定义两个指针，指向最小索引处的下一个位置和最大索引
        int i = left+1;
        int j = right;

        // 切分
        while (true) {

            // 从左向右移动找到一个比分界值大的元素停止
            while (i <= j && arr[i] < pivot) {
                i++;
            }

            // 从右向左移动找到一个比分界值小的元素停止
            while (i <= j && arr[j] > pivot) {
                j--;
            }

            // 如果左元素大于右元素则证明元素扫描完毕，结束循环，如果不是则交换元素即可
            if (i > j) {
                break;
            }

            swap(arr, i, j);
        }

//        交换分界值
        swap(arr, left, j);
        return j;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}