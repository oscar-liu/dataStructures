package cn.webliu.sort;

public class Quick {

    // sort
    public static void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length -1;
        sort(a, lo, hi);
    }

    /**
     * sort 重载
     * @param a 数组元素
     * @param lo 左侧元素索引
     * @param hi 右侧元素索引
     */
    public static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) {
            return;
        }

        // 对a数组中，从lo到hi的元素进行切分
        int partition = partition(a, lo, hi);
        // 递归调用
        // 对左边分组中的元素进行排序
        sort(a, lo, partition-1);

        // 对右边分组中的元素进行排序
        sort(a, partition+1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        Comparable key = a[lo]; // 将最左边的元素当前基准值
        int left = lo; // 定义左指针
        int right = hi+1; // 定义右指针

        // 开始切分
        while (true) {
            // 从右往左开始扫描，找到一个比基准值小的数
            while(less(key, a[--right])) { // 循环停止，找到了一个比基准值小的数了
                if(right == lo) {
                    break; // 停止循环，右指针已经到了最左了
                }
            }

            // 从左往右开始扫描，找到一个比基准值大的数
            while(less(a[++left],key)) { // 找到一个比基准值大的数了
                if(left == hi) {
                    break; // 左指针移到最右了
                }
            }

            // 此时right等于右指针往左扫描过程中找到的小于基准值的值，
            // left 等于左指针向右扫描到的大于基准值的索引值

            if(left >= right) { // 扫描完成，结束循环。左指针大于等于右指针
                break;
            } else {
                // 交换left和right的值
                exch(a, left, right);
            }
        }

        // 交换最后right处索引值和基准值所在索引处所在的值
        exch(a, lo, right);
        return right;
    }


    // 比较大小，如果小则返回true
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // 交换位置
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
