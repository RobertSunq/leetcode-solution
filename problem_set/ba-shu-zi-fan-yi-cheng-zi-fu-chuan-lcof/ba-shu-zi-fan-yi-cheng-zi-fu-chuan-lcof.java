
```
// @Title: 把数字翻译成字符串 (把数字翻译成字符串 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-29 23:03:43
// @Runtime: 0 ms
// @Memory: 35 MB

class Solution {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;dp[1] = 1;
        // dp[i] 表示长度为 i时翻译数量
        for (int i = 2;i<=str.length();i++){
            // 和前一个可以一起翻译
            String tmp = str.substring(i-2,i);
            if(tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0){
                dp[i] = dp[i-1]+dp[i-2];
            }
            else{
                 dp[i] = dp[i-1];
            }
        }
        return dp[str.length()];
    }
}
