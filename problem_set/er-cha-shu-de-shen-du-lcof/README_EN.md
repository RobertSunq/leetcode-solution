
| English | [简体中文](README.md) |

# [剑指 Offer 55 - I. 二叉树的深度 LCOF](https://leetcode.cn//problems/er-cha-shu-de-shen-du-lcof/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 二叉树的深度 (二叉树的深度 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 18:01:24
// @Runtime: 0 ms
// @Memory: 38.4 MB

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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) +1;
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


