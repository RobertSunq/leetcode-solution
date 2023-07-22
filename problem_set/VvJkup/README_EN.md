
| English | [简体中文](README.md) |

# [剑指 Offer II 083. 没有重复元素集合的全排列](https://leetcode.cn//problems/VvJkup/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Backtracking](https://leetcode.cn//tag/backtracking)

## Similar Questions


