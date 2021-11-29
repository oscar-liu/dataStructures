package cn.webliu.test;

import cn.webliu.linear.Linklist;
import cn.webliu.linear.SequenceList;

import java.util.HashSet;
import java.util.Set;

public class YsfTest {
    public static void main(String[] args) {
        Linklist<String> linkList = new Linklist<>();
        // 构造循环列表
        for(int i=0; i<=40; i++) {
            linkList.insert(i+"-"+randomIdentifier() );
        }
        linkList.end();
        System.out.println("链表长度：" + linkList.length());

        int count = 1;
        int index = 0;
        int length = linkList.length();
        while (linkList.length() > 2) {
            count ++;
            index ++;

            System.out.println("index=" + index +", length=" + length);
            if( length - 3 == index) {
                index = 0;
                System.out.println("第一次循环结束");
                System.out.println(linkList.length());
                System.out.println("第1个" + linkList.get(index));
                return;
            }
            if( count == 3) {
                System.out.println("kill index:" + index + ", " + linkList.get(index));
                System.out.println("kill :" + index +"->"+ linkList.remove(index));
                count = 0;
            }
        }

    }



    private static String randomIdentifier() {
        final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
        final java.util.Random rand = new java.util.Random();
        final Set<String> identifiers = new HashSet<String>();
        StringBuilder builder = new StringBuilder();
        while(builder.toString().length() == 0) {
            int length = rand.nextInt(5)+5;
            for(int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if(identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }
}
