
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 079. 所有子集](https://leetcode.cn//problems/TVdhkn/)

## 题目描述

<p>给定一个整数数组&nbsp;<code>nums</code> ，数组中的元素 <strong>互不相同</strong> 。返回该数组所有可能的子集（幂集）。</p>

<p>解集 <strong>不能</strong> 包含重复的子集。你可以按 <strong>任意顺序</strong> 返回解集。</p>

<p>&nbsp;</p>

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

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10</code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
	<li><code>nums</code> 中的所有元素 <strong>互不相同</strong></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 78&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/subsets/">https://leetcode-cn.com/problems/subsets/</a></p>


## 题解


### Java

```Java
// @Title: 所有子集 (所有子集)
// @Author: robert.sunq
// @Date: 2023-07-20 23:02:56
// @Runtime: 0 ms
// @Memory: 40.5 MB

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }


    public List<List<Integer>> subsets(int[] nums, int index) {
        if (index >= nums.length) {
            List<Integer> tmp = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(tmp);
            return ans;
        }

        List<List<Integer>> ans = subsets(nums, index + 1);
        int n = ans.size();
        for (int i = 0 ; i < n; i++) {
            List<Integer> tmp = new ArrayList<>(ans.get(i));
            tmp.add(nums[index]);
            ans.add(tmp);
        }

        return ans;
    }
}
```



## 相关话题

- [位运算](https://leetcode.cn//tag/bit-manipulation)
- [数组](https://leetcode.cn//tag/array)
- [回溯](https://leetcode.cn//tag/backtracking)

## 相似题目



