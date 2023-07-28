
```
// @Title: 最长斐波那契数列 (最长斐波那契数列)
// @Author: robert.sunq
// @Date: 2023-07-28 22:32:54
// @Runtime: 85 ms
// @Memory: 54.4 MB

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> keyToIndex = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i< n ; i++) {
            keyToIndex.put(arr[i], i);
        }


        // i , j 表示 序列的最后两位下标， dp[i][j] 表示 x, x, x, j , i 的个数
        int[][] dp = new int[n][n];
        int ans = 0;
        for (int i = 0; i< n; i++) {
            // 从最大值开始往下降， 保证前缀为 dp[j][k]
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                int k = keyToIndex.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    // 因为初始化都是0， 所以对于最开始的序列， 前两个之数字是没有加入到计算的
                    dp[i][j] = Math.max(dp[j][k] + 1, 3);
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }
}
