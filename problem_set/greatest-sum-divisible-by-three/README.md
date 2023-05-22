
| [English](README_EN.md) | 简体中文 |

# [1262. 可被三整除的最大和](https://leetcode.cn//problems/greatest-sum-divisible-by-three/)

## 题目描述

<p>给你一个整数数组&nbsp;<code>nums</code>，请你找出并返回能被三整除的元素最大和。</p>

<ol>
</ol>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums = [3,6,5,1,8]
<strong>输出：</strong>18
<strong>解释：</strong>选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums = [4]
<strong>输出：</strong>0
<strong>解释：</strong>4 不能被 3 整除，所以无法选出数字，返回 0。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>nums = [1,2,3,4,4]
<strong>输出：</strong>12
<strong>解释：</strong>选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 4 * 10^4</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10^4</code></li>
</ul>


## 题解


### C++

```C++
// @Title: 可被三整除的最大和 (Greatest Sum Divisible by Three)
// @Author: robert.sunq
// @Date: 2020-05-13 00:17:08
// @Runtime: 80 ms
// @Memory: 23 MB

class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        int dp[3] = {0,0,0};
        for (int i=0;i<nums.size();i++){
            int mod = nums[i]%3;
            int a = dp[(3+0-mod) %3];
            int b = dp[(3+1-mod) %3];
            int c = dp[(3+2-mod) %3];

            if(a|| mod == 0) dp[0] = max(dp[0],a+nums[i]);
            if(b|| mod == 1) dp[1] = max(dp[1],b+nums[i]);
            if(c|| mod == 2) dp[2] = max(dp[2],c+nums[i]);
        }
        return dp[0];
    }
};
```



### Java

```Java
// @Title: 可被三整除的最大和 (Greatest Sum Divisible by Three)
// @Author: robert.sunq
// @Date: 2021-08-02 23:50:11
// @Runtime: 8 ms
// @Memory: 44.6 MB

class Solution {
    public int maxSumDivThree(int[] nums) {
        // 保存当前状态下，和对三取余  余 0 ，1 ，2 的最大和
        int[] dp = new int[3];

        for(int i=0;i<nums.length;i++){
            // 将动态规划变为事前处理

            // 当前位对三取余
            int mod = nums[i]%3;
            // 表示当前位如果要凑成对3取余为0，需要再哪个余数 和的基础上增加
            int a = dp[(3 + 0 - mod) % 3];
            // 表示当前位如果要凑成对3取余为1，。。。。
            int b = dp[(3 + 1 - mod) % 3];
            // 表示当前位如果要凑成对3取余为2，。。。。
            int c = dp[(3 + 2 - mod) % 3];
            
            // 求和
            if(a>0 || mod == 0){
                dp[0] = Math.max(dp[0],a+nums[i]);
            }
            if(b>0 || mod == 1){
                dp[1] = Math.max(dp[1],b+nums[i]);
            }
            if(c>0 || mod == 2){
                dp[2] = Math.max(dp[2],c+nums[i]);
            }
        }

        return dp[0];
    }
}
```



## 相关话题

- [贪心](https://leetcode.cn//tag/greedy)
- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



