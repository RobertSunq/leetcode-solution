
```
// @Title: 不同的二叉搜索树 (Unique Binary Search Trees)
// @Author: robert.sunq
// @Date: 2021-06-09 22:39:14
// @Runtime: 0 ms
// @Memory: 35.3 MB

class Solution {

    int[] dp;
    public int numTrees(int n) {
        int res = 0;
        dp = new int[n+1];
        dp[0] = 1; 
        dp[1] = 1;
        for(int i = 1; i<=n ;i++){
            int temp = 0;
            for(int j = 0;j<i;j++){
                // 左子树节点数量 j  右子树 节点数量 i - j -1
                temp = temp + (dp[j] * dp[i-j-1]);
            }
            dp[i] = temp;
        }
        return dp[n];
    }

}
