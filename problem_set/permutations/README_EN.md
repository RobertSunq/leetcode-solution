
| English | [简体中文](README.md) |

# [46. Permutations](https://leetcode.cn//problems/permutations/)

## Description

<p>Given an array <code>nums</code> of distinct integers, return <em>all the possible permutations</em>. You can return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [0,1]
<strong>Output:</strong> [[0,1],[1,0]]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [1]
<strong>Output:</strong> [[1]]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 6</code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
	<li>All the integers of <code>nums</code> are <strong>unique</strong>.</li>
</ul>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Backtracking](https://leetcode.cn//tag/backtracking)

## Similar Questions

- [Next Permutation](../next-permutation/README_EN.md)
- [Permutations II](../permutations-ii/README_EN.md)
- [Permutation Sequence](../permutation-sequence/README_EN.md)
- [Combinations](../combinations/README_EN.md)
