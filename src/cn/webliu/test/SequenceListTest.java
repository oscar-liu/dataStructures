package cn.webliu.test;

import cn.webliu.linear.SequenceList;

public class SequenceListTest {
    public static void main(String[] args) {
        // 测试初始化线性表
        SequenceList<String> sl = new SequenceList<>(3);
        sl.insert("荔枝"); // 0
        sl.insert("芒果"); // 1 -> 2
        sl.insert("西瓜"); // 2 -> 3
        sl.insert(1, "榴莲"); // 1
        sl.insert(5, "不在表尾，如长10，索引值为20");

        sl.insert(100, "插入失败，下标越界");


        // 遍历元素
        for (String s : sl) {
            System.out.println("表元素："+s);
        }

        System.out.println("---------------------------");

        System.out.println("线性表长度为：" + sl.length());

        String val = sl.remove(1);
        System.out.println("删除元素索引"+1+"元素内容为："+val+",删除后元素长度为：" + sl.length());

        System.out.println("检测芒果是否存在，"+ sl.indexOf("芒果"));

        // 获取索引元素
        System.out.println("获取索引2元素:"+sl.get(2));
        //清空元素
        sl.clear();
        System.out.println("元素个数：" + sl.length());
    }
}
