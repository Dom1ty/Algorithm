package class011;

public class AddTwo {


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

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode cur =  dummy;
            int carry = 0 ;
            while(l1 != null || l2 != null || carry != 0){
                int sum = 0;
                if(l1 != null){
                    sum += l1.val;
                    l1 = l1.next;
                }
                if(l2 != null){
                    sum += l2.val;
                    l2 = l2.next;
                }
                sum += carry;
                carry =  sum / 10;
                int digit = sum % 10;
                //建立新节点
                ListNode Node  = new ListNode(digit);
                cur.next = Node;
                cur = cur.next;

            }
            return dummy.next;
        }
    }


}
