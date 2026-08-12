package class027;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxCover {

    public static int minGroups(int[][] meeting) {
        int n = meeting.length;
        Arrays.sort(meeting, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 注意这里的判断
            while (!heap.isEmpty() && heap.peek() < meeting[i][0]) { // 小于左区间
                heap.poll();
            }
            heap.add(meeting[i][1]);
            ans = Math.max(ans, heap.size());
        }
        return ans;
    }
}
