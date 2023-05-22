
| [English](README_EN.md) | 简体中文 |

# [55. 跳跃游戏](https://leetcode.cn//problems/jump-game/)

## 题目描述

<p>给定一个非负整数数组 <code>nums</code> ，你最初位于数组的 <strong>第一个下标</strong> 。</p>

<p>数组中的每个元素代表你在该位置可以跳跃的最大长度。</p>

<p>判断你是否能够到达最后一个下标。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,3,1,1,4]
<strong>输出：</strong>true
<strong>解释：</strong>可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,2,1,0,4]
<strong>输出：</strong>false
<strong>解释：</strong>无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 3 * 10<sup>4</sup></code></li>
	<li><code>0 <= nums[i] <= 10<sup>5</sup></code></li>
</ul>


## 题解


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



## 相关话题

- [贪心](https://leetcode.cn//tag/greedy)
- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目


- [跳跃游戏 II](../jump-game-ii/README.md)
