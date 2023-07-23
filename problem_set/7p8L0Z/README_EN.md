
| English | [简体中文](README.md) |

# [剑指 Offer II 084. 含有重复元素集合的全排列 ](https://leetcode.cn//problems/7p8L0Z/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 含有重复元素集合的全排列  (含有重复元素集合的全排列 )
// @Author: robert.sunq
// @Date: 2023-07-23 23:06:02
// @Runtime: 1 ms
// @Memory: 42.8 MB

class Solution {

    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        vis = new boolean[nums.length];

        Arrays.sort(nums);

        dfs(ans, tmp, nums, 0);
        return ans;
    }


    // 表示结果列中 index 需要填入一个数字
    private void dfs(List<List<Integer>> ans, List<Integer> tmp, int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            // 当前节点已经被访问了， 或者说从左往右第一个未被填过的数字
            // 注意 !vis[i - 1] 是为了保证 从左往右第一个违背填， 前一个没有被vis的化，后一个这里就是ture
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            
            tmp.add(nums[i]);
            vis[i] = true;
            dfs(ans, tmp, nums, index + 1);
            
            // 恢复现场,  配合循环的第一个条件，后续的相同元素都不会再被填入到 index 位置
            vis[i] = false;
            tmp.remove(index);
        }


    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Backtracking](https://leetcode.cn//tag/backtracking)

## Similar Questions


