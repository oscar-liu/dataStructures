package cn.webliu.test;

import cn.webliu.sort.Quick;

import java.util.Arrays;

public class QuickTest {
    public static void main(String[] args) throws Exception {
        Integer[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 8};
        Quick.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
