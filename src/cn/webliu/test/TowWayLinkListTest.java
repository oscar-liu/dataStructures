package cn.webliu.test;

import cn.webliu.linear.TowWayLinkList;

public class TowWayLinkListTest {
    public static void main(String[] args) throws Exception {
        System.out.println("------------链表测试-----------");
        TowWayLinkList<String> linkList = new TowWayLinkList<>();
        linkList.insert("西瓜");
        linkList.insert("芒果");
        linkList.insert("荔枝");
        linkList.insert("榴莲");
        //在第1个位置插入，
        linkList.insert(1, "我是插队的元素");
        // 判断链表是否为空
        System.out.println("链表是否为空：" + linkList.isEmpty());
        System.out.println("当前链表长度：" + linkList.length());
        System.out.println("第3个元素：" + linkList.get(3));
        System.out.println("获取第1个元素：" + linkList.getFirst());
        System.out.println("获取最后1个元素：" + linkList.getLast());
        System.out.println("--------------------------");
        for (String s : linkList) {
            System.out.println("链表元素：" + s);
        }
        System.out.println("--------------------------");
        // 删除链表元素
        String elem = linkList.remove(3) ;
        System.out.println("删除第3个元素:" + elem);
        System.out.println("当前链表长度：" + linkList.length());
        //查找链表元素
        int index = linkList.indexOf("芒果");
        System.out.println("芒果所在链表中的位置是：" + index);
        for (String s : linkList) {
            System.out.println("链表元素：" + s);
        }


    }
}

