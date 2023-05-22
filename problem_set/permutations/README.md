
| [English](README_EN.md) | 简体中文 |

# [46. 全排列](https://leetcode.cn//problems/permutations/)

## 题目描述

<p>给定一个不含重复数字的数组 <code>nums</code> ，返回其 <em>所有可能的全排列</em> 。你可以 <strong>按任意顺序</strong> 返回答案。</p>

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


## 题解


### Java

```Java
// @Title: 全排列 (Permutations)
// @Author: robert.sunq
// @Date: 2021-06-03 23:22:11
// @Runtime: 2 ms
// @Memory: 38.6 MB

class Solution {
    int[] dict;
    int N;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        this.dict = nums;
        this.N = nums.length;
        dfs(0);
        return res;

    }

    void dfs(int x){
        if(x == N){

            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<this.N;i++){
                temp.add(dict[i]);
            }
            res.add(temp);
            return;
        }
        // 防止同一层递归中出现交换重复的元素
        HashSet<Integer> set = new HashSet<>();
        for(int i = x;i<this.N;i++){
            if(set.contains(dict[i])){
                continue;
            }
            set.add(dict[i]);
            // 交换顺序
            int temp = dict[x];
            dict[x] = dict[i];
            dict[i] = temp;
            dfs(x+1);
            // 恢复原状
            dict[i] = dict[x];
            dict[x] = temp;
        }
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [回溯](https://leetcode.cn//tag/backtracking)

## 相似题目


- [下一个排列](../next-permutation/README.md)
- [全排列 II](../permutations-ii/README.md)
- [排列序列](../permutation-sequence/README.md)
- [组合](../combinations/README.md)
