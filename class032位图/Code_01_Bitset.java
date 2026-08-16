package class032位图;

public class Code_01_Bitset {

    // n 位数字 需要的int【】是 n /32 向上取整
    public static class Bitset1 {
        public int[] set;

        public Bitset1(int n){
            // 向上取整  (a + b - 1) / b
            set = new int[(n + 31) / 32];
        }

        public void add(int num){
            set[num / 32] |=  1 << (num % 32) ;

        }


        public void remove(int num){
            set[num / 32] &= ~( 1 << (num % 32)) ;

        }

        // 1 -> 0    0的变成 1    0001000 异或
        public void reverse(int num){
            set[num / 32] ^=   1 << (num % 32) ;

        }

        public boolean contains(int num) {
            return (set[num / 32] >> (num % 32)  & 1 ) == 1;
        }


    }


    // https://leetcode.cn/problems/design-bitset/
    class Bitset {
        private int[] set;
        private final int size;
        private int zeros;
        private int ones;
        private boolean reverse;

        public Bitset(int n) {
            set = new int[(n + 31) / 32];
            size = n;
            zeros = n;
            ones = 0;
            reverse = false;
        }

        public void fix(int idx) {
            int index = idx / 32;
            int bit = idx % 32;
            if(! reverse){
                if((set[index] & (1 << bit)) == 0 ){
                zeros --;
                ones += 1;
                set[index] |= 1 << bit;
                }
            }
            else{
                if(  (set[index] & (1 << bit )) != 0        ){
                    zeros --;
                    ones ++;
                    set[index] ^= (1 << bit);
                }
            }

        }

        public void unfix(int i) {
            int index = i / 32;
            int bit = i % 32;
            if (!reverse) {
                if ((set[index] & (1 << bit)) != 0) {
                    ones--;
                    zeros++;
                    set[index] ^= (1 << bit);
                }
            } else {
                if ((set[index] & (1 << bit)) == 0) {
                    ones--;
                    zeros++;
                    set[index] |= (1 << bit);
                }
            }
        }

        public void flip(){
            reverse = ! reverse;
            int temp = ones;
            ones = zeros;
            zeros = temp;
        }
        public boolean all() {
            return ones == size;
        }

        public boolean one() {
            return ones > 0;
        }

        public int count() {
            return ones;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < size; i++) {
                int index = i / 32;
                int bit = i % 32;

                int value = (set[index] >> bit) & 1;

                if (reverse) {
                    value ^= 1;
                }

                builder.append(value);
            }

            return builder.toString();
        }
    }

}
