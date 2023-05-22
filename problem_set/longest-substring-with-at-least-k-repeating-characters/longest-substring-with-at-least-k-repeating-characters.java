
```
// @Title: 至少有 K 个重复字符的最长子串 (Longest Substring with At Least K Repeating Characters)
// @Author: robert.sunq
// @Date: 2021-07-16 23:10:07
// @Runtime: 5 ms
// @Memory: 36.4 MB

class Solution {
    public int longestSubstring(String s, int k) {
        int res = 0;
        int sum = 0;
        int t = 0;
        char[] c = s.toCharArray();
        // 保存个字符的个数
        int[] temp = new int[26];
        // 枚举二十六种情况，即字串包含K个字母的时候，满足题意
        for(int K = 1;K<26;K++){
            // 状态还原  +++++++ 容易遗忘
            temp = new int[26];
            t = 0;
            sum = 0;
            int j = 0;
            // sum 表示区间[j,i] 满足个数不小于K的字符的个数，t 表示当前字符种类个数
            for(int i=0;i<s.length();i++){
                int index = c[i] -'a';
                temp[index]++;
                // 添加后，该字符个数为一，则表示种类+1
                if(temp[index] == 1){
                    t++;
                }
                // 如果字符个数等于K，则满足的个数加一，大于情况下，字符的种类没有增长
                if(temp[index] == k){
                    sum++;
                }
                // 当出现的个数，大于此次枚举的时候，右移左指针，使得个数降低
                while(t > K){
                    int index_1 = c[j]-'a';
                    temp[index_1]--;
                    if(temp[index_1] == 0) {
                        t--;
                    }
                    if(temp[index_1] == k-1){
                        sum--;
                    }
                    j++;
                }
                 // 当所有字符都符合要求，更新答案
                if (t == sum) res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
}
