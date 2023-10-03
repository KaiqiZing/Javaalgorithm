package com.AlgorithmDemo;
/*解决约瑟夫问题:*/

public class JosephTest {
    public static void main(String[] args) {
        /*构建循环链表包含1-41个结点*/
        Node<Integer> first = null;
        Node<Integer> pre = null;
        for (int i = 1; i <=41 ; i++) {
            if (i==1){
                first = new Node<>(i,null);
                pre =first;
                continue;
            }

            Node<Integer> newNode = new Node<>(i, null);
            pre.next=newNode;
            pre=newNode;

            //如果是最后一个结点，那么需要让最后一个结点的下一个结点变为first,变为循环链表了
            if (i==41){
                pre.next=first;
            }
        }

        /*計數器模式報數操作：*/
        int count=0;
        Node<Integer> n = first;
        Node<Integer> before = null;
        while (n!=n.next){
            count++;
            if (count==3){ // 如果是3则删除当前节点，并让当前结点n向后移动
                before.next =n.next;
                System.out.println(n.item+",这是删除的结点");
                count=0;
                n=n.next; // 向后移
            }else {
                before=n;
                n=n.next;
            }
        }
        System.out.println("最后一个元素:"+n.item);

    }
    //构建结点类
    private static class Node<T> {
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
