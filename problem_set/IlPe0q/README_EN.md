
| English | [简体中文](README.md) |

# [剑指 Offer II 100. 三角形中最小路径之和](https://leetcode.cn//problems/IlPe0q/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 三角形中最小路径之和 (三角形中最小路径之和)
// @Author: robert.sunq
// @Date: 2023-07-31 22:54:42
// @Runtime: 3 ms
// @Memory: 41.8 MB

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int maxM = triangle.get(n - 1).size();

        int[] dp = new int[maxM];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            List<Integer> tmp = triangle.get(i);
            int old = 0;
            for (int j = 0; j < tmp.size(); j++) {
                int t;
                if (j == 0) {
                    t = dp[j] + tmp.get(j);
                } else if (j == tmp.size() - 1) {
                    t = old + tmp.get(j);
                } else {
                    t = Math.min(old, dp[j]) + tmp.get(j);
                }
                // 记录当前的值，放到一下回合参与计算
                old = dp[j];
                dp[j] = t;
                if (i == n - 1) {
                    ans = Math.min(ans, dp[j]);
                }
            }
        }
        return ans;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions


