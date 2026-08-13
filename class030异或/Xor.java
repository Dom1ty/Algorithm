package class030异或;

public class Xor {

    // 当i!=j，没问题，会完成交换功能
    // 当i==j，会出错
    // 所以知道这种写法即可，并不推荐
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }



}
