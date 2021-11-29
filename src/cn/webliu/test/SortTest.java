package cn.webliu.test;

import cn.webliu.sort.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SortTest {
    public static void main(String[] args) throws IOException {
        // 创建arrayList集合，保存读取出来的数据
        ArrayList<Integer> list = new ArrayList<>();

        // 创建缓存读取流
        BufferedReader reader = new BufferedReader(new InputStreamReader(SortTest.class.getClassLoader().getResourceAsStream("test.txt")));
        String line=null;
        while((line=reader.readLine())!=null) {
            int i = Integer.parseInt(line);
            list.add(i);
        }
        reader.close();
        // arraylist转成数组
        Integer[] a = new Integer[list.size()];
        list.toArray(a);

        int[] b = new int[list.size()];

//        list.toArray(b);

//        testShellSort(a);
        // 希尔排序的时间为：33毫秒

//        testInsertionSort(a);
        //插入排序的时间为：39878毫秒

//        testBubbleSort(a);
        // 冒泡排序的时间为：45524毫秒

//        testSelectionSort(a);
        // 选择排序的时间为：16032毫秒

//        testMergeSort(b);
        // 归并排序的时间为：14毫秒

//        testQuickSort(a);

    }

    // 测试快速排序
    public static void testQuickSort(Integer[] a) {
        long start = System.currentTimeMillis();
        Quick.sort(a);
        long end = System.currentTimeMillis();
        System.out.printf("快速排序的时间为：" + (end-start) + "毫秒");
    }

    // 测试归并排序
    public static void testMergeSort(int[] a) {
        long start = System.currentTimeMillis();
        Merge.sort(a);
        long end = System.currentTimeMillis();
        System.out.printf("归并排序的时间为：" + (end-start) + "毫秒");
    }

    // 测试希尔排序
    public static void testShellSort(Integer[] a) {
        long start = System.currentTimeMillis();
        Shell.sort(a);
        long end = System.currentTimeMillis();
        System.out.printf("希尔排序的时间为：" + (end-start) + "毫秒");
    }

    // 测试插入排序
    public static void testInsertionSort(Integer[] a) {
        long start = System.currentTimeMillis();
        Insertion.sort(a);
        long end = System.currentTimeMillis();
        System.out.printf("插入排序的时间为：" + (end-start) + "毫秒");
    }

    // 测试选择排序
    public static void testSelectionSort(Integer[] a) {
        long start = System.currentTimeMillis();
        Selection.sort(a);
        long end = System.currentTimeMillis();
        System.out.printf("选择排序的时间为：" + (end-start) + "毫秒");
    }

    // 测试冒泡排序
    public static void testBubbleSort(Integer[] a) {
        long start = System.currentTimeMillis();
        Bubble.sort(a);
        long end = System.currentTimeMillis();
        System.out.printf("冒泡排序的时间为：" + (end-start) + "毫秒");
    }
}
