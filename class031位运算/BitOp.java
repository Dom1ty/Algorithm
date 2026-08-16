package class031位运算;

public class BitOp {

    // 判断是不是 2的幂
    public boolean isPowerOfTwo(int n) {
        // 一个数是2的幂， 只有可能是 它含有唯一的一，这里直接用Brian Kernighan
        // n & -n       → 取出最右侧的 1
        // n & (n - 1)  → 删除最右侧的 1
        return n > 0 && n == (n & -n);
    }

    // https://leetcode.cn/problems/power-of-three/
    // 3 的幂
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }


    // 已知n是非负数
    // 返回大于等于n的最小的2某次方
    // 如果int范围内不存在这样的数，返回整数最小值
    public static final int near2power(int n) {
        if (n <= 0) {
            return 1;
        }
        n--;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    //区间【a,b】 所有数字& 的结果
    // 考虑每次 right -= 最右侧的1 当 left 》= right 即为答案
    // https://leetcode.cn/problems/bitwise-and-of-numbers-range/
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right){
            right -= right & (-right);
        }
        return right;
    }

    // https://leetcode.cn/problems/reverse-bits/
    public int reverseBits(int n) {
        // 1 v 1 交换  2 v 2  4v 4 ....
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);   // a: 1010 5 0101
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);   // c : 1100   3: 0011
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);   // f0: 11110000    00001111
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);    // 1111111100000000   000000001111111
        n = (n >>> 16) | (n << 16);
        return n;
    }


    public static int cntOnes(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
        return n;
    }
}
