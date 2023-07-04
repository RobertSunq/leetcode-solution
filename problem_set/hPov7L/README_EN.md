
| English | [简体中文](README.md) |

# [剑指 Offer II 044. 二叉树每层的最大值](https://leetcode.cn//problems/hPov7L/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 二叉树每层的最大值 (二叉树每层的最大值)
// @Author: robert.sunq
// @Date: 2023-07-04 23:15:48
// @Runtime: 2 ms
// @Memory: 43 MB

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        // 记录当前需要遍历的层的节点数
        int n = 1;
        // 记录下一层的节点数
        int nextN = 0;
        q.add(root);
        TreeNode p;
        int min = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            nextN = 0;
            min = Integer.MIN_VALUE;
            while (n-- > 0) {
                p = q.poll();
                min = Math.max(min, p.val);
                if (p.left != null) {
                    q.add(p.left);
                    nextN++;
                }
                if (p.right != null) {
                    q.add(p.right);
                    nextN++;
                }
            }
            ans.add(min);
            n = nextN;
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


