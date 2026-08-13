package class028基数排序;

import java.util.Arrays;

public class RadixSort {

    // 可以设置进制，不一定10进制，随你设置
    public static int BASE = 10;

    public static int MAXN = 50001;

    public static int[] help = new int[MAXN];

    public static int[] cnts = new int[BASE];

    public static int[] sortArray(int[] arr) {
        // 这里需要让数组没有负数 找到最小值 然后所有数减去这个最小值     排完序后再 加回来
        if(arr.length > 1){
            int n = arr.length;
            int min = arr[0];
            for (int i = 1; i < n; i++) {
                min = Math.min(arr[i], min);
            }
            int max = arr[0];
            for (int i = 0; i < n; i++) {
                arr[i] -= min;
                max = Math.max(arr[i], max);
            }
            radixSort(arr, n, bits(max));
            //排完序加回来
            for (int i = 0; i < n; i++) {
                arr[i] +=  min;
            }
        }
        return arr;
    }

    // 返回number在BASE进制下有几位
    public static int bits(int number) {
        int ans = 0;
        while (number > 0) {
            ans++;
            number /= BASE;
        }
        return ans;
    }

    // 基数排序核心代码
    // arr内要保证没有负数
    // n是arr的长度
    // bits是arr中最大值在BASE进制下有几位
    public static void radixSort(int[] arr, int n, int bits) {
        for(int offset = 1; bits > 0; offset *= BASE, bits --) {
            Arrays.fill(cnts, 0);
            for (int i = 0; i < n; i++) {
                // 统计 cnts数组个数
                 cnts[(arr[i] / offset) % BASE] += 1;
            }
            //变为前缀和形式
            for (int i = 1; i < cnts.length; i++) {
                cnts[i] = cnts[i] + cnts[i - 1];
            }
            //填入 从右往左
            for (int i = n - 1; i >= 0; i--) {
                help[--cnts[(arr[i] / offset) % BASE]]    =  arr[i];
            }
            for (int i = 0; i < n; i++) {
                arr[i] = help[i];
            }

        }
    }


}