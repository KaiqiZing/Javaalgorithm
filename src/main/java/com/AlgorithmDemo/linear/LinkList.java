package com.AlgorithmDemo.linear;

import java.util.Iterator;

public class LinkList <T> implements Iterable<T>{
    //记录头结点
    private Node head;
    //记录链表的长度
    private int N;

    //结点类
    private class Node {
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkList() {
        //初始化头结点、
        this.head = new Node(null,null);
        //初始化元素个数
        this.N=0;
    }

    //清空链表
    public void clear() {
        head.next=null;
        this.N=0;
    }

    //获取链表的长度
    public int length() {
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return N==0;
    }



    /*获取指定位置的元素*/
    public T get(int i){
        /*通过循环,从头结点开始往后找，依次找i次，就可以找到对应的元素*/
        Node node = head.next;
        for (int index=0; index<i; index++){
            node = node.next;
        }
        return node.item;
    }

    /*添加数据*/
    public void insert(T t){
        Node node = head;
        while (node.next!=null){
            node = node.next;
        }
        Node node1 = new Node(t, null);
        node.next=node1;
        N++;


    }

    /*指定i位置添加元素*/
    public void insert(int i, T t){
        /*1.找到i前一个位置点；2.找到i位置点，3.新结点替换为原来i的位置结点4.前i结点指向新结点位置*/
        Node pre = head;
        for (int index=0; index<=i-1; index++){

            pre = pre.next;
        }

        Node current = pre.next; // i位置结点 ，pre.node指针指向current结点
        Node newNode = new Node(t, current); // 指向current结点
        pre.next= newNode; // pre.next 指针指向newNode结点
        N++;

    }

    /*删除数据*/
    public T remove(int i){
        /*1.找到i位置前一个节点2.找到i位置结点3.找到i位置的下一个结点*/
        Node pre = head;
        for (int index=0; index<=i-1; index++){
            pre = pre.next;
        }
        Node current = pre.next;
        Node NextNode = current.next;
        /*前一个结点指针，指向下一个结点*/
        pre.next = NextNode;
        N--;
        return current.item;  // 已删除的结点
    }

    public int indexOf(T t){
        Node node = head;
        for (int i = 0; node.next!=null; i++) {
            node = node.next;
            if (node.item.equals(t))
                return i;
        }
        return -1;
    }






    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator{
        private Node n;
        public LIterator(){
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

    //用来反转整个链表
    public void reverse(){

        //判断当前链表是否为空链表，如果是空链表，则结束运行，如果不是，则调用重载的reverse方法完成反转
        if (isEmpty()){
            return;
        }

        reverse(head.next);
    }

    //反转指定的结点curr，并把反转后的结点返回
    public Node reverse(Node curr){
        if (curr.next==null){
            head.next=curr;
            return curr;
        }
        //递归的反转当前结点curr的下一个结点；返回值就是链表反转后，当前结点的上一个结点
        Node pre = reverse(curr.next);
        //让返回的结点的下一个结点变为当前结点curr；
        pre.next=curr;
        //把当前结点的下一个结点变为null
        curr.next=null;
        return curr;
    }
}
