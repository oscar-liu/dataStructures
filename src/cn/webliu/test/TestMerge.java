package cn.webliu.test;

import cn.webliu.sort.Merge;

import java.util.Arrays;

public class TestMerge {
    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        Merge.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
