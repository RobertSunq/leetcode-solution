
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 082. 含有重复元素集合的组合](https://leetcode.cn//problems/4sjJUc/)

## 题目描述

<p>给定一个可能有重复数字的整数数组&nbsp;<code>candidates</code>&nbsp;和一个目标数&nbsp;<code>target</code>&nbsp;，找出&nbsp;<code>candidates</code>&nbsp;中所有可以使数字和为&nbsp;<code>target</code>&nbsp;的组合。</p>

<p><code>candidates</code>&nbsp;中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。&nbsp;</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入:</strong> candidates =&nbsp;<code>[10,1,2,7,6,1,5]</code>, target =&nbsp;<code>8</code>,
<strong>输出:</strong>
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> candidates =&nbsp;[2,5,2,1,2], target =&nbsp;5,
<strong>输出:</strong>
[
[1,2,2],
[5]
]</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;candidates.length &lt;= 100</code></li>
	<li><code>1 &lt;=&nbsp;candidates[i] &lt;= 50</code></li>
	<li><code>1 &lt;= target &lt;= 30</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 40&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/combination-sum-ii/">https://leetcode-cn.com/problems/combination-sum-ii/</a></p>


## 题解


### Java

```Java
// @Title: 含有重复元素集合的组合 (含有重复元素集合的组合)
// @Author: robert.sunq
// @Date: 2023-07-21 23:10:26
// @Runtime: 1077 ms
// @Memory: 43.1 MB

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        dfs(0, candidates, target, ans, tmp);
        return ans;
    }


    private void dfs(int index, int[] candidates, int target, List<List<Integer>> ans, List<Integer> tmp) {

        // 注意和上一道题不一样的是，这里要先判断是不是符合要求，
        // 因为如果最后一个数字参与计算，此时 index = size。 如果先判断索引，会导致数据缺失
        if (target == 0) {
            for (List<Integer> list : ans) {
                if (equals(list, tmp)) {
                    return;
                }
            }
            ans.add(new ArrayList<>(tmp));
            return;
        }

        if (index == candidates.length) {
            return;
        }

        // 当前数字不放入队列
        dfs(index + 1, candidates, target, ans, tmp);

        // 放入,
        if (target - candidates[index] >= 0) {
            tmp.add(candidates[index]);
            dfs(index + 1, candidates, target - candidates[index], ans, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }


    private boolean equals(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : list1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : list2) {
            if (!map.containsKey(n)) {
                return false;
            }
            map.put(n , map.get(n) - 1);
        }
        for (int n : map.keySet()) {
            if (map.get(n) != 0) {
                return false;
            }
        }
        return true;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [回溯](https://leetcode.cn//tag/backtracking)

## 相似题目



