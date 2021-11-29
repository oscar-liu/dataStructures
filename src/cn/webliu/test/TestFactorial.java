package cn.webliu.test;

public class TestFactorial {

    public static void main(String[] args) {
        // 求N的阶乘
        int result = factorial(8);
        System.out.println(result);
    }

    public static int factorial(int n) {
        if( n== 1){
            return 1;
        }
        return n*factorial(n-1);
    }

}
