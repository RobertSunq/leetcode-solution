
| [English](README_EN.md) | 简体中文 |

# [45. 跳跃游戏 II](https://leetcode.cn//problems/jump-game-ii/)

## 题目描述

<p>给定一个长度为 <code>n</code> 的 <strong>0 索引</strong>整数数组 <code>nums</code>。初始位置为 <code>nums[0]</code>。</p>

<p>每个元素 <code>nums[i]</code> 表示从索引 <code>i</code> 向前跳转的最大长度。换句话说，如果你在 <code>nums[i]</code> 处，你可以跳转到任意 <code>nums[i + j]</code> 处:</p>

<ul>
	<li><code>0 &lt;= j &lt;= nums[i]</code>&nbsp;</li>
	<li><code>i + j &lt; n</code></li>
</ul>

<p>返回到达&nbsp;<code>nums[n - 1]</code> 的最小跳跃次数。生成的测试用例可以到达 <code>nums[n - 1]</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = [2,3,1,1,4]
<strong>输出:</strong> 2
<strong>解释:</strong> 跳到最后一个位置的最小跳跃数是 <code>2</code>。
&nbsp;    从下标为 0 跳到下标为 1 的位置，跳&nbsp;<code>1</code>&nbsp;步，然后跳&nbsp;<code>3</code>&nbsp;步到达数组的最后一个位置。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums = [2,3,0,1,4]
<strong>输出:</strong> 2
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
	<li>题目保证可以到达&nbsp;<code>nums[n-1]</code></li>
</ul>


## 题解


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



## 相关话题

- [贪心](https://leetcode.cn//tag/greedy)
- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [跳跃游戏](../jump-game/README.md)
