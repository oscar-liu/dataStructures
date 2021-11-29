package cn.webliu.linear;

import java.util.Iterator;

/**
 * 双向链表实现
 * 1.public void clear():空置线性表
 * 2.publicboolean isEmpty():判断线性表是否为空，是返回true，否返回false
 * 3.public int length():获取线性表中元素的个数
 * 4.public T get(int i):读取并返回线性表中的第i个元素的值
 * 5.public void insert(T t):往线性表中添加一个元素;
 * 6.public void insert(int i,T t):在线性表的第i个元素之前插入一个值为t的数据元素。 7.public T remove(int i):删除并返回线性表中第i个数据元素。
 * 8.public int indexOf(T t):返回线性表中首次出现的指定的数据元素的位序号，若不存在，则 返回-1。
 * 9.public T getFirst():获取第一个元素
 * 10.public T getLast():获取最后一个元素
 */
public class TowWayLinkList<T> implements Iterable<T> {

    // 成员类：结点类
    private class Node<T>{
        public T item;
        public Node pre;
        public Node next;

        /**
         * 结点类构造方法
         * @param item 存储数据
         * @param pre 上一个节点
         * @param next 下一个节点
         */
        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    // 成员变量

    // 记录首结点 成员变量
    private Node head;
    // 记录尾结点
    private Node last;
    // 链表的长度
    private int N;

    // 构造方法
    public TowWayLinkList() {
        last = null;
        // 初始化头结点, 没有数据元素，也没有前后指针指向
        head = new TowWayLinkList.Node(null, null, null);
        N = 0;
    }

    // 内部成员方法

    // 清空链表
    public void clear() {
        head.pre = null;
        head.next = null;
        last = null;
        N = 0;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return N==0;
    }

    // 获取链表的元素个数
    public int length() {
        return N;
    }

    // 获取第1个元素
    public T getLast() {
        if(isEmpty()) {
            return null;
        }
        return (T) last.item;
    }

    // 获取第1个元素
    public T getFirst() {
        if(isEmpty()) {
            return null;
        }
        return (T) head.next.item;
    }

    // 读取并返回链表中的第i个元素的值
    public T get(int i) {
        if(i<0 || i>=N) {
            throw new RuntimeException("位置不合法");
        }
        Node n = head.next;
        for(int index =0; index < i; index ++) {
            n = n.next;
        }
        return (T) n.item;
    }

    /**
     * 添加元素
     * @param t 元素内容
     */
    public void insert(T t) {
        // 判断是否空链表
        if(last == null) {
            last = new Node(t, head, null);
            head.next = last;
        } else {
            // 如果不是空链表，先找到最后一个节点
            Node oldLast = last;
            // 创建一个节点
            Node newNode = new Node(t, oldLast, null);
            // 最后一个节点的指向到新创建的结点
            oldLast.next = newNode;
            // 最后一个节点指向到新创建的节点
            last = newNode;
        }
        // 链表长度+1
        N++;
    }

    /**
     * 在指定位置插入结点
     * @param i
     * @param t
     */
    public void insert(int i,T t) {
        if(i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }
        // 找到指定位置i节点的前一个节点
        Node prev = head;
        for(int index =0; index <i; index++) {
            prev = prev.next;
        }
        // 元素i当前结点
        Node curr = prev.next;

        // 构建新的节点, 让新节点指向i节点
        Node newNode = new Node(t, prev, curr);
        curr.pre = newNode; // 当前元素的上一个节点指向新节点
        prev.next = newNode; // 元素i的下一个节点指向新节点
        // 链表元素+1
        N++;
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

    /**
     * 删除，返回删除的元素
     * @param i
     * @return
     */
    public T remove(int i) {
        if(i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }
        Node prev = head;
        for(int index =0; index <i; index ++) {
            prev = prev.next;
        }
        // i位置的元素
        Node curr = prev.next;
        // i位置的下一个元素
        Node currNext = curr.next;
        // 前一个元素直接指向i位置的下一个元素
        prev.next = currNext;
        // 链表减1
        N--;
        return (T) curr.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }
    private class TIterator implements Iterator{
        private Node n = head;
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
