
| [English](README_EN.md) | 简体中文 |

# [41. 缺失的第一个正数](https://leetcode.cn//problems/first-missing-positive/)

## 题目描述

<p>给你一个未排序的整数数组 <code>nums</code> ，请你找出其中没有出现的最小的正整数。</p>
请你实现时间复杂度为 <code>O(n)</code> 并且只使用常数级别额外空间的解决方案。

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,0]
<strong>输出：</strong>3
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,4,-1,1]
<strong>输出：</strong>2
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [7,8,9,11,12]
<strong>输出：</strong>1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 5 * 10<sup>5</sup></code></li>
	<li><code>-2<sup>31</sup> <= nums[i] <= 2<sup>31</sup> - 1</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 缺失的第一个正数 (First Missing Positive)
// @Author: robert.sunq
// @Date: 2021-07-11 21:25:09
// @Runtime: 3 ms
// @Memory: 94 MB

class Solution {
    public int firstMissingPositive(int[] nums) {
        int i  = 0;
        // 使用元素自身作为hash表
        // 将元素 i位置放上数字 i + 1;
        // 
        while (i < nums.length){
            // 只处理可以映射到 nums上的正整数，因为大于nums.length的 其最小正整数肯定小于数组长度
            if(nums[i] < 1 || nums[i] > nums.length || nums[i] -1 == i || nums[nums[i] -1] == nums[i]){
                i++;
                continue;
            }
            // 将nums[i] 放到nums[ nums[i] - 1] 上
            int temp = nums[nums[i]-1];
            nums[nums[i]-1] = nums[i];
            nums[i] = temp; 
        }
        i = 0;
        // 此时 再数据中，value和下标不对应的 就是第一个最小正整数
        while(i < nums.length){
            if(nums[i] -1 != i){
                return i+1;
            }
            i++;
        }
        return i+1;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)

## 相似题目


- [丢失的数字](../missing-number/README.md)
- [寻找重复数](../find-the-duplicate-number/README.md)
- [找到所有数组中消失的数字](../find-all-numbers-disappeared-in-an-array/README.md)
- [情侣牵手](../couples-holding-hands/README.md)
