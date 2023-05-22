
| English | [简体中文](README.md) |

# [剑指 Offer 26. 树的子结构  LCOF](https://leetcode.cn//problems/shu-de-zi-jie-gou-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 树的子结构 (树的子结构  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-26 23:12:06
// @Runtime: 5 ms
// @Memory: 40.2 MB

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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        LinkedList<TreeNode> st = new LinkedList<>();
        TreeNode p = A;
        // 根节点入栈
        st.addLast(A);
        while (!st.isEmpty()){
            p = st.removeLast();
            if(p.val == B.val){
                if(isEqualsTree(p,B)){
                    return true;
                }
            }
            if(p.right != null) st.addLast(p.right);
            if(p.left != null) st.addLast(p.left);
        }
        return false;
    }

    boolean isEqualsTree(TreeNode A, TreeNode B){
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        // 比较左右子树
        return isEqualsTree(A.left,B.left) && isEqualsTree(A.right,B.right);
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


