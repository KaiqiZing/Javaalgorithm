package com.AlgorithmDemo.heapDemo;

public class HeapSort {
    //判断heap堆中索引i处的元素是否小于索引j处的元素
    private static  boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j])<0;
    }

    //交换heap堆中i索引和j索引处的值
    private static  void exch(Comparable[] heap, int i, int j) {
        Comparable tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    // 根据原数组source， 构造出heap;
    private static void createHeap(Comparable[] source, Comparable[] heap){
        //把source中的元素拷贝到heap中，heap中的元素就形成一个无序的堆
        System.arraycopy(source, 0, heap, 1, source.length);
        //对堆中的元素做下沉调整(从长度的一半处开始，往索引1处扫描)
        for (int i = (heap.length/2); i >0 ; i--) {
            sink(heap, i, heap.length-1);

        }
    }


    //在heap堆中，对target处的元素做下沉，范围是0~range
    private static void sink(Comparable[] heap, int target, int range){
        while (2*target<=range){
            int maxt;
            if (2*target+1 <=range){
                if (less(heap, 2*target, 2*target+1)){
                    maxt = 2*target+1;
                }else {
                    maxt = 2* target;
                }
            }else {
                maxt = 2* target;
            }
            if (!less(heap, target, maxt)){
                break;
            }
            exch(heap, target, maxt);
            target= maxt;
        }

    }

    // 对数组中的数据从小到大排序
    public static void sort(Comparable[] source){
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source, heap);
        /*1.获取到heap中最大的索引和1处索引，将两处的位置执行交换
        * 2.交换完成后将最大索引处的值剔除；
        * 3.对索引1处做下沉操作；
        * */
        int N = heap.length -1;
        while (N!=1){
            exch(heap, 1, N);
            N--;
            sink(heap, 1, N);
        }
        System.arraycopy(heap, 1, source, 0, source.length);

    }
}
