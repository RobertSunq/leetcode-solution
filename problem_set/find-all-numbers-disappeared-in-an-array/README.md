
| [English](README_EN.md) | 简体中文 |

# [448. 找到所有数组中消失的数字](https://leetcode.cn//problems/find-all-numbers-disappeared-in-an-array/)

## 题目描述

<p>给你一个含 <code>n</code> 个整数的数组 <code>nums</code> ，其中 <code>nums[i]</code> 在区间 <code>[1, n]</code> 内。请你找出所有在 <code>[1, n]</code> 范围内但没有出现在 <code>nums</code> 中的数字，并以数组的形式返回结果。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [4,3,2,7,8,2,3,1]
<strong>输出：</strong>[5,6]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1]
<strong>输出：</strong>[2]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 <= n <= 10<sup>5</sup></code></li>
	<li><code>1 <= nums[i] <= n</code></li>
</ul>

<p><strong>进阶：</strong>你能在不使用额外空间且时间复杂度为<em> </em><code>O(n)</code><em> </em>的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。</p>


## 题解


### Java

```Java
// @Title: 找到所有数组中消失的数字 (Find All Numbers Disappeared in an Array)
// @Author: robert.sunq
// @Date: 2021-06-21 22:35:47
// @Runtime: 7 ms
// @Memory: 47.4 MB

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i =0;
        while(i<nums.length){
            // 如果位置下标与数字对应 或者 位置该下标对应的数字不存在跳过
            if(nums[i] == i+1 || nums[i] == -1) {
                i++;
                continue;
            }
            // 即当前元素与其对应下标位置的元素重复，将当前位置赋值为 -1，表示暂时该下标对应的数字缺失;
            if(nums[i] == nums[nums[i] - 1]){
                nums[i] = -1;
                i++;
            }else{
                // 否则，交换位置 ， 使得目标位置的下标与数字相同
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }
        for(i = 0;i<nums.length;i++){
            if(nums[i] == -1) res.add(i+1);
        }
        return res;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)

## 相似题目


- [缺失的第一个正数](../first-missing-positive/README.md)
- [数组中重复的数据](../find-all-duplicates-in-an-array/README.md)
