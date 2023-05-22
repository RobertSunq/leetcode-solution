
| English | [简体中文](README.md) |

# [剑指 Offer 28. 对称的二叉树  LCOF](https://leetcode.cn//problems/dui-cheng-de-er-cha-shu-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 对称的二叉树 (对称的二叉树  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-26 23:32:17
// @Runtime: 0 ms
// @Memory: 36.6 MB

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        // 左子树 右子树进行对比
        return recur(root.left,root.right);
    }
    boolean recur(TreeNode r1,TreeNode r2){
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        if(r1.val == r2.val){
            // 两棵树的 左子树和右子树 交叉对比
            return recur(r1.left,r2.right) && recur(r1.right,r2.left);
        }else{
            return false;
        }
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


