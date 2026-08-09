package class021;

import java.io.*;

public class Code01_MergeSort {
    public static int MAXN = 100001;

    public static int[] arr = new int[MAXN];

    public static int[] help = new int[MAXN];

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        n = (int) in.nval;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }
        mergeSort1(0, n - 1);
        // mergeSort2();
        for (int i = 0; i < n - 1; i++) {
            out.print(arr[i] + " ");
        }
        out.println(arr[n - 1]);
        out.flush();
        out.close();
        br.close();
    }
    //递归版本merge sort
    public static void mergeSort1(int l, int r){
        if(l == r){
            return;
        }
        int m = (l + r) / 2 ;
        mergeSort1(l, m);
        mergeSort1(m + 1,  r);      // 时间复杂度 log(2,2) == 1 O(n*logn)
        merge(l, m, r);
    }

    // 把两边排好序的 弄到新数组里面  每个数组设置一个指针
    public static void merge(int l, int m, int r) {
        int a = l;
        int b = m + 1;
        int i = l;
        //两个都没越界  把较小的先放进去 一方越界后把没越界的一方加进去
        while(a <= m && b <= r){
            help[i++] =  arr[a] >= arr[b] ? arr[b++] : arr[a++];
        }
        while(a <= m){
            help[i++] = arr[a++];
        }
        while (b <= r){
            help[i++] = arr[b++];
        }

        // copy回去
        for (int j = l; j <= r; j++) {
            arr[j] = help[j];
        }
    }

    //非递归版本
    public static void mergeSort2(){
            //步长 分别取 1, 2, 4,8 ... 一个一个 ，两个两个排序
        for(int l,m,r,step = 1; step < n ; step <<= 1){ // O(logN)
            l = 0; // m  =  l + x - 1
            while(l < n){   // O(n) <-  O(4) + o(4);
                m = l + step - 1;
                if(m +  1 >= n- 1){ // 没有右侧
                    break;
                }
                // 求右侧的右边界 min( l+ 2x - 1, n- 1)
                r = Math.min(l + (step<<1)- 1 , n- 1);
                merge(l, m, r);
                // l....m m+1....r
                //                  l....m m+1....r
                //                                  l....m m+1....r
                l = r + 1;
            }

        }
    }

}
