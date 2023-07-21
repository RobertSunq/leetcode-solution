
| English | [简体中文](README.md) |

# [剑指 Offer II 081. 允许重复选择元素的组合](https://leetcode.cn//problems/Ygoe9J/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 允许重复选择元素的组合 (允许重复选择元素的组合)
// @Author: robert.sunq
// @Date: 2023-07-21 22:21:40
// @Runtime: 3 ms
// @Memory: 42.7 MB

class Solution {

    List<Integer> tmp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0, candidates, target);

        return ans;
    }

    public void dfs(int index, int[] candidates, int target) {
        if (index == candidates.length) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        // 跳过当前元素
        dfs(index + 1, candidates, target);
        // 使用当前元素
        if (target - candidates[index] >= 0) {
            tmp.add(candidates[index]);
            // 注意，这里索引没有+1， 是因为可以重复选择当前数字
            dfs(index, candidates, target - candidates[index]);
            // 计算后，从缓存中移除
            tmp.remove(tmp.size() - 1);
        }
     }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Backtracking](https://leetcode.cn//tag/backtracking)

## Similar Questions


