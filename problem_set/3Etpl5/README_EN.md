
| English | [简体中文](README.md) |

# [剑指 Offer II 049. 从根节点到叶节点的路径数字之和](https://leetcode.cn//problems/3Etpl5/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 从根节点到叶节点的路径数字之和 (从根节点到叶节点的路径数字之和)
// @Author: robert.sunq
// @Date: 2023-07-06 22:37:45
// @Runtime: 0 ms
// @Memory: 38.9 MB

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

    int number = 0;
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }

        // 注意，当为叶子节点的时候，就可以求和了
        // 当前叶子节点没有放入列表
        if (root.left == null && root.right == null) {
            sum = sum + number * 10 + root.val;
            return sum;
        }

        // 非叶子节点，放入列表投入计算
        number = number * 10 + root.val;

        // 如果左子树不为空，则取dfs 左子树, 因为叶子节点不会放入缓存列表，所以不用担心节点上的数值被多次计算 
        if (root.left != null) {
            sumNumbers(root.left);
        }
        if (root.right != null) {
            sumNumbers(root.right);
        }

        // 左右子树递归完成， 要删除数值最后一位，就是从缓存中删除当前节点
        number = number / 10;
        return sum;
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


