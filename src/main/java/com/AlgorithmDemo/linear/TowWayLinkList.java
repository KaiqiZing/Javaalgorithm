package com.AlgorithmDemo.linear;

import sun.applet.AppletResourceLoader;

import java.util.Iterator;

public class TowWayLinkList<T> implements Iterable<T> {
    private Node head;
    private Node last;
    private int N;



    //结点类
    private class Node{
        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

        //存储数据
        public T item;
        //指向上一个结点
        public Node pre;
        //指向下一个结点
        public Node next;
    }

    public TowWayLinkList(){
        this.head = new Node(null, null, null);
        this.last = null;
        this.N=0;
    }

    public void clear(){
        this.head.next=null;
        this.head.pre=null;
        this.head.item=null;
        this.last=null;
        this.N=0;
    }

    public int length(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public T getFirst(){
        if (isEmpty()) {
            return null;
        }
        return head.next.item;
    }

    public T getLast(){
        if (isEmpty()) {
            return null;
        }
        return last.item;
    }

    public void insert(T t){
        if (isEmpty()){
            Node newNode =new Node(t, head, null);
            last=newNode;
            head.next=last;
        }else {
            Node oldLast= last;
            Node newNode =new Node(t, oldLast, null);
            oldLast.next=newNode;
            last=newNode;
        }
        N++;
    }


    public void insert(int i, T t){
        Node pre = head;
        for (int index=0; index<i; index++){
            pre = pre.next;
        }
        Node current = pre.next;
        Node newNode = new Node(t, pre, current);
        pre.next=newNode;
        current.pre=newNode;
        N++;
    }

    public T get(int i){
        Node node = head.next;
        for (int index=0; index<i;index++){
            node=node.next;
        }
        return node.item;
    }

    public int  indexOf(T t){
        Node n = head;
        for (int i = 0; n.next !=null ; i++) {
            n=n.next;
            if (n.next.equals(t)){
                return i;
            }
        }
        return -1;
    }


    /*移除元素操作*/
    public T remove(int i){
        Node pre = head;
        for(int index=0; index<i;index++){
            pre=pre.next;
        }
        Node current = pre.next;
        Node nextNode=current.next;
        //让i位置的前一个结点的下一个结点变为i位置的下一个结点
        pre.next=nextNode;
        //让i位置的下一个结点的上一个结点变为i位置的前一个结点
        nextNode.pre=pre;
        N--;
        return current.item;

    }


    @Override
    public Iterator<T> iterator() {
        return new AIterator();
    }

    private class AIterator implements Iterator{
        private Node n;
        public AIterator(){
            this.n=head;

        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }
    }







}