package class007;

public class test {
    public static void main(String[] args) {
        int N = 200000;
        long start;
        long end;
        System.out.println("测试开始");
        start = System.currentTimeMillis();
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                // 这两个嵌套for循环的流程，时间复杂度为O(N * logN)
                // 1/1 + 1/2 + 1/3 + 1/4 + 1/5 + ... + 1/n，也叫"调和级数"，收敛于O(logN)
                // 所以如果一个流程的表达式 : n/1 + n/2 + n/3 + ... + n/n
                // 那么这个流程时间复杂度O(N * logN)
            }
        }
        end = System.currentTimeMillis();
        System.out.println("测试结束，运行时间 : " + (end - start) + " 毫秒");

        System.out.println("测试开始");
        start = System.currentTimeMillis();
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                // 这两个嵌套for循环的流程，时间复杂度为O(N^2)
                // 很明显等差数列
            }
        }
        end = System.currentTimeMillis();
        System.out.println("测试结束，运行时间 : " + (end - start) + " 毫秒");




    }
}
