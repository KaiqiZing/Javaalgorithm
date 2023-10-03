package com.AlgorithmDemo.MergeDemo;

import javax.xml.bind.annotation.XmlInlineBinaryData;
import java.util.Arrays;
/*左指针向右移动时找到一个比基准值大的元素，右指针向左移时找一个比基准值小的元素
* 最终在左右指针相等的情况下，将该索引值和基准值进行交换位置，交换后新的基准值左边都是小于等于它的值
* 右边都是大于等于它的值
* */
public class MergeDemo1 {
    public static void main(String[] args) {
        int[] arr = {9, 5, 7, 1, 3};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    /*    // 打印排序后的数组
        for (int num : arr) {
            System.out.print(num + " ");
        }*/
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // 找出中间索引
            int mid = (left + right) / 2;

            // 对左边数组进行递归排序
            mergeSort(arr, left, mid);
            // 对右边数组进行递归排序
            mergeSort(arr, mid + 1, right);

            // 合并两个有序数组
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;   // 左数组的起始索引
        int j = mid + 1;  // 右数组的起始索引
        int k = 0;  // 临时数组的起始索引

        // 将左右两个有序数组按顺序合并到临时数组中
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 将左边数组中剩余的元素复制到临时数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // 将右边数组中剩余的元素复制到临时数组
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 将临时数组的元素复制回原数组
        for (int m = 0; m < temp.length; m++) {
            arr[left + m] = temp[m];
        }
    }

}
