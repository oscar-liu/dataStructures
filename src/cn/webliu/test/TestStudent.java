package cn.webliu.test;

import cn.webliu.sort.Student;
// 定义测试类Test，在测试类Test中定义测试方法Comparable getMax(Comparable c1,Comparable c2)完成测试
public class TestStudent {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.setUsername("张三");
        stu1.setAge(18);

        Student stu2 = new Student();
        stu2.setUsername("李四");
        stu2.setAge(10);

        Comparable cab1 = getMax(stu1, stu2);
        System.out.println(cab1);
    }

    public static Comparable getMax(Comparable c1,Comparable c2) {
        int result = c1.compareTo(c2);
        if( result >= 0) {
            return c1;
        } else {
            return c2;
        }
    }
}
