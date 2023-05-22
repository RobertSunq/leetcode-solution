
| English | [简体中文](README.md) |

# [312. Burst Balloons](https://leetcode.cn//problems/burst-balloons/)

## Description

<p>You are given <code>n</code> balloons, indexed from <code>0</code> to <code>n - 1</code>. Each balloon is painted with a number on it represented by an array <code>nums</code>. You are asked to burst all the balloons.</p>

<p>If you burst the <code>i<sup>th</sup></code> balloon, you will get <code>nums[i - 1] * nums[i] * nums[i + 1]</code> coins. If <code>i - 1</code> or <code>i + 1</code> goes out of bounds of the array, then treat it as if there is a balloon with a <code>1</code> painted on it.</p>

<p>Return <em>the maximum coins you can collect by bursting the balloons wisely</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,1,5,8]
<strong>Output:</strong> 167
<strong>Explanation:</strong>
nums = [3,1,5,8] --&gt; [3,5,8] --&gt; [3,8] --&gt; [8] --&gt; []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,5]
<strong>Output:</strong> 10
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 300</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 100</code></li>
</ul>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Minimum Cost to Merge Stones](../minimum-cost-to-merge-stones/README_EN.md)
