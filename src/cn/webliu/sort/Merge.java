package cn.webliu.sort;

import java.util.Arrays;

public class Merge {



    // 排序
    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length-1, temp);
    }

    // 重载sort方法，递归调用
    private static void sort(int[] arr, int left, int right, int[] temp) {
        if(left < right) {
            int mid = (left+right)/2;
            sort(arr, left, mid, temp); //左边归并排序，例左序列有序
            sort(arr, mid+1, right, temp); // 右边归并排序，例右序有序
            merge(arr, left, mid, right, temp); // 合并有序子数组
        }
    }


    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 1. 定义三个指针
        int i= left;// 左序列指针
        int j = mid+1; // 右序列指针
        int t = 0; // 临时数组指针

        // 2. 移动指针，遍历
        while (i<=mid && j<=right) {
            if(arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        //3. 以下的两个while只会触发一个

        // 将左边的剩余元素填充到temp中
        while(i<=mid) {
            temp[t++] = arr[i++];
        }

        // 将右边的剩余元素填充到temp中
        while(j<right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        // 将temp元素都由到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }


}
