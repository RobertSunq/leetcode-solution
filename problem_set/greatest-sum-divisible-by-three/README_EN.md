
| English | [简体中文](README.md) |

# [1262. Greatest Sum Divisible by Three](https://leetcode.cn//problems/greatest-sum-divisible-by-three/)

## Description

<p>Given an integer array <code>nums</code>, return <em>the <strong>maximum possible sum </strong>of elements of the array such that it is divisible by three</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,6,5,1,8]
<strong>Output:</strong> 18
<strong>Explanation:</strong> Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [4]
<strong>Output:</strong> 0
<strong>Explanation:</strong> Since 4 is not divisible by 3, do not pick any number.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4,4]
<strong>Output:</strong> 12
<strong>Explanation:</strong> Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 4 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>


## Solutions


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



## Related Topics

- [Greedy](https://leetcode.cn//tag/greedy)
- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions


