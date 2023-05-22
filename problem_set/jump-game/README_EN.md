
| English | [简体中文](README.md) |

# [55. Jump Game](https://leetcode.cn//problems/jump-game/)

## Description

<p>You are given an integer array <code>nums</code>. You are initially positioned at the array&#39;s <strong>first index</strong>, and each element in the array represents your maximum jump length at that position.</p>

<p>Return <code>true</code><em> if you can reach the last index, or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,3,1,1,4]
<strong>Output:</strong> true
<strong>Explanation:</strong> Jump 1 step from index 0 to 1, then 3 steps to the last index.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,2,1,0,4]
<strong>Output:</strong> false
<strong>Explanation:</strong> You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 跳跃游戏 (Jump Game)
// @Author: robert.sunq
// @Date: 2021-06-04 22:40:47
// @Runtime: 3 ms
// @Memory: 39.8 MB

class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int res = 0;
        for(int i= 0;i<len;i++){
            // 当前位置可以到达的最大位置， 为I+ nums[i] 或者别的模块的最大值
            res= Math.max(res,i+nums[i]);
            // res <= i 则表示最远只能到达I 如果此时I到最后位置，则表示到达不返回false  
            if(res <= i && i<len-1){
                return false;
            }
        }
        // 可以走出循环则代表可以走到最后
        return true;
    }
}
```



### C++

```C++
// @Title: 跳跃游戏 (Jump Game)
// @Author: robert.sunq
// @Date: 2020-05-13 00:26:46
// @Runtime: 20 ms
// @Memory: 12.7 MB

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int k=0;
        for (int i=0;i<nums.size();i++){
            if (i>k) return false;
            k = max(k,i+nums[i]);
        }
        return true;

    }
};
```



## Related Topics

- [Greedy](https://leetcode.cn//tag/greedy)
- [Array](https://leetcode.cn//tag/array)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Jump Game II](../jump-game-ii/README_EN.md)
