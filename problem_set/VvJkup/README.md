
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 083. 没有重复元素集合的全排列](https://leetcode.cn//problems/VvJkup/)

## 题目描述

<p>给定一个不含重复数字的整数数组 <code>nums</code> ，返回其 <strong>所有可能的全排列</strong> 。可以 <strong>按任意顺序</strong> 返回答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1]
<strong>输出：</strong>[[0,1],[1,0]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1]
<strong>输出：</strong>[[1]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 6</code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
	<li><code>nums</code> 中的所有整数 <strong>互不相同</strong></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 46&nbsp;题相同：<a href="https://leetcode-cn.com/problems/permutations/">https://leetcode-cn.com/problems/permutations/</a>&nbsp;</p>


## 题解


### Java

```Java
// @Title: 没有重复元素集合的全排列 (没有重复元素集合的全排列)
// @Author: robert.sunq
// @Date: 2023-07-22 23:29:21
// @Runtime: 1 ms
// @Memory: 42.4 MB

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int n:nums) {
            tmp.add(n);
        }

        dfs(ans, tmp, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> nums, int index) {
        if (index == nums.size()) {
            ans.add(new ArrayList<>(nums));
            return;
        }

        // 注意从 index 开始， 即，先将当前节点算为结果
        for (int i = index; i< nums.size(); i++) {
            int tmp = nums.get(index);
            // 交换, 将 第 i 位放到当前位置， 所谓结果序列
            nums.set(index, nums.get(i));
            nums.set(i, tmp);
            
            // 继续迭代 下一个节点
            dfs(ans, nums, index + 1);

            // 换回
            nums.set(i, nums.get(index));
            nums.set(index, tmp);
        }
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [回溯](https://leetcode.cn//tag/backtracking)

## 相似题目



