
| English | [简体中文](README.md) |

# [剑指 Offer 27. 二叉树的镜像  LCOF](https://leetcode.cn//problems/er-cha-shu-de-jing-xiang-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 二叉树的镜像 (二叉树的镜像  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-26 23:16:36
// @Runtime: 0 ms
// @Memory: 36.1 MB

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        // 直接交换左右子树
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        // 采用递归发遍历
        mirrorTree(root.right);
        mirrorTree(root.left);
        // 返回当前节点
        return root;
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


