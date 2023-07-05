
| English | [简体中文](README.md) |

# [剑指 Offer II 046. 二叉树的右侧视图](https://leetcode.cn//problems/WNC0Lk/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 二叉树的右侧视图 (二叉树的右侧视图)
// @Author: robert.sunq
// @Date: 2023-07-05 21:42:18
// @Runtime: 1 ms
// @Memory: 40.2 MB

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
    public List<Integer> rightSideView(TreeNode root) {
        TreeNode left, right, p;
        Queue<TreeNode> q = new ArrayDeque<>();

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        q.offer(root);
        int size = 0;
        while (!q.isEmpty()) {
            size = q.size();
            result.add(q.peek().val);
            while (size-- > 0) {
                p = q.poll();
                // 先放右侧节点， 就是从右往左的广度遍历
                if (p.right != null) {
                    q.offer(p.right);
                }
                if (p.left != null) {
                    q.offer(p.left);
                }
            }
        }

        return result;
    }
}
```



## Related Topics

- [Tree](https://leetcode.cn//tag/tree)
- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)

## Similar Questions


