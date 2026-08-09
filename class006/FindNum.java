package class006;

public class FindNum {



    /*
    在有序的前提下才能用这个方法
     */
    public static boolean exist(int[] arr, int num){
        if(arr == null || arr.length == 0){
            return false;
        }
        int l = 0, r = arr.length - 1, m = 0;
        while(l <= r){
            m = (l + r) / 2;
            if (arr[m] == num){
                return true;
            }
            else if(arr[m] > num){
                //    15      10
                r = m - 1;
            }
            else{
                l = m + 1;
            }
        }
    }
}
