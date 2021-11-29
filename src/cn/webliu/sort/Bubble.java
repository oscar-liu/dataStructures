package cn.webliu.sort;

/**
 冒泡排序的代码实现:
 1.public static void sort(Comparable[] a):对数组内的元素进行排序
 2.private static boolean greater(Comparable v,Comparable w):判断v是否大于w
 3.private static void exch(Comparable[] a,int i,int j):交换a数组中，索引i和索引j处的值
 */
public class Bubble {

    public static void sort(Comparable[] a){
        // 遍历数组长度，每次减少一个长度
        for( int i = a.length -1; i > 0; i--) {
            // 从第1个开始，第1和第2元素进行比较
            for(int j =0; j< i; j++) {
                // 如果左元素大于右元素则交换位置
                if(greater(a[j],a[j+1])) {
                    exch(a, j, j+1);
                }
            }
        }
    }

    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    private  static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
