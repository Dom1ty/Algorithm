package class030异或;

public class findMissingNumber {

    // https://leetcode.com/problems/missing-number/
    public int missingNumber(int[] nums) {
        // 异或全部的数字 0 - 10 和 异或 有的数字 再 异或这两个就是最后结果
        int has = 0; int all = 0;
        for (int i = 0; i < nums.length; i++) {
            has ^= nums[i];
            all ^= i;
        }
        all ^= nums.length ;
        return all ^ has;
    }
}
