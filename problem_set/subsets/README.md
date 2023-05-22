
| [English](README_EN.md) | 简体中文 |

# [78. 子集](https://leetcode.cn//problems/subsets/)

## 题目描述

<p>给你一个整数数组 <code>nums</code> ，数组中的元素 <strong>互不相同</strong> 。返回该数组所有可能的子集（幂集）。</p>

<p>解集 <strong>不能</strong> 包含重复的子集。你可以按 <strong>任意顺序</strong> 返回解集。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0]
<strong>输出：</strong>[[],[0]]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10</code></li>
	<li><code>-10 <= nums[i] <= 10</code></li>
	<li><code>nums</code> 中的所有元素 <strong>互不相同</strong></li>
</ul>


## 题解


### Java

```Java
// @Title: 子集 (Subsets)
// @Author: robert.sunq
// @Date: 2021-06-05 23:15:46
// @Runtime: 1 ms
// @Memory: 38.3 MB

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length-1;
        List<List<Integer>> res = recur(nums,len);
        return res;
    }

    List<List<Integer>> recur(int[] nums , int end){
        // List<List<Integer>> res = new ArrayList<>();
        if(end < 0) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            res.add(temp);
            return res;
        }
        List<List<Integer>> res = recur(nums,end-1);
        int i = 0;
        int len = res.size();
        while(i<len){

            List<Integer> temp = new ArrayList<>(res.get(i));
            // ArrayList<Integer> temp1 = new ArrayList<>(temp);
            // 放入当前位置的字符
            temp.add(nums[end]);
            res.add(temp);
            i++;
        }
        return res;
    }
}
```



## 相关话题

- [位运算](https://leetcode.cn//tag/bit-manipulation)
- [数组](https://leetcode.cn//tag/array)
- [回溯](https://leetcode.cn//tag/backtracking)

## 相似题目


- [子集 II](../subsets-ii/README.md)
- [列举单词的全部缩写](../generalized-abbreviation/README.md)
- [字母大小写全排列](../letter-case-permutation/README.md)
