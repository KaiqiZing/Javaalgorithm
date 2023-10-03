package com.linear;
/*有环的情况下查到环的链表环的入口在哪
* */
public class CircleListInTest {
    public static void main(String[] args) throws Exception {
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
        //产生环
        seven.next = third;

        //查找环的入口结点
        Node<String> entrance = getEntrance(first);
        System.out.println("first链表中环的入口结点元素为："+entrance.item);
    }

    /**
     * 初始化快指针 fast 和慢指针 slow，都指向链表的头节点。
     * 使用循环，快指针每次前进两步，慢指针每次前进一步，直到它们相遇为止。如果链表中没有环，快指针会先到达链表尾部，此时可以判断该链表没有环。
     * 当快指针和慢指针相遇时，将快指针重新指回链表头节点，并将其步长改为每次前进一步。
     * 接着，快指针和慢指针同时以每次一步的速度继续前进，直到它们再次相遇。相遇点即为环的入口位置。
     * 这个方法的解释是基于以下观察结果：当快慢指针相遇时，快指针所走过的路径是慢指针的两倍。由于在相遇点后，快指针重新从头节点开始，它们再次相遇的位置必然是环的入口位置。
     *
     * 需要注意的是，以上方法适用于链表中存在环的情况。如果链表中不存在环，则快指针最终会到达链表尾部，可以根据这一特点进行判断。
     * @param first 链表首结点
     * @return 环的入口结点
     */
    public static Node getEntrance(Node<String> first) {
        if (first == null && first.next == null){
            return null;
        }
        Node<String> fast = first;
        Node<String> slow = first;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow){
                break;
            }
        }
        if (fast==null && fast.next==null){
            return null;
        }
        fast=first;
        while (fast!=slow){
            fast = fast.next;
            slow= slow.next;
        }
        return fast;
    }
    //结点类
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

