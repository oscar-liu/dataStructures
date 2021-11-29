package cn.webliu.test;

import cn.webliu.sort.Insertion;
import java.util.Arrays;

public class InsertionTest {
    public static void main(String[] args) {
        Integer[] arr = {12, 34, 32, 3, 2, 5,21, 23, 77, 43};
        Insertion.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
