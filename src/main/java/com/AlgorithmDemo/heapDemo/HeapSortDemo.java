package com.AlgorithmDemo.heapDemo;

import java.util.Arrays;

public class HeapSortDemo {
    public static void main(String[] args) {
        int[] array = {7, 3, 5, 2, 1, 6, 4};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(int[] array) {
        int length = array.length;

        // 构建最大堆
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        // 执行堆排序
        for (int i = length - 1; i >= 0; i--) {
            // 将当前根节点（最大值）与数组末尾元素交换
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // 对剩余元素重新构建最大堆
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int length, int root) {
        int largest = root; // 最大值索引，初始化为根节点
        int left = 2 * root + 1; // 左子节点
        int right = 2 * root + 2; // 右子节点

        // 判断左子节点是否比根节点大
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }

        // 判断右子节点是否比根节点大
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }

        // 如果最大值索引不是根节点，则交换根节点和最大值节点的位置，并递归调整所交换节点的子堆
        if (largest != root) {
            int temp = array[root];
            array[root] = array[largest];
            array[largest] = temp;

            heapify(array, length, largest);
        }
    }
}