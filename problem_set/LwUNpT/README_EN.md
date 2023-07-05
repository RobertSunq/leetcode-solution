
| English | [简体中文](README.md) |

# [剑指 Offer II 045. 二叉树最底层最左边的值](https://leetcode.cn//problems/LwUNpT/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 二叉树最底层最左边的值 (二叉树最底层最左边的值)
// @Author: robert.sunq
// @Date: 2023-07-05 21:37:17
// @Runtime: 1 ms
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
    public int findBottomLeftValue(TreeNode root) {
        TreeNode left, right, p;
        Queue<TreeNode> q = new ArrayDeque<>();

        int ans = 0;
        q.offer(root);
        int size = 0;
        while (!q.isEmpty()) {
            size = q.size();
            ans = q.peek().val;
            while (size-- > 0) {
                p = q.poll();
                if (p.left != null) {
                    q.offer(p.left);
                }
                if (p.right != null) {
                    q.offer(p.right);
                }
            }
        }

        return ans;

    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


