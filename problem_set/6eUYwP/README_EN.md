
| English | [简体中文](README.md) |

# [剑指 Offer II 050. 向下的路径节点之和](https://leetcode.cn//problems/6eUYwP/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 向下的路径节点之和 (向下的路径节点之和)
// @Author: robert.sunq
// @Date: 2023-07-09 21:56:22
// @Runtime: 2 ms
// @Memory: 41.9 MB

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // key 表示 前缀和， value 表示 次数
    private Map<Long, Integer> preSumCount = new HashMap<>();

    private int targetSum;
    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;

        // 同 https://leetcode.cn/problems/QTMn0o/description/

        // 记录前缀和， 注意这里，初始设置前缀和为 0 的个数为 1， 则后面其他节点前缀和 - targetSum = 0时，可以直接计数为 1，不用单独加1
        preSumCount.put(0L, 1);
        
        return dfs(root, 0L);
    }

    private int dfs(TreeNode root, long curSum) {
        if (root == null) {
            return 0;
        }

        int  res = 0;
        curSum = curSum + root.val;

        // 当前前缀和 和 减去 目标值的差， 如果存在于map中，则说明从某一个点到当前点的和 等于目标值
        res = res + preSumCount.getOrDefault(curSum - targetSum, 0);

        // 将当前的前缀和也加入map
        preSumCount.put(curSum, preSumCount.getOrDefault(curSum, 0) + 1);

        // 递归左右子树
        res = res + dfs(root.left, curSum);
        res = res + dfs(root.right, curSum);

        // 遍历完当前节点后，从前缀和计数中删除当前节点，避免重复计算
        preSumCount.put(curSum, preSumCount.get(curSum) - 1);

        return res;
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


