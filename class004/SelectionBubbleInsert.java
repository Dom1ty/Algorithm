package class004;

public class SelectionBubbleInsert {

    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void SelectionSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }


        for (int minIndex, i = 0; i < arr.length ; i++) {  //外层 递增 i
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {   // 找到 最小的index 然后交换
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr, minIndex , i);
        }
    }

    public static void BubbleSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }

        //0 ~ n -1
        //0 ~ END --
        for (int end = arr.length -1 ; end > 0 ; end--) {
            // 0 1
            // 1 2
            // 2 3
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[ i + 1]){
                    swap(arr, i, i + 1);
                }
            }
        }

    }


    public static void InsertSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length ; i++) {
            //  0到 i - 1有序了 考虑i的大小
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j , j + 1);
            }

        }

    }
}
