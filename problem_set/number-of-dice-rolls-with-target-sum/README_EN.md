
| English | [简体中文](README.md) |

# [1155. Number of Dice Rolls With Target Sum](https://leetcode.cn//problems/number-of-dice-rolls-with-target-sum/)

## Description

<p>You have <code>n</code> dice, and each dice has <code>k</code> faces numbered from <code>1</code> to <code>k</code>.</p>

<p>Given three integers <code>n</code>, <code>k</code>, and <code>target</code>, return <em>the number of possible ways (out of the </em><code>k<sup>n</sup></code><em> total ways) </em><em>to roll the dice, so the sum of the face-up numbers equals </em><code>target</code>. Since the answer may be too large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 1, k = 6, target = 3
<strong>Output:</strong> 1
<strong>Explanation:</strong> You throw one die with 6 faces.
There is only one way to get a sum of 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 2, k = 6, target = 7
<strong>Output:</strong> 6
<strong>Explanation:</strong> You throw two dice, each with 6 faces.
There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 30, k = 30, target = 500
<strong>Output:</strong> 222616187
<strong>Explanation:</strong> The answer must be returned modulo 10<sup>9</sup> + 7.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n, k &lt;= 30</code></li>
	<li><code>1 &lt;= target &lt;= 1000</code></li>
</ul>


## Solutions


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



## Related Topics

- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions


