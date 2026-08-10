package class027;

import java.util.List;
import java.util.PriorityQueue;

public class MergedKList {

    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // 小根堆
        PriorityQueue<ListNode> heap =  new PriorityQueue<>((a, b) -> a.val  -b.val );
        //添加头节点
        for(ListNode listNode : lists){
            if(listNode != null){
                heap.add(listNode);
            }
        }
        if(heap.isEmpty()){
            return null;
        }
        ListNode head = heap.poll();
        ListNode pre = head;
        if( pre.next != null){
            heap.add(pre.next);
        }

        while(!heap.isEmpty()){
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if(pre.next != null){
                heap.add(pre.next);
            }

        }

        return head;

    }
}


