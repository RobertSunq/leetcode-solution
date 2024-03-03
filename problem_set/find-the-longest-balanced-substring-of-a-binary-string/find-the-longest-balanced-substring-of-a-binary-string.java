
```
// @Title: 最长平衡子字符串 (Find the Longest Balanced Substring of a Binary String)
// @Author: robert.sunq
// @Date: 2023-11-08 22:13:35
// @Runtime: 1 ms
// @Memory: 40.9 MB

class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }

        int ans = 0;
        // 记录遇到的连续 0 和 1 的个数
        int[] count = new int[2];

        if (s.charAt(0) == '0') {
            count[0] = 1;
        } else {
            count[1] = 1;
        }

        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                if (s.charAt(i - 1) == '0') {
                    // 当前 0 和前一位是连续的 0, 则连续个数+1
                    // 1 不做修改，因为连续的0再开头的时候已经处理过 赋值1的连续个数为 0
                    count[0] = count[0] + 1;
                } else {
                    // 是开头第一位 0， 所有恢复初始计算
                    count[0] = 1;
                    count[1] = 0;
                }
            } else {
                // 如果是1， 则再前面连续的1 的个数上 + 1。
                // 不区分的原因在于不论是不是开头还是连续的1， 都是再原来的基础上 + 1
                count[1] = count[1] + 1;

                // 因为都是统计的连续的个数， 所有 这时候两个连续个数 的最小的值 * 2 ，就是符合条件的结果
                // 不连续，从1变为0的时候，会在另一个判断中，把 1 的连续个数清零。所以可以直接用最小的连续数，来表示结果的一半
                ans = Math.max(ans, Math.min(count[0], count[1]) * 2);
            }
        }

        return ans;
    }
}
