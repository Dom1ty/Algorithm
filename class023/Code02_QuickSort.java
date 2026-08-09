package class023;

public class Code02_QuickSort {

    //未优化版本 快速排序
    public static void quickSort1(int[] arr, int l, int r) {
        if(l >= r){
            return;
        }
        int x = arr[l + (int) (Math.random() * (r - l + 1))];
        int m = partition1(arr, l, r, x);
        quickSort1(arr, l, m);
        quickSort1(arr,m + 1, r);
    }


    //      -> 左边 <=  x  <  右边
    public static int partition1(int[] arr, int l, int r, int x) {
        // a : arr[l....a-1]范围是<=x的区域
        // xi : 记录在<=x的区域上任何一个x的位置，哪一个都可以
        // case <= x  arr[i] 和 arr[a] 交换， a++ i++  a代表了这个界限
        // case > x  i++
        //最后再把x和 界限前一个数换位即可
        // xi 是 = x的位置 任意一个就可以
        int a = l;
        int xi = 0;
        for (int i = l ; i <= r; i++) {
            if(arr[i] <= x){
                swap(arr, a, i);
                if(arr[a] == x){
                   xi = a;
                }
                a++;
            }
        }
        swap(arr, xi, a - 1);
        return a - 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

 // -----------------------------------------------------------------------------------------
    public static  int first, last;

    public static void quickSort2(int[] arr, int l, int r){
        if(l >= r){
            return;
        }
        int x = arr[l + (int) (Math.random() * (r - l + 1))];
        partition2(arr, l, r, x);

        // 为了防止底层的递归过程覆盖全局变量
        // 这里用临时变量记录first、last
        int left = first;
        int right = last;

        quickSort2(arr, l, left - 1);
        quickSort2(arr,right + 1, r);
    }

// DUtch National flag

    // 已知arr[l....r]范围上一定有x这个值
    // 划分数组 <x放左边，==x放中间，>x放右边
    // 把全局变量first, last，更新成==x区域的左右边界
    public static void partition2(int[] arr, int l , int r, int x){
        first = l;
        last =  r;
        int i  = l;
        while (i <= last){
            if(arr[i] < x){
                swap(arr, first++, i++);
            } else if (arr[i] == x) {
                i++;
            }
            else{
                swap(arr, last--, i);
            }
        }
    }


}
