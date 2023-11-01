package com.AlgorithmDemo.linear.stackDemo;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
    //记录首结点
    private Node head;
    //栈中元素的个数
    private int N;
    private class Node{
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Stack() {
        this.head = new Node(null,null);
        this.N=0;
    }

    //判断当前栈中元素个数是否为0
    public boolean isEmpty(){
        return N==0;
    }

    //获取栈中元素的个数
    public int size(){
        return N;
    }

    /*元素压栈*/
    public void push(T t){
        // 找到首节点指向第一个结点；
        Node oldFirst=head.next;
        // 创建新的结点；
        Node newNode = new Node(t, null);
        //首结点指向新结点
        head.next = newNode;
        // 新结点指向原来的第一个结点
        newNode.next=oldFirst;
        N++;
    }

    public T pop(){
        /*弹栈操作先进后出原则*/
        /*1.找到首结点指向的第一个结点，2.首结点指向当一个结点的下一个结点*/
        Node oldFirst = head.next;
        if (oldFirst == null){
            return null;
        }
        head.next = oldFirst.next;
        N--;
        return oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
        private Node n;

        public SIterator(){
            this.n=head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }

}
