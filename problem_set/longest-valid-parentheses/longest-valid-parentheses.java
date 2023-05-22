
```
// @Title: 最长有效括号 (Longest Valid Parentheses)
// @Author: robert.sunq
// @Date: 2021-07-11 23:40:47
// @Runtime: 1 ms
// @Memory: 38.2 MB

class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() <= 0) return 0;
        // 表示 i位置时候可以匹配的括号长度
        int[] dp = new int[s.length()];
        int res = 0;
        dp[0] = 0;
        for(int i = 1;i<s.length();i++){
            // 为右括号，则该位置不可匹配
            if(s.charAt(i) == '('){
                dp[i] = 0;
            }else{
                // 如果和i-1匹配
                if(s.charAt(i-1) == '('){
                    // 前面的有效长度 + 2
                    if(i - 2 >= 0){
                        dp[i] = dp[i-2]+2;
                    }else{
                        dp[i] = 2;
                    }
                // 和 位置  i - dp[i-1] -1 位置上匹配
                // dp[i-1]>0 表示前一个字符匹配了
                }else if(dp[i-1]>0 && i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1) == '('){
                    // 位置  i - dp[i-1] -1 前还有，则当前位置应该要加上其之前匹配的长度
                    if(i - dp[i-1] -1 >0){
                        dp[i] = dp[i - dp[i-1] - 2] + dp[i-1]+ 2;
                    }else{
                        dp[i] = dp[i-1]+ 2;
                    }
                }
            }
            // 保存可以匹配的最大长度
            res = Math.max(dp[i] , res);
        }
        return res;
    }
}
