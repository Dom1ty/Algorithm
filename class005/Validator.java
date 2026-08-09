package class005;

import class004.SelectionBubbleInsert;

public class Validator {

    public static void main(String[] args) {
        int N = 100; //数组最大长度
        int V = 1000;   //随机数组每个值
        int testTimes = 50000;
        System.out.println("tests begin");
        for (int i = 0; i < testTimes; i++) {
            // 随机得到一个长度，长度在[0~N-1]
            int n = (int) (Math.random() * N);
            // 得到随机数组
            int[] arr = randomArray(n, V);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);
            SelectionBubbleInsert.SelectionSort(arr1);
            SelectionBubbleInsert.BubbleSort(arr2);
            SelectionBubbleInsert.InsertSort(arr3);
            if (!sameArray(arr1, arr2) || !sameArray(arr1, arr3)) {
                System.out.println("出错了!");
                // 当有错了
                // 打印是什么例子，出错的
                // 打印三个功能，各自排序成了什么样
                // 可能要把例子带入，每个方法，去debug！
            }
        }
        System.out.println("测试结束");
    }






    //得到一个随机值 长度为n的数组
    public static int[] randomArray(int n, int v){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int )(Math.random() * v) + 1; //生成一个 1 到v之间的数
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }




    public static boolean sameArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
