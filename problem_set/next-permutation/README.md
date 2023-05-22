
| [English](README_EN.md) | 简体中文 |

# [31. 下一个排列](https://leetcode.cn//problems/next-permutation/)

## 题目描述

<p>整数数组的一个 <strong>排列</strong>&nbsp; 就是将其所有成员以序列或线性顺序排列。</p>

<ul>
	<li>例如，<code>arr = [1,2,3]</code> ，以下这些都可以视作 <code>arr</code> 的排列：<code>[1,2,3]</code>、<code>[1,3,2]</code>、<code>[3,1,2]</code>、<code>[2,3,1]</code> 。</li>
</ul>

<p>整数数组的 <strong>下一个排列</strong> 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 <strong>下一个排列</strong> 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。</p>

<ul>
	<li>例如，<code>arr = [1,2,3]</code> 的下一个排列是 <code>[1,3,2]</code> 。</li>
	<li>类似地，<code>arr = [2,3,1]</code> 的下一个排列是 <code>[3,1,2]</code> 。</li>
	<li>而 <code>arr = [3,2,1]</code> 的下一个排列是 <code>[1,2,3]</code> ，因为 <code>[3,2,1]</code> 不存在一个字典序更大的排列。</li>
</ul>

<p>给你一个整数数组 <code>nums</code> ，找出 <code>nums</code> 的下一个排列。</p>

<p>必须<strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank"> 原地 </a></strong>修改，只允许使用额外常数空间。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[1,3,2]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,2,1]
<strong>输出：</strong>[1,2,3]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,5]
<strong>输出：</strong>[1,5,1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 100</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 下一个排列 (Next Permutation)
// @Author: robert.sunq
// @Date: 2021-06-02 23:42:18
// @Runtime: 1 ms
// @Memory: 38.7 MB

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        int j = nums.length-1;
        int k = nums.length-1;
        // 从后往前找到第一队 相对增序 即 nums[i]<nums[j]
        while( i >=0 && nums[i] >= nums[j] ){
            i--;
            j--;
        }
        if(i < 0) {
            recur(nums,0,nums.length-1);
            return;
        }else{
            // 从后往前找到第一个大于nums[i]的数， 及刚刚找到的相对最小的数。
            while(k>=j && nums[i] >= nums[k]){
                k--;
            }
            int temp = nums[k];
            nums[k] = nums[i];
            nums[i] = temp; 
            recur(nums,j,nums.length-1);
            return;
        }
    }

    // 反转序列
    void recur(int[] nums,int i,int j ){
        if(i>= j ) return;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j--;
            i++;
        }
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [双指针](https://leetcode.cn//tag/two-pointers)

## 相似题目


- [全排列](../permutations/README.md)
- [全排列 II](../permutations-ii/README.md)
- [排列序列](../permutation-sequence/README.md)
- [回文排列 II](../palindrome-permutation-ii/README.md)
