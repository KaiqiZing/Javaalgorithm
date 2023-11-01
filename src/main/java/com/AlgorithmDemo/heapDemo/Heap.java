package com.AlgorithmDemo.heapDemo;

public class Heap<T extends Comparable<T>> {
    //存储堆中的元素
    private T[] items;
    //记录堆中元素的个数
    private int N;

    public Heap(int capacity) {
        this.items= (T[]) new Comparable[capacity+1];
        this.N=0;
    }
    public boolean less(int i, int j){
        /*若调用对象小于被比较对象，则返回负数。*/
        return items[i].compareTo(items[j]) <0;
    }

    private void exch(int i, int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    public void insert(T t){
        items[++N]=t;
        swim(N); // 上浮插入数据
    }
    private void swim(int k){
        // 通过循环，不断的比较当前结点的值和其父结点的值，如果发现父结点的值比当前结点的值小，则交换位置
        while (k>1){ // 必须大于根节点 因为最低要有一个父结点存在
            // 比较当前结点和其父结点,，如果父结点小于当前结点则进行交换索引和值
            if (less(k/2, k)){
                exch(k/2,k);
            }
            k = k/2; // 交换索引
        }
    }

    // 删除堆中最大的元素，并返回这个最大的元素；
    public T delMax(){
        T max = items[1];
        exch(1, N); // 删除最大值前先将最后一个元素位置和最大值进行交换，防止树出现异常
        items[N] = null;
        N--;

        sink(1);
        return max;
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    /*1.以左结点为准，循环向下遍历条件当前结点的左结点是否小于等于N。既是否到达根节点；
    * 2.若存在右结点则对比左右结点的大小；并返回比对后结婚；
    * 3.不存在右结点则当前左结点为最大值；
    * 4.对比左结点和当前结点，若当前结点较小则继续循环否则终止循环
    */
    private void sink(int k){
        while (2*k <=N){
            int max;
            if (2*k+1 <=N){
                if (less(2*k, 2*k+1)){
                    max = 2*k+1;
                }else {
                    max = 2*k;
                }
            }else {
                max = 2*k;
            }

            if (!less(k,max)){
                break;
            }

            exch(k, max);
            k=max;
        }

    }


}
