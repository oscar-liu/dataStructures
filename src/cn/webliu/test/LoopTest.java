package cn.webliu.test;

// 校验链表是否有环
public class LoopTest {
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
        // 创建环
        gg.next = dd;

        // 查找中间值
//        boolean flag = isCircle(aa);
//        System.out.println("链表是否有环：" + flag);

        Node start = getCircleStart(aa);
        System.out.println("环的起点是：" + start.item);
    }

    /**
     * 使用快慢指针的思想，还是把链表比作一条跑道，链表中有环，
     * 那么这条跑道就是一条圆环跑道，在一条圆环跑道中，两个人有速度差，那么迟早两个人会相遇，只要相遇那么就说明有环。
     * @param first
     * @return
     */
    private static boolean isCircle(Node<String> first) {
        Node<String> fast = first;
        Node<String> slow = first;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }


    // 寻找环起点
    // 当快慢指针相遇时，我们可以判断到链表中有环，这时重新设定一个新指针指向链表的起点，且步长与慢指针一样 为1，
    // 则慢指针与“新”指针相遇的地方就是环的入口。
    private static Node getCircleStart(Node<String> first) {
        Node<String> fast = first;
        Node<String> slow = first;
        Node<String> temp = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow.equals(fast)) {
                temp = first;
                continue;
            }
            if(temp != null) {
                temp = temp.next;
                if(temp.equals(slow)) {
                    return temp;
                }
            }
        }
        return null;
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
