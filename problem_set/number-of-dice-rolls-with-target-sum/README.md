
| [English](README_EN.md) | 简体中文 |

# [1155. 掷骰子等于目标和的方法数](https://leetcode.cn//problems/number-of-dice-rolls-with-target-sum/)

## 题目描述

<p>这里有&nbsp;<code>n</code>&nbsp;个一样的骰子，每个骰子上都有&nbsp;<code>k</code>&nbsp;个面，分别标号为&nbsp;<code>1</code>&nbsp;到 <code>k</code> 。</p>

<p>给定三个整数 <code>n</code>、<code>k</code> 和 <code>target</code>，请返回投掷骰子的所有可能得到的结果（共有 <code>k<sup>n</sup></code> 种方式），使得骰子面朝上的数字总和等于 <code>target</code>。</p>

<p>由于答案可能很大，你需要对 <code>10<sup>9</sup> + 7</code> <strong>取模</strong>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 1, k = 6, target = 3
<strong>输出：</strong>1
<strong>解释：</strong>你掷了一个有 6 个面的骰子。
得到总和为 3 的结果的方式只有一种。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 2, k = 6, target = 7
<strong>输出：</strong>6
<strong>解释：</strong>你掷了两个骰子，每个骰子有 6 个面。
有 6 种方式得到总和为 7 的结果: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>n = 30, k = 30, target = 500
<strong>输出：</strong>222616187
<strong>解释：</strong>返回的结果必须对 10<sup>9</sup> + 7 取模。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n, k &lt;= 30</code></li>
	<li><code>1 &lt;= target &lt;= 1000</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 掷骰子等于目标和的方法数 (Number of Dice Rolls With Target Sum)
// @Author: robert.sunq
// @Date: 2023-10-24 22:08:21
// @Runtime: 21 ms
// @Memory: 37.9 MB

class Solution {

    private static final long MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        long[] dp = new long[target + 1];
        for (int i = 1; i <= k && i <= target; i++) {
            dp[i] = 1;
        }
        for (int count = 2; count <= n; count++) {
            // 因为 骰子最小为 1， 所以 count 个骰子的 最小值和为 count
            // 从最大往小计算 count 个骰子的和，可以避免从小往大算的时候，小的再本轮的新值覆盖上一轮的，导致大的数无法使用上一轮的值
            for (int t = target; t >= count; t--) {
                long tmp = 0L;
                for (int i = 1; i <= k; i++) {
                    // 骰子不存在为 0 的情况， 所以 当前sum - 骰子数目之后必须大于 上一轮 骰子和的最小值 (count - 1)
                    if (t - i < count - 1) {
                        break;
                    }
                    tmp = (tmp + dp[t - i]) % MOD;
                }
                dp[t] = tmp;
            }
        }

        return (int) (dp[target] % MOD);
    }
}
```



## 相关话题

- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



