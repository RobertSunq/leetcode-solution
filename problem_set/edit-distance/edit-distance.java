
```
// @Title: 编辑距离 (Edit Distance)
// @Author: robert.sunq
// @Date: 2023-09-26 21:05:05
// @Runtime: 5 ms
// @Memory: 42.3 MB

class Solution {
    public int minDistance(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();

        // 表示 word1 的 i 个字符 和 word2 的 j 个字符， 相等需要操作的最小次数
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0 ; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                
                // 表示要添加 word2 到 j 的所有字符 才可以相等
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    // 表示要删除 word1 到 i 的所有字符 才可以相等
                    dp[i][j] = i;
                } else {
                    // 当前位相等， ，则最少转换状态与前一个相同
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // 不相等时，则I的位置选择 删除，添加，替换中间最小的变化
                        dp[i][j] = Math.min( Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    }
                }
            }
        }

        return dp[n1][n2];
    }
}
