
| English | [简体中文](README.md) |

# [剑指 Offer II 082. 含有重复元素集合的组合](https://leetcode.cn//problems/4sjJUc/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Backtracking](https://leetcode.cn//tag/backtracking)

## Similar Questions


