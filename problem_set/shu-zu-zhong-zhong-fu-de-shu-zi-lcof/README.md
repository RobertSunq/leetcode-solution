
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 03. 数组中重复的数字](https://leetcode.cn//problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)

## 题目描述

<p>找出数组中重复的数字。</p>

<p><br>
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>
[2, 3, 1, 0, 2, 5, 3]
<strong>输出：</strong>2 或 3 
</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>2 &lt;= n &lt;= 100000</code></p>


## 题解


### Java

```Java
// @Title: 数组中重复的数字 (数组中重复的数字 LCOF)
// @Author: robert.sunq
// @Date: 2023-02-02 22:35:05
// @Runtime: 0 ms
// @Memory: 48.4 MB

class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            int index = nums[i];
             if (i == index){
                continue;
            }
            if (nums[index] == index){
                return index;
            }
            int tmp = nums[index];
            nums[index] = index;
            nums[i] = tmp;
            i--;
        }
        return -1;
    }
}
```



### C++

```C++
// @Title: 数组中重复的数字 (数组中重复的数字 LCOF)
// @Author: robert.sunq
// @Date: 2020-03-21 14:46:52
// @Runtime: 88 ms
// @Memory: 29.5 MB

class Solution {
public:
    int findRepeatNumber(vector<int>& nums) {
        int len = nums.size();
        map<int ,int> mp;
        for(int i=0;i<len;i++){
            mp[nums[i]]++;
            if(mp[nums[i]] > 1) return nums[i];
        }
        return -1;
        

    }
};
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目



