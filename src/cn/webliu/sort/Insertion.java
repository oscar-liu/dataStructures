package cn.webliu.sort;

public class Insertion {

    // 排序
    public static void sort(Comparable[] a){
        for( int i = 1; i<a.length; i++) {
            //当前元素为a[i],依次和i前面的元素比较，找到一个小于等于a[i]的元素
            for( int j = i; j>0; j--) {
                if (greater(a[j-1],a[j])){
                    exch(a, j-1, j);
                } else {
                    break;
                }
            }
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
