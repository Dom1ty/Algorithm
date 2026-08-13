package class027;

import java.util.PriorityQueue;

public class MinimumOperation {

    public static int halveArray1(int nums[]){
        double sum =  0;
        int ans = 0;
        PriorityQueue<Double> heap = new PriorityQueue<>((a,b) -> b.compareTo(a)); // 大根堆建立
        for (int i = 0; i < nums.length; i++) {
            sum += (double) nums[i];
            heap.add((double)nums[i]);
        }
        sum /= 2;

        // 要减少一半 转化成 需要minus（已经减少的）达到现在sum的大小
        for(double minus =0  , cur = 0; minus < sum; minus+= cur, ans++){
            cur = heap.poll() / 2;
            heap.add(cur);
        }
        return ans;
    }


    // 优化 使用自建堆和全局静态变量


    public static int MAXN = 100001;

    public static long[] heap = new long[MAXN];

    public static int size;


    public static int halveArray2(int[] nums) {
        long sum = 0;
        int ans = 0;
        size = nums.length;
        for (int i = size - 1; i >= 0; i--) {
            heap[i]  =  (long) nums[i] << 20;
            sum += heap[i];
            heapify(i);
        }
        sum /= 2;
        for(long minus = 0  ; minus < sum; ans++){
            heap[0] /= 2;
            minus += heap[0];
            heapify(0);
        }
        return ans;
    }


    //  向下调整  只需要这个 建堆也用这个 复杂度为O（N）
    public static void heapify(int i) {
        int l = 2 * i + 1;
        while(l < size){
            //左右孩子比较
            int best = l + 1 < size && heap[l] < heap[l + 1] ?  l + 1 : l;
            // 当前与左右孩子较大的比较
            best = heap[i] >= heap[best] ? i : best;
            if(best == i){ //自己最大 不用继续了
                break;
            }
            swap(i, best); // 当前与更大的交换
            i = best;
            l = 2 * best + 1;
        }

    }
    public static void swap(int i, int j) {
        long tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}
