
```
// @Title: 戳气球 (Burst Balloons)
// @Author: robert.sunq
// @Date: 2021-06-23 23:55:07
// @Runtime: 91 ms
// @Memory: 38.1 MB

class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        // 将两边都设置为1 作为边界
        int[] newNums = new int[len+2];
        for(int i =0;i<len;i++){
            newNums[i+1] = nums[i];
        }
        newNums[0] = 1;
        newNums[len+1] = 1;
        // dp 表示 序列I 到 J之间的最大金额 
        int[][] dp = new int[len+2][len+2];
        // 由于  eg dp[1][5] 与 dp[1][3] * dp[3][5] * nums[3] 有关，所以需要由下往上进行计算
        // I 为左边界   J 为右边界
        for(int i = len-1;i>=0;i--){
            // 即由三个数开始 逐渐增加啊
            for(int j = i + 2; j < len + 2; j++){
                
                // 开区间，i---j 之间 不包含 i j 从第一个数开始依次迭代 k为区间内打掉的最后一个气球
                for(int k = i + 1; k < j; k++){
                    // 当前最后打掉的气球 和 这个气球左右区间的和 就为当前的和
                    int temp = newNums[i]*newNums[j]*newNums[k] + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j],temp);
                }
            }
        }
        // 由于是 左右区间为开区间 所以是 从 0 —————— len+1
        return dp[0][len+1];
    }
}
