package cn.webliu.linear;

import java.util.Iterator;

/**
 * 1.public void clear():空置线性表
 * 2.publicboolean isEmpty():判断线性表是否为空，是返回true，否返回false
 * 3.public int length():获取线性表中元素的个数
 * 4.public T get(int i):读取并返回线性表中的第i个元素的值
 * 5.public void insert(int i,T t):在线性表的第i个元素之前插入一个值为t的数据元素。
 * 6.public void insert(T t):向线性表中添加一个元素t
 * 7.public T remove(int i):删除并返回线性表中第i个数据元素。
 * 8.public int indexOf(T t):返回线性表中首次出现的指定的数据元素的位序号，若不存在，则返 回-1。
 */
public class SequenceList<T> implements Iterable<T> {

    // 存储元素的数组
    private T[] eles;

    // 记录当前顺序表中的元素个数
    private int N;

    // 构造方法
    public SequenceList(int capacity) {
        // 初始化数组
        this.eles = (T[])new Object[capacity];
        this.N = 0; // 元素个数初始化为0
    }

    // 清空线性表
    public void clear() {
        this.N = 0;
    }

    // 判断线性表是否为空
    public boolean isEmpty() {
        // 判断线性表长度是否为0，0是空表，非0不是空表
        return this.N == 0;
    }

    // 获取线性表中的元素个数
    public int length() {
        return this.N;
    }

    // 获取线性表中的第i个元素
    public T get(int i) {
        return eles[i];
    }


    // 在索引i处插入元素T
    public void insert(T t){
        if(eles.length == this.N) {
            this.resize(2*N); // 扩容2倍
        }
        eles[N++] = t;
    }

    // 在索引i处插入元素T
    public boolean insert(int i,T t){
        if(eles.length == this.N) {
            this.resize(eles.length*2); // 扩容2倍
        }
        if(i<1 || i> eles.length+1) {
            System.out.println("插入的元素下标越界"+this.N);
            return false;
        }
        // 倒序遍历，将后一位的元素变更为前一位元素
        for(int index = N; index>i; index--) {
            eles[index] = eles[index-1];
        }
        // 再把T元素放到I索引处
        eles[i] = t;
        // 数组长度+1
        this.N++;
        return true;
    }

    // 删除索引i处的元素，返回元素值
    public T remove(int i) {
        if(i<1 || i> eles.length+1) {
            System.out.println("插入的元素下标越界"+this.N);
            return null;
        }
        // 记录i索引处的值
        T elem = eles[i];

        // 后续元素依次向前移动
        for(int index = i; index < N-1; index++) {
            eles[index] = eles[index+1];
        }
        // 删除元素后，元素个数减1
        this.N--;
        // 当元素已经不足数组大小的1/4,则重置数组的大小
        if(this.N > 0 && this.N < eles.length / 4) {
            this.resize(eles.length/2);
        }
        return elem;
    }

    // 检测元素T是否出现在线性表中，存在返回元素所在位置的索引，不存在返回-1
    public int indexOf(T t){
        for(int index = 0; index<N; index++) {
            if(eles[index].equals(t)) {
                return index;
            }
        }
        return -1;
    }

    // 重新定义数组空间
    public void resize(int newSize) {
        // 旧数组缓存
        T[] temp = eles;
        // 重新定义数组长度
        eles = (T[])new Object[newSize];
        // 数据迁移
        for(int i=0; i< this.N; i++) {
            eles[i] = temp[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
        // 声明一个内部指针变量
        private int cur;

        // 初始构造方法
        public SIterator() {
            this.cur = 0;
        }

        @Override
        public boolean hasNext() {
            // 检测是否还有下一个指针元素，判断是否下标越界
            return cur < N;
        }

        @Override
        public Object next() {
            return eles[cur++];
        }
    }
}
