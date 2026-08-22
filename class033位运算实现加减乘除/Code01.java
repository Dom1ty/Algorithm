package class033位运算实现加减乘除;

public class Code01 {

    public static  int add(int a, int b){
        int ans = a;
        while( b !=0 ){
            ans = a ^ b;
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }

    public static int  minus(int a, int b){
        return add(a, neg(b));
    }

    public static int neg(int a){
        return add(~a, 1);
    }

    public static  int multiply(int a, int b){
        int ans = a;
        while (b != 0){
            if((b & 1) != 0){
                //b的最右侧 是不是1
                add(a, b);
            }
            a <<= 1;
            b >>>= 1;
        }
        return ans;
    }


    public static int MIN = Integer.MIN_VALUE;

    public static int divide(int a, int b){
        if(a == MIN && b == MIN) return 1;
        if(b == MIN) return 0;
        if(a != MIN && b != MIN) return div(a,b);
        if( b == neg(1)) return Integer.MAX_VALUE;

        // a是整数最小 b 不是

        // 正数 (a + b / b  ) - 1
        //负数 (a - b / b)  + 1      a = -10 b = -5   2
        a = add(a, b > 0 ? b : neg(b));
        int ans = div(a, b);
        int offset = b > 0 ? neg(1) : 1;
        return add(ans,offset);
    }

    public static  int div(int a, int b){
        int ans = 0;
        int x = a < 0 ? neg(a) : a;
        int y = b < 0 ? neg(b) : b;
        for (int i = 30; i >= 0 ; i = minus(i, 1)) {
            if(x >> i  >= y){
                ans |= (1 << i);
                x = minus(x, (y << i);
            }

        }
        return a < 0 ^ b < 0 ? neg(ans) : ans;
    }
}
