package class012;

public class PartitionList {



      public class ListNode {
          int val;
          ListNode next;

          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


    // https://leetcode.cn/problems/partition-list/
    class Solution {
        public ListNode partition(ListNode head, int x) {
            // 分为 < x 和 >= x 区
            ListNode smallHead = null, smallTail = null, bigHead = null, bigTail = null, next = null;
            while(head != null){
                next = head.next;
                head.next = null;
                if(head.val < x){ // 小区
                    if (smallHead == null){
                        smallHead = head;
                        smallTail = head;
                    }
                    else{
                        smallTail.next = head;
                        smallTail = head;
                    }
                }
                else{
                    if(bigHead == null){
                        bigHead = head;
                        bigTail = head;
                    }
                    else{
                        bigTail.next = head;
                        bigTail = head;
                    }
                }
                head = next;
            }
            if(smallHead == null){
                return bigHead;
            }
            smallTail.next = bigHead;
            return smallHead;
        }
    }
}
