
| English | [简体中文](README.md) |

# [剑指 Offer II 053. 二叉搜索树中的中序后继](https://leetcode.cn//problems/P5rCT8/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 二叉搜索树中的中序后继 (二叉搜索树中的中序后继)
// @Author: robert.sunq
// @Date: 2023-07-09 23:29:09
// @Runtime: 5 ms
// @Memory: 42.9 MB

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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;

        // 非递归形式的 中序 dfs 
        while (!st.isEmpty() || cur != null) {
            while(cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            if (pre == p) {
                return cur;
            }
            pre = cur;
            cur = cur.right;
        }
        return null;
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Binary Search Tree](https://leetcode.cn//tag/binary-search-tree)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


