package com.linear;

import java.net.BindException;
import java.util.Iterator;
import java.util.ServiceLoader;

/*顺序表的实现过程
* */
public class SequenceList<T> implements Iterable<T> {
    private T[] eles;
    //记录当前顺序表中的元素个数
    private int N;

    //构造方法
    public SequenceList(int capacity){
        //初始化数组
        this.eles=(T[])new Object[capacity];
        //初始化长度
        this.N=0;
    }

    //将一个线性表置为空表
    public void clear(){
        this.N=0;
    }

    //判断当前线性表是否为空表
    public boolean isEmpty(){
        return N==0;
    }

    //获取线性表的长度
    public int length(){
        return N;
    }

    //获取指定位置的元素
    public T get(int i){
        return eles[i];
    }

    //向线型表中添加元素t
    public void insert(T t){
        if (N==eles.length){
            resize(2*eles.length);
        }

        eles[N++]=t;
    }
    /*在i处插入指定元素t*/
    public void insert(int i, T t){
        // 考虑插入可能超出初始值的场景，故而扩容的情况
        if (N==eles.length){
            resize(2*eles.length);
        }
        //指定位置添加元素
        for (int index=N; index>i;index--){
            eles[index] = eles[index-1];
        }
        eles[i] =t;
        N++; // 元素个数加1操作
    }

    /*删除制定i处的元素，并返回该元素*/
    public T remove(int i){
        T curent = eles[i];
        for(int index=i; index <N-1; index++){
            eles[index] = eles[index+1]; //删除元素总体索引向前移动
        }
        N--; // 元素个数减1操作；
        if (N<eles.length/4){
            resize(eles.length/2);
        }
        return curent;
    }

    // 查找T元素第一次出现的位置
    public int indexOf(T t){
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)){
                return i;
            }
        }
        return -1;

    }

    // 扩容
    public void resize(int newSize){
        T[] temp = eles;
        eles = (T[])new Object[newSize];
        for (int i = 0; i < N; i++) {
            eles[i] = temp[i];
        }
    }


    // 实现可迭代的功能
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
        private int cursor;

        public SIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor<N;
        }

        @Override
        public Object next() {
            return eles[cursor++];
        }
    }
}
