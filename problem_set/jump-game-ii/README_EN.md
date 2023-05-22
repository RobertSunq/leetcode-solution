
| English | [简体中文](README.md) |

# [45. Jump Game II](https://leetcode.cn//problems/jump-game-ii/)

## Description

<p>You are given a <strong>0-indexed</strong> array of integers <code>nums</code> of length <code>n</code>. You are initially positioned at <code>nums[0]</code>.</p>

<p>Each element <code>nums[i]</code> represents the maximum length of a forward jump from index <code>i</code>. In other words, if you are at <code>nums[i]</code>, you can jump to any <code>nums[i + j]</code> where:</p>

<ul>
	<li><code>0 &lt;= j &lt;= nums[i]</code> and</li>
	<li><code>i + j &lt; n</code></li>
</ul>

<p>Return <em>the minimum number of jumps to reach </em><code>nums[n - 1]</code>. The test cases are generated such that you can reach <code>nums[n - 1]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,3,1,1,4]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,3,0,1,4]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
	<li>It&#39;s guaranteed that you can reach <code>nums[n - 1]</code>.</li>
</ul>


## Solutions


### C++

```C++
// @Title: 跳跃游戏 II (Jump Game II)
// @Author: robert.sunq
// @Date: 2020-05-13 00:35:31
// @Runtime: 8 ms
// @Memory: 7.7 MB

class Solution {
public:
    int jump(vector<int>& nums) {
        int ans = 0;
        int star = 0;
        int end = 1;
        while(end<nums.size()){
            int temp = 0;
            for(int i = star ; i<end;i++){
                temp = max(i+nums[i],temp);
            }
            star = end;
            end = temp+1;
            ans++;
        }
        return ans;
    }
};
```



### Java

```Java
// @Title: 跳跃游戏 II (Jump Game II)
// @Author: robert.sunq
// @Date: 2021-08-02 23:59:18
// @Runtime: 53 ms
// @Memory: 38.9 MB

class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        // 初始化需要跳跃的次数状态数组，第I格最多需要I次
        for(int i = 0;i<nums.length;i++){
            dp[i] = i;
        }
        for(int i=0;i<nums.length;i++){
            // 当前位置可跳跃范围中 最少次数为 （当前位置次数+1，或者原本的次数）
            for(int j = i+1;j<=i+nums[i] && j<nums.length;j++){
                dp[j] = Math.min(dp[i]+1,dp[j]);
            }
        }
        return dp[nums.length-1];
    }
}
```



## Related Topics

- [Greedy](https://leetcode.cn//tag/greedy)
- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Jump Game](../jump-game/README_EN.md)
