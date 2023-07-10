
| English | [简体中文](README.md) |

# [剑指 Offer II 054. 所有大于等于节点的值之和](https://leetcode.cn//problems/w6cpku/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 所有大于等于节点的值之和 (所有大于等于节点的值之和)
// @Author: robert.sunq
// @Date: 2023-07-10 22:40:13
// @Runtime: 0 ms
// @Memory: 42.6 MB

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

    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    // 先右子树，再是中，最后左
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.right);

        root.val = sum + root.val;
        sum = root.val;

        dfs(root.left);
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Binary Search Tree](https://leetcode.cn//tag/binary-search-tree)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


