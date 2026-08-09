package class009;

public class ReverLinkedList {


    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //反转单链表
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode next = null;
            while (head != null){
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }

    // 双链表节点
    public static class DoubleListNode {
        public int value;
        public DoubleListNode last;
        public DoubleListNode next;

        public DoubleListNode(int v) {
            value = v;
        }
    }


    public static DoubleListNode reverseDoubleList(DoubleListNode head) {
        DoubleListNode pre = null;
        DoubleListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

}
