
| [English](README_EN.md) | 简体中文 |

# [312. 戳气球](https://leetcode.cn//problems/burst-balloons/)

## 题目描述

<p>有 <code>n</code> 个气球，编号为<code>0</code> 到 <code>n - 1</code>，每个气球上都标有一个数字，这些数字存在数组&nbsp;<code>nums</code>&nbsp;中。</p>

<p>现在要求你戳破所有的气球。戳破第 <code>i</code> 个气球，你可以获得&nbsp;<code>nums[i - 1] * nums[i] * nums[i + 1]</code> 枚硬币。&nbsp;这里的 <code>i - 1</code> 和 <code>i + 1</code> 代表和&nbsp;<code>i</code>&nbsp;相邻的两个气球的序号。如果 <code>i - 1</code>或 <code>i + 1</code> 超出了数组的边界，那么就当它是一个数字为 <code>1</code> 的气球。</p>

<p>求所能获得硬币的最大数量。</p>

<p>&nbsp;</p>
<strong>示例 1：</strong>

<pre>
<strong>输入：</strong>nums = [3,1,5,8]
<strong>输出：</strong>167
<strong>解释：</strong>
nums = [3,1,5,8] --&gt; [3,5,8] --&gt; [3,8] --&gt; [8] --&gt; []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,5]
<strong>输出：</strong>10
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 300</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 100</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 戳气球 (Burst Balloons)
// @Author: robert.sunq
// @Date: 2021-06-23 23:55:07
// @Runtime: 91 ms
// @Memory: 38.1 MB

class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        // 将两边都设置为1 作为边界
        int[] newNums = new int[len+2];
        for(int i =0;i<len;i++){
            newNums[i+1] = nums[i];
        }
        newNums[0] = 1;
        newNums[len+1] = 1;
        // dp 表示 序列I 到 J之间的最大金额 
        int[][] dp = new int[len+2][len+2];
        // 由于  eg dp[1][5] 与 dp[1][3] * dp[3][5] * nums[3] 有关，所以需要由下往上进行计算
        // I 为左边界   J 为右边界
        for(int i = len-1;i>=0;i--){
            // 即由三个数开始 逐渐增加啊
            for(int j = i + 2; j < len + 2; j++){
                
                // 开区间，i---j 之间 不包含 i j 从第一个数开始依次迭代 k为区间内打掉的最后一个气球
                for(int k = i + 1; k < j; k++){
                    // 当前最后打掉的气球 和 这个气球左右区间的和 就为当前的和
                    int temp = newNums[i]*newNums[j]*newNums[k] + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j],temp);
                }
            }
        }
        // 由于是 左右区间为开区间 所以是 从 0 —————— len+1
        return dp[0][len+1];
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [合并石头的最低成本](../minimum-cost-to-merge-stones/README.md)
