package cn.webliu.sort;

public class Selection {

    // 时间复杂度分析
    // (N-1)+(N-2)+(N-3)+...+2+1=((N-1)+1)*(N-1)/2=N^2/2-N/2;


    // 排序
    public static void sort(Comparable[] a){
        int len = a.length;
        int minIndex = 0;
        for( int i =0; i<len-1; i++) {
            for(int j = i; j<len; j++) {
                // 比较元素大小
                if(greater(a[minIndex], a[j])) {
                    minIndex = j;
                }
            }
            // 交换元素位置
            exch(a,i,minIndex);
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
