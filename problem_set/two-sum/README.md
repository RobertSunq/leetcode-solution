
| [English](README_EN.md) | 简体中文 |

# [1. 两数之和](https://leetcode.cn//problems/two-sum/)

## 题目描述

<p>给定一个整数数组 <code>nums</code>&nbsp;和一个整数目标值 <code>target</code>，请你在该数组中找出 <strong>和为目标值 </strong><em><code>target</code></em>&nbsp; 的那&nbsp;<strong>两个</strong>&nbsp;整数，并返回它们的数组下标。</p>

<p>你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。</p>

<p>你可以按任意顺序返回答案。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,7,11,15], target = 9
<strong>输出：</strong>[0,1]
<strong>解释：</strong>因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,2,4], target = 6
<strong>输出：</strong>[1,2]
</pre>

<p><strong class="example">示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,3], target = 6
<strong>输出：</strong>[0,1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
	<li><strong>只会存在一个有效答案</strong></li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你可以想出一个时间复杂度小于 <code>O(n<sup>2</sup>)</code> 的算法吗？</p>


## 题解


### Java

```Java
// @Title: 两数之和 (Two Sum)
// @Author: robert.sunq
// @Date: 2021-06-01 00:19:00
// @Runtime: 2 ms
// @Memory: 38.5 MB

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0 ;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    void quickSort(int[] nums , int start,int end){
        if(start >= end) return;
        // 哨兵
        int i = start,j=end;
        int temp = nums[i];
        while(i < j){
            while(j>i && nums[j]>=temp) j--;
            if(j>i) nums[i] = nums[j];
            while(i<j && nums[i] <= temp) i++;
            if(i < j) nums[j] = nums[i];
        }

    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)

## 相似题目


- [三数之和](../3sum/README.md)
- [四数之和](../4sum/README.md)
- [两数之和 II - 输入有序数组](../two-sum-ii-input-array-is-sorted/README.md)
- [两数之和 III - 数据结构设计](../two-sum-iii-data-structure-design/README.md)
- [和为 K 的子数组](../subarray-sum-equals-k/README.md)
- [两数之和 IV - 输入二叉搜索树](../two-sum-iv-input-is-a-bst/README.md)
- [小于 K 的两数之和](../two-sum-less-than-k/README.md)
