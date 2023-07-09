
| English | [简体中文](README.md) |

# [剑指 Offer II 052. 展平二叉搜索树](https://leetcode.cn//problems/NYBBNL/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 展平二叉搜索树 (展平二叉搜索树)
// @Author: robert.sunq
// @Date: 2023-07-09 22:54:12
// @Runtime: 0 ms
// @Memory: 38.7 MB

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

    TreeNode head = null;
    // 尾节点
    TreeNode tail = null;
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);

        return head;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        // 中序遍历
        dfs(root.left);
        
        // 暂存右节点，避免丢失
        TreeNode right = root.right;
        if (head == null) {
            head = root;
            tail = root;
            tail.right = null;
        } else {
            root.left = null;
            root.right = null;
            tail.right = root;
            tail = root;
        }

        // 注意，这里使用的时之前缓存的节点信息
        dfs(right);
    }
}
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Binary Search Tree](https://leetcode.cn//tag/binary-search-tree)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


