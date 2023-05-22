
```
// @Title: 最长重复子数组 (Maximum Length of Repeated Subarray)
// @Author: robert.sunq
// @Date: 2021-07-18 15:47:42
// @Runtime: 46 ms
// @Memory: 47.5 MB

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int res = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 边界状态，长度为0的两个串匹配为0
        int[][] dp = new int[len1+1][len2+1];

        // i 表示长度为i的结尾为 num1[i-1]的字符串与
        // j 表示长度为j的结尾为num2[j-1]的字符串的最长子数组长度
        for(int i = 1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                // 当前结尾匹配
                if(nums1[i-1] == nums2[j-1]){
                    // 前一个字符不匹配，则匹配长度为0，匹配时则为dp[i-1][j-1]故不需要区分， + 1 表示加上当前匹配字符
                    // 当前状态两字符匹配长度
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = 0;
                }
                res = Math.max(res,dp[i][j]);
            }
        }

        return res;
    }
}
