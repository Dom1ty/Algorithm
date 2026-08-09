package class006;

public class findPeakElement {


    class Solution {
    public int findPeakElement(int[] nums) {
        int ans = -1;
        int n = nums.length;
        if(nums.length == 1){
            return 0;
        }

        //check 0   n -1是不是峰值
        if(nums[0] > nums[1]){
                return 0;
        } else if (nums[n - 1] > nums[n - 2] ) {
                return  n - 1;
        }

        // 1 到n - 2
        int  l = 1, r = n - 2, m = 0;
        while (l <= r){
            m = (l + r) / 2;
            if(nums[m - 1] > nums[ m]){ //左侧有峰值 对左侧二分
                r = m - 1;
            }
            else if(nums[m + 1] > nums[m]){
                l = m + 1;
            }
            else{ //中点就是峰值
                ans = m;
                break;
            }
        }
        return ans;

    }
}
}
