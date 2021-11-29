package cn.webliu.test;

public class DiGuiTest {
    public static void main(String[] args) {
        test(1);
    }

    public static void test(int a) {
        if( a> 10) {
            return; // 退出递归
        }
        System.out.println("a的值=" + a);
        a++;
        test(a); // 递归调用test自身
        System.out.println("递归后的参数执行：" + a);
    }
}
