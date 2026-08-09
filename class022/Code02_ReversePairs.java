package class022;

public class Code02_ReversePairs {
    public static int MAXN = 50001;

    public static int[] help = new int[MAXN];

    // https://leetcode.cn/problems/reverse-pairs/description/
    public int reversePairs(int[] nums) {
        return counts(nums, 0, nums.length - 1 );
    }

    public  int counts(int[] arr, int l , int r){
        if(l == r){
            return 0;
        }
        int m = (l + r) / 2;
        return counts(arr, l, m) + counts(arr,m + 1, r) + merge(arr, l, m , r);
    }

    //	 返回左右侧逆序对数量，左侧有序、右侧有序，让左右两侧整体有序
    //	 arr[l...m] arr[m+1...r]
    public static int merge(int[] arr, int l, int m, int r){
        //统计部分 统计左跨右部分  每次固定左边看右边
        // 4 6 7 7  5 6 6 8
        // i        j
        int ans = 0;
        for(int j = m + 1, i = l; i <= m; i++){
            while( j <= r && (long) arr[i] > (long) 2 * arr[j]){
                j++;
            }
            ans += j - (m + 1);
        }
        //排序部分 就是归并排序的部分
        int a = l, b = m + 1, i = l;

        while(a <= m && b <= r){
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        while(a <= m){
            help[i++] = arr[a++];
        }
        while(b <= r){
            help[i++] = arr[b++];
        }
        for (int j = l; j <= r; j++) {
            arr[j] = help[j];
        }
        return ans;
    }



}
