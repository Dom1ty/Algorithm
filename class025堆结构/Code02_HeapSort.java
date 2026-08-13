package class025堆结构;

import static class004.SelectionBubbleInsert.swap;

public class Code02_HeapSort {



    // i是新来的数的下标  跟父亲大小考虑若大 则交换
    //向下调整
    public static void heapInsert(int[] arr, int i) {
        while(arr[i] > arr[(i - 1/ 2)]){
            swap(arr, i, (i-1) / 2);
            i =  (i - 1) / 2;
        }
    }

    //i 位置的数字变了 向下调整
    //要不就是 没有子节点 要不就是 左右两个child 比 i小 结束循环
    public static void heapify(int[] arr, int i, int size) {
        int l = 2 * i + 1;
        while(l < size){
            // 看 有没有左孩子 然后选出 厉害的孩子下标
            int best =  l +  1 < size && arr[l] > arr[l + 1]      ?  l : l + 1;
            // 跟 i 比较
            best = arr[best] > arr[i] ? best : i;
            if(best == i){  //最强的是自己
                break;
            }
            // 自己小 交换一波
            swap(arr, best, i);
            i = best;
            l = 2 * i + 1;
        }
    }

    //O(n * logN)
    //进堆  O(n * logN)
    // 调整 O(n * logN)
    public static void heapSort1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            heapInsert(arr, i);
        }
        int size = n;
        while(size > 1){
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }


    //大根堆 每次 把 最大值调整的数组的最后 然后size --
    public static void heapSort2(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
        int size = n;
        while(size > 1){
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }
}
