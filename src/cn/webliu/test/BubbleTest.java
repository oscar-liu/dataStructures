package cn.webliu.test;

import cn.webliu.sort.Bubble;

import java.util.Arrays;

public class BubbleTest {
    public static void main(String[] args) {
        Integer arr[] = {4,5,6,1,2,3};
        Bubble.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

