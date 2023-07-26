
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 090. 环形房屋偷盗](https://leetcode.cn//problems/PzWKhm/)

## 题目描述

<p>一个专业的小偷，计划偷窃一个环形街道上沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 <strong>围成一圈</strong> ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，<strong>如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警</strong> 。</p>

<p>给定一个代表每个房屋存放金额的非负整数数组 <code>nums</code> ，请计算&nbsp;<strong>在不触动警报装置的情况下</strong> ，今晚能够偷窃到的最高金额。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,3,2]
<strong>输出：</strong>3
<strong>解释：</strong>你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,1]
<strong>输出：</strong>4
<strong>解释：</strong>你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
&nbsp;    偷窃到的最高金额 = 1 + 3 = 4 。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [0]
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 213&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/house-robber-ii/">https://leetcode-cn.com/problems/house-robber-ii/</a></p>


## 题解


### Java

```Java
// @Title: 环形房屋偷盗 (环形房屋偷盗)
// @Author: robert.sunq
// @Date: 2023-07-26 23:28:43
// @Runtime: 0 ms
// @Memory: 38.5 MB

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }


        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 这里是重点
        // 偷第一家，所以不能偷最后一家， [0, n - 1]
        int prevRobFirst = nums[0];
        int curRobFirst = Math.max(nums[0], nums[1]);

        // 不偷最后一家， 所以可以选择偷最后一家 [1, n]
        int prevNotRobFirst = nums[1];
        int curNotRobFirst = Math.max(nums[1], nums[2]);

        for (int i = 2; i < n; i++) {
            // 偷第一家， 不偷最后一家
            if ( i < n - 1) {
                int tmpRob = Math.max(prevRobFirst + nums[i], curRobFirst);
                prevRobFirst = curRobFirst;
                curRobFirst = tmpRob;
            } 
            // 不偷最后一家，偷到最后
            if (i > 2) {
                int tmpNotRob = Math.max(prevNotRobFirst + nums[i] , curNotRobFirst);
                prevNotRobFirst = curNotRobFirst;
                curNotRobFirst = tmpNotRob;
            }
        }

        return Math.max(curRobFirst, curNotRobFirst);
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



