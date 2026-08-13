package class030异或;

public class DoubleNum {
    // 出现了两个奇数次 的数字
    public static int[] singleNumber(int[] nums) {
        int eor1 = 0;
        for (int num : nums){
            eor1 ^=  num;
        }
        // eor1 : a ^ b
        // Brian Kernighan算法
        // 提取出二进制里最右侧的1
        int rightone = eor1 & (-eor1);
        int eor2 = 0;
        for (int num : nums){
            if((num & rightone) == 0){
                eor2 ^= num;
            }
        }
        return new int[] {eor2, eor2 ^ eor1};
    }
}
