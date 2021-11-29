package cn.webliu.test;

import cn.webliu.linear.Linklist;

public class LinkListTest2 {
    public static void main(String[] args) throws Exception {
        System.out.println("------------链表测试-----------");
        Linklist<String> linkList = new Linklist<>();
        linkList.insert("1");
        linkList.insert("2");
        linkList.insert("3");
        linkList.insert("4");
        System.out.println("--------------------------");
        for (String s : linkList) {
            System.out.println("链表元素：" + s);
        }

        System.out.println("-----链表反转---------------------");
        linkList.reverse();
        for (String s : linkList) {
            System.out.println("链表元素：" + s);
        }



    }
}

