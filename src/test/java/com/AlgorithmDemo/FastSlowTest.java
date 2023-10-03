package com.AlgorithmDemo;

public class FastSlowTest {
    public static void main(String[] args) {
        //创建结点
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg", null);

        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;

        //查找中间值
        String mid = getMid(first);
        System.out.println("中间值为："+mid);
    }
    public static String getMid(Node<String> first){
        Node<String> fast = first;
        Node<String> slow = first;
        // 快结点指向的结点结束，慢指针指向的结点就是中间结点；
        while (fast!=null&&fast.next!=null){
            fast= fast.next.next;
            slow = slow.next;
        }

        return slow.item;
    }

    private static class Node<T>{
        T item;
        Node next;
        public Node(T item, Node next){
            this.item=item;
            this.next=next;
        }
    }
}
