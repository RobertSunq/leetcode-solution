
```
// @Title: 编辑距离 (Edit Distance)
// @Author: robert.sunq
// @Date: 2021-06-09 23:21:47
// @Runtime: 7 ms
// @Memory: 38.6 MB

class Solution {
    public int minDistance(String word1, String word2) {
        // if(word1.length() <= 0) return word2.length();
        // if(word2.length() <= 0) return word1.length();
        // dp[i][j] 表示由i位的word1 到j位的word2 需要的最少转换步骤
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0;i<=word1.length();i++){
            for(int j = 0;j<=word2.length();j++){
                // 边界
                if(j == 0){
                    // 全删除
                    dp[i][j] = i;
                }else if(i == 0){
                    // 全添加
                    dp[i][j] = j;
                }else{
                    // 当前位置相同，则最少转换状态与前一个相同
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        // 不相等时，则I的位置选择 删除，添加，替换中间最小的变化
                        dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1] , dp[i-1][j-1])) + 1;
                    }
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
