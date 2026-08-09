package class006;

public class FindLeft {
    public static void main(String[] args) {

    }


    //找到 <= num 的最右位置
    public static int findleft(int[] arr, int num){
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0, r = arr.length - 1, m = 0;
        int ans = -1;
        while (l <= r){
            m = (l + r) / 2;
            // 等价写法  m  = l + (( r- l ) >> 1)  防溢出 更加高效
            if (arr[m] <= num){
                ans = m;
                l = m + 1;

            }
            else{
                r = m - 1;
            }
        }
        return ans;
    }
}
