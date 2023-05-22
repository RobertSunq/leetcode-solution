
```
// @Title: 分割等和子集 (Partition Equal Subset Sum)
// @Author: robert.sunq
// @Date: 2021-06-22 23:55:11
// @Runtime: 56 ms
// @Memory: 39.2 MB

class Solution {
    public boolean canPartition(int[] nums) {
        // 0 - 1 背包问题，即拿的数为总数的一半
        int sum = 0;
        for(int n:nums){
            sum+=n;
        }
        // 如果和为奇数，则永远不可能平分
        if(sum %2 == 1) return false;
        // 表示和为 前col个数 的和能不能为 row
        boolean[][] dp = new boolean[nums.length][sum/2 + 1];
        // 即第一个数字，只有其对应的背包容量可以容下；
        if(nums[0] < sum/2){
            dp[0][nums[0]] = true;
        }
        // 从第二个数开始
        for(int i = 1; i<nums.length;i++){
            for(int j = 1;j<sum/2+1;j++){
                // 表示当前和可以由当前数字组成 ， 即两块 当前数字 自己为一块
                if(j == nums[i]){
                    dp[i][j] = true;
                }else if(j > nums[i]){
                    // 当前数值小于和j， 则其状态与前 i- 个数字可不可以达到 和j 
                    //  或者 i - 1个数字 可以不可以达到和 j - num[i]有关
                    // 即背包内必须由足够的空间可以放下当前元素
                    dp[i][j] = dp[i-1][j - nums[i]] || dp[i-1][j]; 
                }else{
                    // 即当前数大于和，则其状态呢和前一个数字，和为j的相同。 相当于背包放不下了
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][sum/2];
    }
}
