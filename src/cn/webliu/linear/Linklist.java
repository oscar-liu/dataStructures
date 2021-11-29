package cn.webliu.linear;

import java.util.Iterator;

/**
 * 单向链表API设计
 * 1.public void clear():空置线性表
 * 2.publicboolean isEmpty():判断线性表是否为空，是返回true，否返回false
 * 3.public int length():获取线性表中元素的个数
 * 4.public T get(int i):读取并返回线性表中的第i个元素的值
 * 5.public void insert(T t):往线性表中添加一个元素;
 * 6.public void insert(int i,T t):在线性表的第i个元素之前插入一个值为t的数据元素。
 * 7.public T remove(int i):删除并返回线性表中第i个数据元素。
 * 8.public int indexOf(T t):返回线性表中首次出现的指定的数据元素的位序号，若不存在，则 返回-1。
 */

// 单链表
public class Linklist<T> implements Iterable<T> {

    // 结点类
    private class Node<T> {
        // 存储元素
        public T item;
        // 指向下一个节点
        public Node next;

        /**
         * 创建结点
         * @param item 数据元素
         * @param next 指针
         */
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    // 记录头结点
    private Node head;
    // 记录链表的长度
    private int N;

    // 初始化链表
    public Linklist(){
        // 初始化头结点, 没有数据元素，也没有下一个指针指向
        head = new Node(null, null);
        N = 0;
    }

    // 最后一个节点，指向头结点，形成循环链表
    public void end() {
        Node n = head;
        // 找到最后一个元素节点
        while (n.next != null) {
            n = n.next;
        }
        n.next = head;
    }

    // 空置线性表
    public void clear() {
        head.next = null; // 头节点的下一个指针为null，断掉所有指向
        head.item = null; // 节点元素清空
        this.N = 0; // 链表长度重置为0
    }

    // 判断线性表是否为空
    public boolean isEmpty() {
        // 判断链表长度是否为0即可
        return N==0;
    }

    // 获取线性表中元素的个数
    public int length() {
        return N;
    }

    // 获取指定i位置的元素
    public T get(int i) {
        if(i<0 || i>=N) {
            throw new RuntimeException("位置不合法");
        }
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return (T) n.item;
    }

    // 往链表中添加一个元素;
    public void insert(T t) {
        Node n = head;
        // 找到最后一个元素节点
        while (n.next != null) {
            n = n.next;
        }
        // 创建一个元素结点，放在尾部
        Node elem = new Node(t, null);
        n.next = elem;

        // 链表长度加1
        N++;
    }

    // 插入元素在指定索引处
    public void insert(int i,T t) {
        if(i<0 || i>=N) {
            throw new RuntimeException("位置不合法");
        }
        // 寻找i之前的节点
        Node prev = head.next;
        for(int index=0; index < i; index++) {
            prev = prev.next;
        }
        // 找到位置i的节点
        Node curr = prev.next;
        // 构建新的节点, 让新节点指向i节点
        Node newNode = new Node(t, curr);
        // 重新指向
        prev.next = newNode;
        // 链表长度+1
        N++;
    }

    // 删除链表元素并返回删除的元素
    public T remove(int i) {
        if(i<0 || i>=N) {
            throw new RuntimeException("位置不合法");
        }
        Node prev = head.next;
        for(int index=0; index <i; index++) {
            prev = prev.next; // 指针后移
        }
        Node curr = prev.next; // 当前i处所在的节点
        // 让前一个指针结点指向下一个指针节点， 1->2->3 => 1->3
        prev.next = curr.next;
        // 链表长度-1
        N--;
        return (T)curr.item;
    }

    // 检测元素是否存在，存在返回索引
    public int indexOf(T t) {
        Node n = head;
        for(int i=0; n.next != null; i++) {
            n = n.next; // 指针后移
            if(n.item.equals(t)) { // 每一次指针后移找出元素进行对比
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator iterator() { return new LIterator();
    }
    private class LIterator implements Iterator<T>{
        private Node n;

        public LIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public T next() {
            n = n.next;
            return (T)n.item;
        }
    }


    // 链表反转
    public void reverse() {
        if(isEmpty()) {
            return;
        }
        // 传入第一个头节点
        reverse(head.next);
    }

    // 反转指定的节点curr,并把反转后的节点返回
    public Node reverse(Node curr) {
        // 已经到了最后一个节点，退出递归
        if(curr.next == null) {
            // 首节点的最后一个节点
            head.next = curr;
            return curr;
        }
        // 递归调有和当前节点的下一个结点； 返回值就是链表反转后，当前结点的上一个结点。
        Node pre = reverse(curr.next);
        pre.next = curr;
        //当前结点的下一个结点设为null
        curr.next=null;
        //返回当前结点
        return curr;
    }

}
