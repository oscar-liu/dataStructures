package cn.webliu.sort;

public class Shell {
    // 排序
    public static void sort(Comparable[] a){
        //1. 根据数组a的长度，确定增长量h的初始值
        int h = 1;
        while( h<a.length/2) {
            h = 2*h+1;
        }
        //2. 希尔排序
        while (h>=1) {
            // 排序
            // 2.1 找到待插入的元素，默认为索引H
            for(int i =h; i<a.length; i++) {
                // 2.2 待插入的元素插入到有序数组中 a[i]
                for(int j=i; j>= h; j-=h) { //j-=h
                    // 待插入的元素是a[j], 比较a[j]和a[j-h]
                    if(greater(a[j-h],a[j])) {
                        exch(a,j-h,j);
                    }else{
                        break;
                    }
                }
            }
            // 减少h的值
            System.out.println(h + "/2=" + h/2);
            h = h/2;
        }
    }


    // 比较大小
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w) > 0;
    }

    // 交换元素
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
