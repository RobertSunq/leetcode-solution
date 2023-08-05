
| [English](README_EN.md) | 简体中文 |

# [LCR 101. 分割等和子集](https://leetcode.cn//problems/NUPfPr/)

## 题目描述

<p>给定一个非空的正整数数组 <code>nums</code> ，请判断能否将这些数字分成元素和相等的两部分。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,5,11,5]
<strong>输出：</strong>true
<strong>解释：</strong>nums<strong> </strong>可以分割成 [1, 5, 5] 和 [11] 。</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,5]
<strong>输出：</strong>false
<strong>解释：</strong>nums<strong> </strong>不可以分为和相等的两部分
</pre>

<p>&nbsp;</p>

<p><meta charset="UTF-8" /></p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 416&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/partition-equal-subset-sum/">https://leetcode-cn.com/problems/partition-equal-subset-sum/</a></p>


## 题解


### Java

```Java
// @Title: 分割等和子集 (分割等和子集)
// @Author: robert.sunq
// @Date: 2023-08-01 00:05:23
// @Runtime: 43 ms
// @Memory: 44.3 MB

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        PriorityQueue<Integer> p = new PriorityQueue<>();
   
        for (int n : nums) {
            sum = sum + n;
            p.offer(n);
        }

        
        if ( (sum & 1) == 1) {
            return false;
        }
        int n = nums.length;
        // 0  ---- i 的和是否可以为j
        int halfSum = sum / 2;
        boolean[][] dp = new boolean[n + 1][halfSum + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= halfSum; j++) {
                // 和为 0 ，及任何一个数字都不选
                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                // 只有数字只有一种情况和为 num[0]
                if (i == 0) {
                    if (nums[i] <= halfSum) {
                        dp[i][nums[i]] = true;
                    }
                    break;
                }
                int tmp = j - nums[i];
                if (tmp < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][tmp];
                }
            }
        }

        return dp[n-1][halfSum];
    }
}
```



## 相关话题

- [数学](https://leetcode.cn//tag/math)
- [字符串](https://leetcode.cn//tag/string)
- [模拟](https://leetcode.cn//tag/simulation)

## 相似题目



