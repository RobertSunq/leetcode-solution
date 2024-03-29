
| [English](README_EN.md) | 简体中文 |

# [746. 使用最小花费爬楼梯](https://leetcode.cn//problems/min-cost-climbing-stairs/)

## 题目描述

<p>给你一个整数数组 <code>cost</code> ，其中 <code>cost[i]</code> 是从楼梯第 <code>i</code> 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。</p>

<p>你可以选择从下标为 <code>0</code> 或下标为 <code>1</code> 的台阶开始爬楼梯。</p>

<p>请你计算并返回达到楼梯顶部的最低花费。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>cost = [10,<em><strong>15</strong></em>,20]
<strong>输出：</strong>15
<strong>解释：</strong>你将从下标为 1 的台阶开始。
- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
总花费为 15 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>cost = [<em><strong>1</strong></em>,100,<em><strong>1</strong></em>,1,<em><strong>1</strong></em>,100,<em><strong>1</strong></em>,<em><strong>1</strong></em>,100,<em><strong>1</strong></em>]
<strong>输出：</strong>6
<strong>解释：</strong>你将从下标为 0 的台阶开始。
- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
总花费为 6 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= cost.length &lt;= 1000</code></li>
	<li><code>0 &lt;= cost[i] &lt;= 999</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 使用最小花费爬楼梯 (Min Cost Climbing Stairs)
// @Author: robert.sunq
// @Date: 2023-09-20 21:41:33
// @Runtime: 0 ms
// @Memory: 41.5 MB

class Solution {
    // 注意，最后一个台阶之后才是楼顶（越过最后一个台阶），而不是到达最后一个台阶。
    // 无力吐槽
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp1 = 0;
        int dp2 = 0;
        int i = 2;
        // 要越过最后一个台阶
        while (i <= n) {
            int dp = Math.min(dp1 + cost[i - 2], dp2 + cost[i - 1]);
            dp1 = dp2;
            dp2 = dp;
            i++;
        }

        return dp2;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [爬楼梯](../climbing-stairs/README.md)
