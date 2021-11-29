package cn.webliu.test;


public class FastSlowTest {


    public static void main(String[] args) {

        // 创建节点
        Node<String> aa = new Node<String>("aa", null);
        Node<String> bb = new Node<String>("bb", null);
        Node<String> cc = new Node<String>("cc", null);
        Node<String> dd = new Node<String>("dd", null);
        Node<String> ee = new Node<String>("ee", null);
        Node<String> ff = new Node<String>("ff", null);
        Node<String> gg = new Node<String>("gg", null);

        // 节点指向
        aa.next = bb;
        bb.next = cc;
        cc.next = dd;
        dd.next = ee;
        ee.next = ff;
        ff.next = gg;

        // 查找中间值
        String mid = getMid(aa);
        System.out.println("中间值是：" + mid);
    }

    private static String getMid(Node node) {
        Node fast = node;
        Node slow = node;
        while (fast !=null && fast.next !=null ) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return (String)slow.item;
    }

    private static class Node<T> {
        // 存储数据
        T item;
        // 下一个节点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

}
